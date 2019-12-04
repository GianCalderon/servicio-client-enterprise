package com.springboot.clientEnterprise.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.springboot.clientEnterprise.document.Enterprise;

public interface EnterpriseRepo extends ReactiveMongoRepository<Enterprise, String> {

}
