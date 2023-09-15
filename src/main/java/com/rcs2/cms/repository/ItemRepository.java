package com.rcs2.cms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rcs2.cms.model.Item;
import com.rcs2.cms.model.Item.Status;

public interface ItemRepository extends JpaRepository<Item, Long>{

	List<Item> findByCategory(Long categoryId);

	long countByStatus(Status active);

}
