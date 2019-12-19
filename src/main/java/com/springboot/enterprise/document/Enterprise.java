package com.springboot.enterprise.document;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document(collection = "client-Enterprise")
public class Enterprise {

	@Id
	private String id;

	@NotNull(message = "User's tipoDoc must not be null")
	private String tipoDoc;

	@NotNull(message = "User's numDoc must not be null")
	@Indexed(unique = true)
	private String numDoc;

	@NotNull(message = "User's name must not be null")
	private String name;

	@NotNull(message = "User's address must not be null")
	private String address;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updateDate;

	private List<Cuenta> idCuentas;

	public Enterprise() {

	}

}
