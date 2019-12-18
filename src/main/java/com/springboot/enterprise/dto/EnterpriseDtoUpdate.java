package com.springboot.enterprise.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class EnterpriseDtoUpdate {

	private String idAccount;
	private String nameAccount;	
	private String tipoDoc;
	private String numDoc;
	private String name;
	private String address;
	private List<Map<String,String>> idCuentas;
	

}
