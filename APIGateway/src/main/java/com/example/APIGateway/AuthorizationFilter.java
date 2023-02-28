package com.example.APIGateway;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Mono;

@Component
public class AuthorizationFilter extends AbstractGatewayFilterFactory<AuthorizationFilter.Config> {

	@Autowired
	Environment env;
	public AuthorizationFilter() {
		super(Config.class);
	}
	public static class Config {
		// put configuration properties here.
	}
	@Override
	public GatewayFilter apply(Config config) {
		// TODO Auto-generated method stub
		System.out.println("************** calling Gateway API router filter **************");
		return (exchange, chain) -> {
			ServerHttpRequest req = exchange.getRequest();
			if (!req.getHeaders().containsKey("Authorization")) {
				System.out.println("************** calling Gateway API header missing **************");
				return OnError(exchange, "Not Authorized header", HttpStatus.UNAUTHORIZED);
			}
			String jwttoken = req.getHeaders().get("Authorization").get(0);
			String jwtPrefix = jwttoken.replace("Bearer", "");
			if (!validateToken(jwtPrefix.trim())) {
				return OnError(exchange, "JWT token not valid", HttpStatus.UNAUTHORIZED);
			}
			return chain.filter(exchange);
		};
	}

	private Mono<Void> OnError(ServerWebExchange exchange, String message, HttpStatus scUnauthorized) {
		ServerHttpResponse response = exchange.getResponse();
		response.setStatusCode(scUnauthorized);
		return response.setComplete();
	}

	private boolean validateToken(String jwtToken) {
		System.out.println("token ************ "+jwtToken);
		try {
			String subject = Jwts.parser().setSigningKey(env.getProperty("tocken.secret")
					         .getBytes(Charset.forName("UTF-8")))
							 .parseClaimsJws(jwtToken.replace("{", "")
							 .replace("}","")).getBody().getSubject();			
			if (subject == null || subject.isEmpty()) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
