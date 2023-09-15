package com.rcs2.cms.controller;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rcs2.cms.model.Category;
import com.rcs2.cms.model.Item;
import com.rcs2.cms.model.Order;
import com.rcs2.cms.model.User;
import com.rcs2.cms.repository.UserRepository;
import com.rcs2.cms.service.CategoryService;
import com.rcs2.cms.service.ItemService;
import com.rcs2.cms.service.OrderService;

@Controller
@RequestMapping("/secure")
public class AdminController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserRepository userService;
	
	@Autowired
	private OrderService orderService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@RequestMapping("/home")
	public ModelAndView setting() {
		ModelAndView mav = new ModelAndView("admin/admin-dashboard");
		
		mav.addObject("activeCategoryCount", categoryService.countByStatus(Category.Status.ACTIVE));
		mav.addObject("itemCount", itemService.countByStatus(Item.Status.ACTIVE));
		mav.addObject("pendingOrderCount", orderService.countByStatus(Order.Status.PENDING));
		mav.addObject("userCount", userService.countByStatus(User.Status.ACTIVE));
		
		return mav;
	}
	
}
