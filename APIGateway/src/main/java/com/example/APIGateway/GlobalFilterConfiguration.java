package com.example.APIGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import reactor.core.publisher.Mono;

@Configuration
public class GlobalFilterConfiguration {

	final Logger logger = LoggerFactory.getLogger(PostFilter.class);
	
	@Order(1)
	@Bean
	public GlobalFilter secondPreFilter() {
		
		return (exchange,chain)->{
			System.out.println("************2nd Global Pre Filter *********************");
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				System.out.println("1.************2nd Global Post Filter *********************");
			}));
		};
	}
	@Order(2)
	@Bean
	public GlobalFilter thirdPreFilter() {
		
		return (exchange,chain)->{
			System.out.println("************ third Global Pre Filter *********************");
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				System.out.println("2.************third Global Post Filter *********************");
			}));
		};
	}
}
