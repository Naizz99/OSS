package com.rcs2.cms.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rcs2.cms.model.Order;
import com.rcs2.cms.model.User;
import com.rcs2.cms.service.ItemService;
import com.rcs2.cms.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private OrderService orderService;

	@RequestMapping("/listOrders")
	public ModelAndView listOrders(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("admin/order-list");
		
	    List<Order> orderList = orderService.findAll();
	    mav.addObject("orderList", orderList);
	    
	    User user = (User)session.getAttribute("user");
	    mav.addObject("user", user);
		
	    return mav;
	}
	
	@GetMapping("/updateOrder")
	public ModelAndView updateOrder(@RequestParam Long orderId, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("admin/order-form");
		
		User user = (User)session.getAttribute("user");
		mav.addObject("user", user);
		
		Order order = orderService.findById(orderId);
		mav.addObject("order", order);
		
		return mav;
	}
	
	@GetMapping("/addOrder")
	public ModelAndView addOrder(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("admin/order-form");
		
		User user = (User)session.getAttribute("user");
		mav.addObject("user", user);
		
		Order order = new Order();
		order.setCreateBy(user.getUsername());
		order.setCreateDate(LocalDate.now());
		order.setUpdateBy(user.getUsername());
		order.setUpdateDate(LocalDate.now());
		mav.addObject("order", order);
		
		return mav;
	}
	
	@PostMapping("/saveOrder")
	public ResponseEntity<String> saveOrder(@ModelAttribute Order order,HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		
		order.setUpdateBy(user.getUsername());
		order.setUpdateDate(LocalDate.now());
		orderService.save(order);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@GetMapping("/deleteOrder")
	public ResponseEntity<String> deleteOrder(@RequestParam Long orderId) {

		boolean hasRelation = false;
		
		if(hasRelation) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			orderService.delete(orderId);			
			return new ResponseEntity<>("success", HttpStatus.OK);
		}
	}
	
	@GetMapping("/orderDeactive")
	public String orderDeactive(@RequestParam Long orderId) {
		Order order = orderService.findById(orderId);
		//order.setStatus(Order.Status.DEACTIVE);
		orderService.save(order);
		return "redirect:/listOrders";
	}
	
	@GetMapping("/orderActive")
	public String orderActive(@RequestParam Long orderId) {
		Order order = orderService.findById(orderId);
		//order.setStatus(Order.Status.ACTIVE);
		orderService.save(order);
		return "redirect:/listOrders";
	}
}
