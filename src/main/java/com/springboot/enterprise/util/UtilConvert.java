package com.springboot.enterprise.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.enterprise.document.Cuenta;
import com.springboot.enterprise.document.Enterprise;
import com.springboot.enterprise.dto.EnterpriseDto;

@Component
public class UtilConvert {

	public Enterprise convertEnterprise(EnterpriseDto enterpriseDto) {
		
		
		Cuenta cuenta = new Cuenta();
        cuenta.setNameAccount(enterpriseDto.getNameAccount());
        cuenta.setNumAccount(enterpriseDto.getNumberAccount());
        
        List<Cuenta> lista = new ArrayList<>();
        lista.add(cuenta);
        
        Enterprise enterprise = new Enterprise();

	    enterprise.setTipoDoc(enterpriseDto.getTipoDoc());
	    enterprise.setNumDoc(enterpriseDto.getNumDoc());
	    enterprise.setName(enterpriseDto.getName()); 
	    enterprise.setAddress(enterpriseDto.getAddress());
	    enterprise.setCreateDate(new Date());
	    enterprise.setUpdateDate(new Date());
	    enterprise.setIdCuentas(lista);

	    return 	null;
	  }
}
