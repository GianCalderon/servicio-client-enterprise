package com.springboot.clientEnterprise.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.clientEnterprise.document.Enterprise;
import com.springboot.clientEnterprise.service.EnterpriseInterface;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/enterprise")
public class EnterpriseController {
	
	@Autowired
	EnterpriseInterface service;
	
	@GetMapping
	public Mono<ResponseEntity<Flux<Enterprise>>> toList() {

		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(service.findAll()));

	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Enterprise>> search(@PathVariable String id) {

		return service.findById(id).map(e->ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(e))
				.defaultIfEmpty(ResponseEntity.notFound().build());

	}

	@PostMapping
	public Mono<ResponseEntity<Enterprise>> save(@RequestBody Enterprise enterprise) {
	

		return service.save(enterprise).map(e->ResponseEntity
				.created(URI.create("/api/enterprise".concat(e.getId())))
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(e));

	}

	@PutMapping("/{id}")
	public Mono<ResponseEntity<Enterprise>> update(@RequestBody Enterprise enterprise, @PathVariable String id) {

		return service.update(enterprise, id).map(e->ResponseEntity
						.created(URI.create("/api/enterprise".concat(e.getId())))
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(e))
				.defaultIfEmpty(ResponseEntity.notFound().build());
			
	
	}
	
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
		
		return service.findById(id).flatMap(e->{
			return service.delete(e).then(Mono.just(new ResponseEntity<Void>(HttpStatus.ACCEPTED)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));

		
	}

}
