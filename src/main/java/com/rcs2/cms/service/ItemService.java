package com.rcs2.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcs2.cms.model.Item;
import com.rcs2.cms.model.Item.Status;
import com.rcs2.cms.repository.ItemRepository;

@Service
@Transactional
public class ItemService {
	 @Autowired
	 private ItemRepository repo;
	  
	 public List<Item> findAll() {
	     return repo.findAll();
	 }
	 	  
	 public void save(Item item) {
	     repo.save(item);
	 }
	  
	 public Item findById(long id) {
	     return repo.findById(id).get();
	 }
	  
	 public void delete(long id) {
	     repo.deleteById(id);
	 }

	public List<Item> findByCategory(Long categoryId) {
		return repo.findByCategory(categoryId);
	}

	public long countByStatus(Status active) {
		return repo.countByStatus(active);
	}
}
