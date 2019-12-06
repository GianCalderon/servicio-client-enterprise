package com.springboot.enterprise.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.springboot.enterprise.document.Enterprise;

public interface EnterpriseRepo extends ReactiveMongoRepository<Enterprise, String> {

}
