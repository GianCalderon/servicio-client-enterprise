package com.springboot.enterprise.document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="client-Enterprise")
public class Enterprise {
	
	
	@Id
	private String id;
	private String tipoDoc;
	private String numDoc;
	private String name;
	private String address;
	private List<Map<String,String>> idCuentas;

	public Enterprise() {
		
	}


	
	

}
