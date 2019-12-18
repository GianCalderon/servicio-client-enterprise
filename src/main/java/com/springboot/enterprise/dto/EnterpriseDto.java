package com.springboot.enterprise.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EnterpriseDto {

	@NotNull(message = "User's idCuenta must not be null")
	private String idCuenta;
	
	@NotNull(message = "User's nameAccount must not be null")
	private String nameAccount;
	
	@NotNull(message = "User's tipoDoc must not be null")
	private String tipoDoc;

	@NotNull(message = "User's numDoc must not be null")
	private String numDoc;

	@NotNull(message = "User's name must not be null")
	private String name;

	@NotNull(message = "User's address must not be null")
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
