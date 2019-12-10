package com.springboot.enterprise.repo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.springboot.enterprise.document.Enterprise;

import reactor.core.publisher.Mono;

public interface EnterpriseRepo extends ReactiveMongoRepository<Enterprise, String> {
	
	  public Mono<Enterprise> findByName(String name);

	  @Query("{'nombre': ?0 }")
	  public Mono<Enterprise> nameSearch(String name);

}
