package com.rcs2.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rcs2.cms.model.Order;
import com.rcs2.cms.model.Order.Status;

public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findByItem(Long itemId);

	List<Order> findByUser(Long userId);

	long countByStatus(Status pending);

}
