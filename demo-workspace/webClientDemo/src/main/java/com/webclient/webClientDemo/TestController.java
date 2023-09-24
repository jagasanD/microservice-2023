package com.webclient.webClientDemo;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class TestController {

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getEmps(){
	
	WebClient client = WebClient.builder()
			  .baseUrl("http://localhost:8084")
			  .defaultCookie("cookieKey", "cookieValue")
			  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			  .filter(errorHandler())
			  .build();
	
	
Mono<List<Employee>> response = client.get().uri("/emps").
retrieve()
.bodyToMono(new ParameterizedTypeReference<List<Employee>>() {});


return new ResponseEntity<List<Employee>>(response.block(),HttpStatusCode.valueOf(200));
	}
	
	public static ExchangeFilterFunction errorHandler() {
	    return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
	        if (clientResponse.statusCode().is5xxServerError()) {
	            return clientResponse.bodyToMono(String.class)
	                    .flatMap(errorBody -> Mono.error(new RuntimeException("Exception 1")));
	        } else if (clientResponse.statusCode().is4xxClientError()) {
	            return clientResponse.bodyToMono(String.class)
	                    .flatMap(errorBody -> Mono.error(new RuntimeException(errorBody)));
	        } else {
	            return Mono.just(clientResponse);
	        }
	    });
	}
}
