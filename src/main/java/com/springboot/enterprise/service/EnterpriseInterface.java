package com.springboot.enterprise.service;

import com.springboot.enterprise.document.Enterprise;
import com.springboot.enterprise.dto.EnterpriseDto;
import com.springboot.enterprise.dto.EnterpriseDtoUpdate;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EnterpriseInterface  {

  public Flux<Enterprise> findAll();

  public Mono<Enterprise> findById(String id);
	
  public Mono<Enterprise> save(Enterprise enterprise);

  public Mono<Enterprise> update(EnterpriseDtoUpdate EnterpriseDtoUpdate ,String id);

  public Mono<Void> delete(Enterprise enterprise);
  
  public Mono<Enterprise> saveDto(EnterpriseDto personalDto);
  
  public Mono<Enterprise> nameSearch(String name);
	
}
