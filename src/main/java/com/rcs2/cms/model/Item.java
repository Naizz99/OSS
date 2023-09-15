package com.rcs2.cms.model;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item {
	
	public enum Status{ACTIVE,DEACTIVE}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
		
	@ManyToOne
	@JoinColumn(name = "category")
    private Category category;
	
	private String name; 
	private String description;
	private int quantity;
	private String image; 
	private Status status; 
	private String createBy;
	private LocalDate createDate;
	private String updateBy;
	private LocalDate updateDate;
		
}
