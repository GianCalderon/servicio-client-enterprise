package com.springboot.enterprise.service;

import com.springboot.enterprise.document.Enterprise;
import com.springboot.enterprise.dto.EnterpriseDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EnterpriseInterface  {

  public Flux<Enterprise> findAll();

  public Mono<Enterprise> findById(String id);
	
  public Mono<Enterprise> save(Enterprise enterprise);

  public Mono<Enterprise> update(Enterprise enterprise ,String id);

  public Mono<Void> delete(Enterprise enterprise);
  
  public Mono<Enterprise> nameSearch(String name);
  
  public Mono<Enterprise> findByRuc(String numDoc);
  

	
}
