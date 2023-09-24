package com.app.reactive.reactiveDemoApi;

import org.junit.jupiter.api.Test;

import com.app.reactive.reactiveDemoApi.service.FluxAndMonoService;

import reactor.test.StepVerifier;

public class FluxAndMonoServiceTest {

	FluxAndMonoService service = new FluxAndMonoService();
	@Test
	public void fruitsFlux() {
		var fruits = service.fruitsFlux();
		StepVerifier.create(fruits).expectNext("Manago","Apple","Banana","Orange").verifyComplete();
	}
	
	@Test
	public void fruitsMono() {
		
		var fruitsMono = service.fruitsMono();
		StepVerifier.create(fruitsMono)
        .expectNext("WoodApple")
        .verifyComplete();
	}
}
