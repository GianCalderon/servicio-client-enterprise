package com.springboot.enterprise;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.springboot.enterprise.document.Enterprise;
import com.springboot.enterprise.dto.EnterpriseDto;
import com.springboot.enterprise.service.EnterpriseInterface;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringbootServicioClientEnterpriseApplicationTests {

	
	@Autowired
    private WebTestClient client;
	  
    @Autowired
    private EnterpriseInterface service;
	
	@Test
	  public void listTest() {

	    client.get()
	    .uri("api/enterprise")
	    .accept(MediaType.APPLICATION_JSON)
	    .exchange()
	    .expectStatus().isOk()
	    .expectHeader().contentType(MediaType.APPLICATION_JSON)
	      .expectBodyList(Enterprise.class);
	  }
	
	  @Test
	  public void searchTest() {


	    Enterprise enterprise = service.nameSearch("SONY S.A.C").block();

	    client.get()
	    .uri("api/enterprise/{id}",Collections.singletonMap("id", enterprise.getId()))
	    .accept(MediaType.APPLICATION_JSON)
	    .exchange()
	    .expectStatus().isOk()
	    .expectHeader().contentType(MediaType.APPLICATION_JSON)
	    .expectBody()
	    .jsonPath("$.id").isNotEmpty()
	    .jsonPath("$.name").isEqualTo("SONY S.A.C");
	      
	  }
	  
//	  @Test
//	  public void saveTest() {
//
//
//		  EnterpriseDto enterpriseDto = new EnterpriseDto("1deaes79067db969b8fffc13","RUC","67654567298",
//	                                        "Lenovo S.A.C","Madrid 199");
//
//	    client.post()
//	    .uri("api/enterprise")
//	    .contentType(MediaType.APPLICATION_JSON)
//	    .accept(MediaType.APPLICATION_JSON)
//	    .body(Mono.just(enterpriseDto),EnterpriseDto.class)
//	    .exchange()
//	    .expectStatus().isCreated()
//	    .expectHeader().contentType(MediaType.APPLICATION_JSON)
//	      .expectBody()
//	      .jsonPath("$.id").isNotEmpty()
//	      .jsonPath("$.name").isEqualTo("Lenovo S.A.C");
//	  }
//	  
	  
//	  @Test
//	  public void updateTest() {
//
//
//		  Enterprise enterprise = service.nameSearch("Asus S.A.C").block();
//		  Enterprise enterpriseEditado = new Enterprise("43wrwrwdwefewfrth56y5","RUC","78256453672",
//	                                        "HP S.A.C","Madrid 234");
//
//	    client.put()
//	          .uri("api/enterprise/{id}",Collections.singletonMap("id", enterprise.getId()))
//	          .contentType(MediaType.APPLICATION_JSON)
//	          .accept(MediaType.APPLICATION_JSON)
//	          .body(Mono.just(enterpriseEditado),Enterprise.class)
//	          .exchange()
//	          .expectStatus().isCreated()
//	          .expectHeader().contentType(MediaType.APPLICATION_JSON)
//	          .expectBody()
//	          .jsonPath("$.id").isNotEmpty()
//	          .jsonPath("$.name").isEqualTo("HP S.A.C");
//	  }
	  
	  @Test
	  public void delete() {
	  
		  Enterprise enterprise = service.nameSearch("Lenovo S.A.C").block();

	    client.delete()
	    .uri("api/enterprise/{id}",Collections.singletonMap("id",enterprise.getId()))
	    .exchange()
	    .expectStatus().isAccepted()
	    .expectBody()
	      .isEmpty();

	  }


}
