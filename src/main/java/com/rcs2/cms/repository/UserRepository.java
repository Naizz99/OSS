package com.rcs2.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rcs2.cms.model.User;
import com.rcs2.cms.model.User.Status;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	
	List<User> findByStatusNot(User.Status status);

	long countByStatus(Status active);
	
}
