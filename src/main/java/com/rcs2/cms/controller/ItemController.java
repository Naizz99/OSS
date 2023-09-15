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

import com.rcs2.cms.model.Item;
import com.rcs2.cms.model.Order;
import com.rcs2.cms.model.User;
import com.rcs2.cms.service.ItemService;
import com.rcs2.cms.service.OrderService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private OrderService orderService;

	@RequestMapping("/listItems")
	public ModelAndView listItems(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("admin/item-list");
		
	    List<Item> itemList = itemService.findAll();
	    mav.addObject("itemList", itemList);
	    
	    User user = (User)session.getAttribute("user");
	    mav.addObject("user", user);
		
	    return mav;
	}
	
	@GetMapping("/updateItem")
	public ModelAndView updateItem(@RequestParam Long itemId, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("admin/item-form");
		
		User user = (User)session.getAttribute("user");
		mav.addObject("user", user);
		
		Item item = itemService.findById(itemId);
		mav.addObject("item", item);
		
		return mav;
	}
	
	@GetMapping("/addItem")
	public ModelAndView addItem(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("admin/item-form");
		
		User user = (User)session.getAttribute("user");
		mav.addObject("user", user);
		
		Item item = new Item();
		item.setCreateBy(user.getUsername());
		item.setCreateDate(LocalDate.now());
		item.setUpdateBy(user.getUsername());
		item.setUpdateDate(LocalDate.now());
		mav.addObject("item", item);
		
		return mav;
	}
	
	@PostMapping("/saveItem")
	public ResponseEntity<String> saveItem(@ModelAttribute Item item,HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		
		item.setUpdateBy(user.getUsername());
		item.setUpdateDate(LocalDate.now());
		itemService.save(item);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@GetMapping("/deleteItem")
	public ResponseEntity<String> deleteItem(@RequestParam Long itemId) {

		boolean hasRelation = false;
		
		List<Order> orderList = orderService.findByItem(itemId);
		for (Order order : orderList) 
		{
			if((order.getItem().getItemId()).equals(itemId)) {
				hasRelation = true;
				break;
			}
		}
		
		if(hasRelation) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			itemService.delete(itemId);			
			return new ResponseEntity<>("success", HttpStatus.OK);
		}
	}
	
	@GetMapping("/itemDeactive")
	public String itemDeactive(@RequestParam Long itemId) {
		Item item = itemService.findById(itemId);
		item.setStatus(Item.Status.DEACTIVE);
		itemService.save(item);
		return "redirect:/listItems";
	}
	
	@GetMapping("/itemActive")
	public String itemActive(@RequestParam Long itemId) {
		Item item = itemService.findById(itemId);
		item.setStatus(Item.Status.ACTIVE);
		itemService.save(item);
		return "redirect:/listItems";
	}
}
