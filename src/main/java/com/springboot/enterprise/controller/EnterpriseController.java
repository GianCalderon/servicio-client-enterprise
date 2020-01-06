package com.springboot.enterprise.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.springboot.enterprise.document.Account;
import com.springboot.enterprise.document.Enterprise;
import com.springboot.enterprise.dto.EnterpriseDto;
import com.springboot.enterprise.service.EnterpriseInterface;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/enterprise")
public class EnterpriseController {
	
  private static final Logger LOGGER = LoggerFactory.getLogger(EnterpriseController.class);

	@Autowired
	EnterpriseInterface service;
	
	@GetMapping
	public Mono<ResponseEntity<Flux<Enterprise>>> toList() {

		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll()));

	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Enterprise>> search(@PathVariable String id) {

		return service.findById(id).map(e->ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(e))
				.defaultIfEmpty(ResponseEntity.notFound().build());

	}

	@PostMapping
	public Mono<ResponseEntity<Enterprise>> save(@RequestBody Enterprise enterprise) {
		
		LOGGER.info(enterprise.toString());

		return service.save(enterprise).map(e->ResponseEntity.created(URI.create("/api/enterprise"))
				.contentType(MediaType.APPLICATION_JSON).body(e));

	}

	@PutMapping("/{id}")
	public Mono<ResponseEntity<Enterprise>> update(@RequestBody Enterprise enterprise, @PathVariable String id) {

		LOGGER.info("Empresa Recibida para Actualizar :--->"+enterprise.toString());
		
		return service.update(enterprise, id).map(e->ResponseEntity
						.created(URI.create("/api/enterprise".concat(e.getId())))
						.contentType(MediaType.APPLICATION_JSON)
						.body(e))
				.defaultIfEmpty(ResponseEntity.notFound().build());
			
	
	}
	
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
		
		return service.findById(id).flatMap(e->{
			return service.delete(e).then(Mono.just(new ResponseEntity<Void>(HttpStatus.ACCEPTED)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));

		
	}
	

	
	  @GetMapping("/numDoc/{ruc}")
	  public Mono<ResponseEntity<Enterprise>> searchRuc(@PathVariable String ruc) {

	    return service.findByRuc(ruc).map(p -> ResponseEntity.ok()
	      .contentType(MediaType.APPLICATION_JSON).body(p))
	      .defaultIfEmpty(ResponseEntity.notFound().build());

	  }
	


}
