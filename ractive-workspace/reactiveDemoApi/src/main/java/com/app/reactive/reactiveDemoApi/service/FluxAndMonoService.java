package com.app.reactive.reactiveDemoApi.service;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoService {

	
	public Flux<String> fruitsFlux(){
		
		return Flux.fromIterable(List.of("Manago","Apple","Banana","Orange")).log();
	}
	public Mono<String> fruitsMono(){
		return Mono.just("WoodApple").log();
	}
	public static void main(String args[]) {
		
		FluxAndMonoService service = new FluxAndMonoService();
		
		service.fruitsFlux().subscribe(s->{
			System.out.println(s);
		});
		
		service.fruitsMono().subscribe(s->{
			System.out.println(s);
		});
	}
}
