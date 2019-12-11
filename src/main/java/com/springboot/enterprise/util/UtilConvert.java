package com.springboot.enterprise.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.enterprise.document.Enterprise;
import com.springboot.enterprise.dto.EnterpriseDto;

@Component
public class UtilConvert {

	public Enterprise convertEnterprise(EnterpriseDto enterpriseDto) {

		Enterprise enterprise = new Enterprise();
		
	    List<String> lista = new ArrayList<String>();
	  
	    lista.add(enterpriseDto.getIdCuenta());

	    enterprise.setTipoDoc(enterpriseDto.getTipoDoc());
	    enterprise.setNumDoc(enterpriseDto.getNumDoc());
	    enterprise.setName(enterpriseDto.getName()); 
	    enterprise.setAddress(enterpriseDto.getAddress());
	    enterprise.setIdCuentas(lista);

	    return enterprise;
	  }
}
