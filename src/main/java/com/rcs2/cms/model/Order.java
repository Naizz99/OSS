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
@Table(name="orders")
public class Order {
	
	public enum Status{PENDING,APPROVED,DELIVERED,SUCCESS,CANCELED}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
		
	@ManyToOne
	@JoinColumn(name = "item")
    private Item item;
	
	@ManyToOne
	@JoinColumn(name = "user")
    private User user;
	
	private String note;
	private int quantity;
	private String paymentImage; 
	private Status status; 
	private String createBy;
	private LocalDate createDate;
	private String updateBy;
	private LocalDate updateDate;
		
}
