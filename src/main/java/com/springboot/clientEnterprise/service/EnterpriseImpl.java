package com.springboot.clientEnterprise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clientEnterprise.document.Enterprise;
import com.springboot.clientEnterprise.repo.EnterpriseRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EnterpriseImpl implements EnterpriseInterface {

	@Autowired
	EnterpriseRepo repo;
	
	
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
	public Mono<Enterprise> update(Enterprise enterprise, String id) {
		
		return repo.findById(id).flatMap(e -> {

			e.setRuc(enterprise.getRuc());
			e.setName(enterprise.getName());
			e.setAddress(enterprise.getAddress());
			return repo.save(e);

		});
	}

	@Override
	public Mono<Void> delete(Enterprise enterprise) {
		return repo.delete(enterprise);
	}

}
