package com.ecommerce.apigateway.filter;
import org.slf4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
@CrossOrigin

public class CustomGlobalFilter implements GlobalFilter{

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		Logger logger=org.slf4j.LoggerFactory.getLogger(CustomGlobalFilter.class);
		logger.info("Request path ==================>>>>>>>{}",exchange.getRequest().getPath());
		return chain.filter(exchange);
	}

}
