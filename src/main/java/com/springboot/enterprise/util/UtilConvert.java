package com.springboot.enterprise.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.enterprise.document.Account;
import com.springboot.enterprise.document.Enterprise;
import com.springboot.enterprise.dto.EnterpriseDto;

@Component
public class UtilConvert {

	public Enterprise convertEnterprise(EnterpriseDto enterpriseDto) {
		
		
		Account account = new Account();
		
		account.setIdAccount(enterpriseDto.getIdAccount());
        account.setNameAccount(enterpriseDto.getNameAccount());
        account.setNumberAccount(enterpriseDto.getNumberAccount());
        
        List<Account> lista = new ArrayList<>();
        lista.add(account);
        
        Enterprise enterprise = new Enterprise();

	    enterprise.setTipoDoc(enterpriseDto.getTipoDoc());
	    enterprise.setNumDoc(enterpriseDto.getNumDoc());
	    enterprise.setName(enterpriseDto.getName()); 
	    enterprise.setAddress(enterpriseDto.getAddress());
	    enterprise.setCreateDate(new Date());
	    enterprise.setUpdateDate(new Date());
	    enterprise.setListAccount(lista);

	    return 	enterprise;
	  }
}
