package com.rcs2.cms.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rcs2.cms.model.User;
import com.rcs2.cms.repository.UserRepository;
import com.rcs2.cms.model.Order;
import com.rcs2.cms.service.CustomUserDetailService;
import com.rcs2.cms.service.OrderService;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/listUsers")
	public ModelAndView listUsers(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("admin/user-list");
		
	    List<User> userList = userService.findAll();
	    mav.addObject("userList", userList);
	    
	    User user = (User)session.getAttribute("user");
	    mav.addObject("user", user);
		
	    return mav;
	}
	
	@GetMapping("/updateUser")
	public ModelAndView updateUser(@RequestParam Long userId, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("admin/user-form");
		
		User loggedUser = (User)session.getAttribute("user");
		mav.addObject("loggedUser", loggedUser);
		
		User user = userService.findById(userId).get();
		mav.addObject("user", user);
		
		return mav;
	}
	
	@GetMapping("/addUser")
	public ModelAndView addUser(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("admin/user-form");
		
		User loggedUser = (User)session.getAttribute("user");
		mav.addObject("loggedUser", loggedUser);
		
		User user = new User();
		user.setCreateBy(user.getUsername());
		user.setCreateDate(LocalDate.now());
		user.setUpdateBy(user.getUsername());
		user.setUpdateDate(LocalDate.now());
		mav.addObject("user", user);
		
		return mav;
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@ModelAttribute User user,HttpSession session) {
		
		User loggedUser = (User)session.getAttribute("user");
		
		user.setUpdateBy(user.getUsername());
		user.setUpdateDate(LocalDate.now());
		userService.save(user);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@GetMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam Long userId) {

		boolean hasRelation = false;
		
		List<Order> orderList = orderService.findByUser(userId);
		for (Order order : orderList) 
		{
			if((order.getUser().getUser()).equals(userId)) {
				hasRelation = true;
				break;
			}
		}
		
		if(hasRelation) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			userService.delete(userService.findById(userId).get());			
			return new ResponseEntity<>("success", HttpStatus.OK);
		}
	}
	
	@GetMapping("/userDeactive")
	public String userDeactive(@RequestParam Long userId) {
		User user = userService.findById(userId).get();
		user.setStatus(User.Status.DEACTIVE);
		userService.save(user);
		return "redirect:/listUsers";
	}
	
	@GetMapping("/userActive")
	public String userActive(@RequestParam Long userId) {
		User user = userService.findById(userId).get();
		user.setStatus(User.Status.ACTIVE);
		userService.save(user);
		return "redirect:/listUsers";
	}
}
