package com.springboot.clientEnterprise.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="client-Enterprise")
public class Enterprise {
	
	
	@Id
	private String id;
	private String ruc;
	private String name;
	private String address;


	public Enterprise(String ruc, String name, String address) {
		super();
		this.ruc = ruc;
		this.name = name;
		this.address = address;
	}
	

	public Enterprise() {
		super();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
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
