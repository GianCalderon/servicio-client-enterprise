package com.springboot.enterprise.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.enterprise.controller.EnterpriseController;
import com.springboot.enterprise.document.Enterprise;
import com.springboot.enterprise.dto.EnterpriseDto;
import com.springboot.enterprise.dto.EnterpriseDtoUpdate;
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

		return repo.save(enterprise);
	}

	@Override
	public Mono<Enterprise> update(EnterpriseDtoUpdate enterpriseDtoUpdate, String id) {
		
		return repo.findById(id).flatMap(e -> {
			
			e.setNumDoc(enterpriseDtoUpdate.getNumDoc());
			e.setName(enterpriseDtoUpdate.getName());
			e.setAddress(enterpriseDtoUpdate.getAddress());
			e.setUpdateDate(new Date());
			e.setIdCuentas(enterpriseDtoUpdate.getIdCuentas());
			
			e.setUpdateDate(new Date());
			return repo.save(e);

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
	
//	@Override
//	public Mono<Enterprise> updateDto(EnterpriseDto enterpriseDto, String id) {
//		
//		return repo.findById(id).flatMap(e -> {
//			
//			e.setNumDoc(enterprise.getNumDoc());
//			e.setName(enterprise.getName());
//			e.setAddress(enterprise.getAddress());
//			e.setUpdateDate(new Date());
//			return repo.save(e);
//
//		});
//	}



}
