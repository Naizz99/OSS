package com.rcs2.cms.model;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category {
	
	public enum Status{ACTIVE,DEACTIVE}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
		
	private String name; 
	private String description;
	private String image; 
	private Status status; 
	private String createBy;
	private LocalDate createDate;
	private String updateBy;
	private LocalDate updateDate;
		
}

