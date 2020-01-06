package com.springboot.enterprise.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.enterprise.controller.EnterpriseController;
import com.springboot.enterprise.document.Enterprise;
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

		return repo.save(enterprise);

	}

	@Override
	public Mono<Enterprise> update(Enterprise enterprise, String id) {
		
	    return repo.findById(id).flatMap(ent -> {

	    	ent.setTipoDoc(enterprise.getTipoDoc());
	    	ent.setNumDoc(enterprise.getNumDoc());
	    	ent.setName(enterprise.getName());
	    	ent.setAddress(enterprise.getAddress());
	    	ent.setUpdateDate(new Date());
	   
	        return repo.save(ent);
	    
	      });
		
	
	}

	@Override
	public Mono<Void> delete(Enterprise enterprise) {
		return repo.delete(enterprise);
	}
	
  

	@Override
	public Mono<Enterprise> nameSearch(String name) {
		
		return repo.findByName(name);
	}

	
	 @Override
	 public Mono<Enterprise> findByRuc(String ruc) {

	    return repo.findByRuc(ruc);
	  }



}
