package com.springboot.enterprise.document;

import java.util.List;

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
	private List<String> idCuentas;
	
	public Enterprise(String tipoDoc, String numDoc, String name, String address) {
	
		this.tipoDoc = tipoDoc;
		this.numDoc = numDoc;
		this.name = name;
		this.address = address;
	
	}

	public Enterprise() {
		
	}

	
	

}
