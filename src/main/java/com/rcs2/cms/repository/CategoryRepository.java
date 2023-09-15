package com.rcs2.cms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rcs2.cms.model.Category;
import com.rcs2.cms.model.Category.Status;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	List<Category> findByStatus(Status active);

	long countByStatus(Status active);

}
