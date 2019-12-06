package com.springboot.enterprise.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="client-Enterprise")
public class Enterprise {
	
	
	@Id
	private String id;
	private String tipoDoc;
	private String numDoc;
	private String name;
	private String address;

	public Enterprise() {
		
	}
	public Enterprise(String tipoDoc, String numDoc, String name, String address) {
		super();
		this.tipoDoc = tipoDoc;
		this.numDoc = numDoc;
		this.name = name;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	

	

}
