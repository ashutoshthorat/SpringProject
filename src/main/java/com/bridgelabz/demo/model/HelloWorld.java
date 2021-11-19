package com.bridgelabz.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.demo.dto.HelloWorldDTO;

import lombok.Data;

@Data
@Entity
@Table
public class HelloWorld {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String firstName;
	private String lastName;
	private String address;
	private LocalDateTime registerDate;
	private LocalDateTime updatedDate;
	

	public HelloWorld(HelloWorldDTO helloworlddto) {
		this.firstName=helloworlddto.getFirstName();
		this.lastName=helloworlddto.getLastName();
		this.address=helloworlddto.getAddress();
		this.registerDate=LocalDateTime.now();
		
	}
	public HelloWorld() {
		
	}
	
}
