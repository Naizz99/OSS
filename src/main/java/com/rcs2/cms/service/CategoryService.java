package com.rcs2.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcs2.cms.model.Category;
import com.rcs2.cms.model.Category.Status;
import com.rcs2.cms.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {
	 @Autowired
	 private CategoryRepository repo;
	  
	 public List<Category> findAll() {
	     return repo.findAll();
	 }
	 	  
	 public void save(Category category) {
	     repo.save(category);
	 }
	  
	 public Category findById(long id) {
	     return repo.findById(id).get();
	 }
	  
	 public void delete(long id) {
	     repo.deleteById(id);
	 }

	public List<Category> findByStatus(Status active) {
		return repo.findByStatus(active);
	}

	public long countByStatus(Status active) {
		return repo.countByStatus(active);
	}
}
