package com.rcs2.cms.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	public enum Role{ADMIN,CUSTOMER,GUEST}
	public enum Gender{MALE,FEMALE}
	public enum Status{ACTIVE,DEACTIVE}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user;
		
	private Role role;
	
	private String name; 
	private Gender gender; 
	private String email; 
	private String mobile;
	private String username;
	private String password;
	private String image;
	private Status status; 
	private String createBy;
	private LocalDate createDate;
	private String updateBy;
	private LocalDate updateDate;	
}
