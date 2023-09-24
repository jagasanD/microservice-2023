/*package com.example.APIGateway;


import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class PreFilterGlobal implements GlobalFilter,Ordered{

	final Logger loger = LoggerFactory.getLogger(PreFilterGlobal.class);
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		System.out.println("**************PreFilterGlobal*******************");
		String urlPath = exchange.getRequest().getPath().toString();
		HttpHeaders headers =exchange.getRequest().getHeaders();
		Set<String> kyes = headers.keySet();
		
		kyes.forEach((headerName)->{
			String hname = headers.getFirst(headerName);
			System.out.println("**************header name *******************"+hname);
		});
		
		return chain.filter(exchange);
	}
	@Override
	public int getOrder() {
		return 0;
	}

}*/
