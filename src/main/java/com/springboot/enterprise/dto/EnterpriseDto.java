package com.springboot.enterprise.dto;

import lombok.Data;

@Data
public class EnterpriseDto {

	  private String idCuenta;
	  private String nameAccount;
	  private String tipoDoc;
	  private String numDoc;
	  private String name;
	  private String address;

	
	  
	  public EnterpriseDto(String idCuenta, String tipoDoc, String numDoc, String name, String address) {
		super();
		this.idCuenta = idCuenta;
		this.tipoDoc = tipoDoc;
		this.numDoc = numDoc;
		this.name = name;
		this.address = address;
		
	}
	
	  

	  
	
	  
	  
	  
}
