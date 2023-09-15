package com.rcs2.cms.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rcs2.cms.model.Category;
import com.rcs2.cms.model.Item;
import com.rcs2.cms.model.User;
import com.rcs2.cms.repository.UserRepository;
import com.rcs2.cms.service.CategoryService;
import com.rcs2.cms.service.ItemService;

@Controller
public class CategoryController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/listCategories")
	public ModelAndView listCategories(Authentication authentication) {
		ModelAndView mav = new ModelAndView("admin/category-list");
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		User user = userRepository.findByUsername(userDetails.getUsername());
		mav.addObject("user", user);
		    
	    List<Category> categoryList = categoryService.findAll();
	    mav.addObject("categoryList", categoryList);
	    
	    Category category = new Category();
		category.setCreateBy(user.getUsername());
		category.setCreateDate(LocalDate.now());
		category.setUpdateBy(user.getUsername());
		category.setUpdateDate(LocalDate.now());
		mav.addObject("category", category);
		
	    return mav;
	}
	
	@PostMapping("/api/saveCategory")
	public ResponseEntity<String> saveCategory(@ModelAttribute("newCategory") Category category,Authentication authentication) {

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		User user = userRepository.findByUsername(userDetails.getUsername());
		
		if(category.getCategoryId() == null) {
			category.setUpdateBy(user.getUsername());
			category.setUpdateDate(LocalDate.now());
			category.setCreateBy(user.getUsername());
			category.setCreateDate(LocalDate.now());
			categoryService.save(category);
		}else {
			Category updatedCategory = categoryService.findById(category.getCategoryId());
			updatedCategory.setName(category.getName());
			updatedCategory.setDescription(category.getDescription());
			categoryService.save(updatedCategory);
		}
		
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@GetMapping("/api/getCategory")
	public ResponseEntity<Category> getCategory(@RequestParam Long categoryId) {
		return new ResponseEntity<>(categoryService.findById(categoryId), HttpStatus.OK);
	}
	
	@GetMapping("/deleteCategory")
	public ResponseEntity<String> deleteCategory(@RequestParam Long categoryId) {

		boolean hasRelation = false;
		
		List<Item> itemList = itemService.findByCategory(categoryId);
		for (Item item : itemList) 
		{
			if((item.getCategory().getCategoryId()).equals(categoryId)) {
				hasRelation = true;
				break;
			}
		}
		
		if(hasRelation) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			categoryService.delete(categoryId);			
			return new ResponseEntity<>("success", HttpStatus.OK);
		}
	}
	
	@GetMapping("/categoryDeactive")
	public String categoryDeactive(@RequestParam Long categoryId) {
		Category category = categoryService.findById(categoryId);
		category.setStatus(Category.Status.DEACTIVE);
		categoryService.save(category);
		return "redirect:/listCategories";
	}
	
	@GetMapping("/categoryActive")
	public String categoryActive(@RequestParam Long categoryId) {
		Category category = categoryService.findById(categoryId);
		category.setStatus(Category.Status.ACTIVE);
		categoryService.save(category);
		return "redirect:/listCategories";
	}
}
