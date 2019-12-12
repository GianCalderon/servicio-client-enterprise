package com.springboot.enterprise.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.springboot.enterprise.document.Enterprise;
import com.springboot.enterprise.dto.EnterpriseDto;

@Component
public class UtilConvert {

	public Enterprise convertEnterprise(EnterpriseDto enterpriseDto) {
		
		
		Map<String,String> cuentaMap=new HashMap<String,String>();
		Enterprise enterprise = new Enterprise();
		
		cuentaMap.put(enterpriseDto.getNameAccount(), enterpriseDto.getIdCuenta());
	    List<Map<String,String>> lista = new ArrayList<Map<String,String>>();
	    
	    lista.add(cuentaMap);

	    enterprise.setTipoDoc(enterpriseDto.getTipoDoc());
	    enterprise.setNumDoc(enterpriseDto.getNumDoc());
	    enterprise.setName(enterpriseDto.getName()); 
	    enterprise.setAddress(enterpriseDto.getAddress());
	    enterprise.setIdCuentas(lista);

	    return enterprise;
	  }
}
