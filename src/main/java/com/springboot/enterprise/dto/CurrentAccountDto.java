package com.springboot.enterprise.dto;

import lombok.Data;

@Data
public class CurrentAccountDto {
	
	private String id;
	private String numberAccount;
	private String state;
	private int balance;

}
