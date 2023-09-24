package com.example.APIGateway;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {
	
	
	public static final List<String> openApiEndPoint = List.of(
			"/auth/save-user",
			"auth/get-token",
			"/eureka"
			);
	
	
	
	public Predicate<ServerHttpRequest> isSecured =
			request -> openApiEndPoint.stream()
			.noneMatch(uri->request.getURI().getPath().contains(uri));

}
