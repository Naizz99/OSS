package com.rcs2.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcs2.cms.model.Order;
import com.rcs2.cms.model.Order.Status;
import com.rcs2.cms.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	 @Autowired
	 private OrderRepository repo;
	  
	 public List<Order> findAll() {
	     return repo.findAll();
	 }
	 	  
	 public void save(Order order) {
	     repo.save(order);
	 }
	  
	 public Order findById(long id) {
	     return repo.findById(id).get();
	 }
	  
	 public void delete(long id) {
	     repo.deleteById(id);
	 }

	public List<Order> findByItem(Long itemId) {
		return repo.findByItem(itemId);
	}

	public List<Order> findByUser(Long userId) {
		return repo.findByUser(userId);
	}

	public long countByStatus(Status pending) {
		return repo.countByStatus(pending);
	}
}
