package com.springboot.enterprise.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.enterprise.controller.EnterpriseController;
import com.springboot.enterprise.document.Account;
import com.springboot.enterprise.document.Enterprise;
import com.springboot.enterprise.dto.EnterpriseDto;
import com.springboot.enterprise.repo.EnterpriseRepo;
import com.springboot.enterprise.util.UtilConvert;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EnterpriseImpl implements EnterpriseInterface {

	
  private static final Logger LOGGER = LoggerFactory.getLogger(EnterpriseController.class);
	 
	@Autowired
	EnterpriseRepo repo;
	
	@Autowired
	UtilConvert convert;
	
	
	public Flux<Enterprise> findAll() {
		
		return repo.findAll();
	}

	public Mono<Enterprise> findById(String id) {
		
		return repo.findById(id);
	}
	
	@Override
	public Mono<Enterprise> save(Enterprise enterprise) {

		enterprise.setCreateDate(new Date());
		enterprise.setUpdateDate(new Date());
		enterprise.setListAccount(new ArrayList<Account>());
		
		return repo.save(enterprise);

	}

	@Override
	public Mono<Enterprise> update(EnterpriseDto enterpriseDto, String ruc) {
		
	    return repo.findByNumDoc(ruc).flatMap(enterprise -> {
	      	
	        List<Account> list = enterprise.getListAccount();
	        
	        Account account = new Account();
	        
	        account.setIdAccount(enterpriseDto.getIdAccount());
	        account.setNumberAccount(enterpriseDto.getNumberAccount());
	        account.setNameAccount(enterpriseDto.getNameAccount());

	        list.add(account);

	        enterprise.setTipoDoc(enterpriseDto.getTipoDoc());
	        enterprise.setNumDoc(enterpriseDto.getNumDoc());
	        enterprise.setName(enterpriseDto.getName());
	        enterprise.setAddress(enterpriseDto.getAddress());
	        enterprise.setUpdateDate(new Date());
	        enterprise.setListAccount(list);
	        
	        return repo.save(enterprise);
	    
	      });
		
	
	}

	@Override
	public Mono<Void> delete(Enterprise enterprise) {
		return repo.delete(enterprise);
	}
	
	//OPERACION QUE EXPONEN SERVICIOS
	
	@Override
	public Mono<Enterprise> saveDto(EnterpriseDto enterpriseDto) {
		
		return save(convert.convertEnterprise(enterpriseDto));
	}

	@Override
	public Mono<Enterprise> nameSearch(String name) {
		
		return repo.findByName(name);
	}

	
	 @Override
	  public Mono<Enterprise> findByNumDoc(String numDoc) {

	    return repo.findByNumDoc(numDoc);
	  }



}
