package com.study.microservices.currencyexchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerPatternController {
	
	private static int count = 0;
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerPatternController.class);
	
	/*In order to test this Circuit Breaker, we need to make one 
	 *url/microservice(http:localhost:90/test) not to work just for testing purpose
	 * 
	 * 
	 */
	@GetMapping("/sampleAPI")
	//1. @Retry(name = "default")//This url will be tried to hit 3 times by default to check whether it works
	//2. @Retry(name = "api-retries")
	//  Property configured in application.properties(resilience4j.retry.instances.api-retries.maxAttempts=5)-now it will try for 5 times 
	//3.
	//@Retry(name = "api-retries", fallbackMethod = "someFallbackMethod")
	//4. @CircuitBreaker: 
	@CircuitBreaker(name = "circuit", fallbackMethod = "circuitFallbackMethod")
	public String sampleAPI() {
		logger.info("Sample API Request received: -> {}", count++);
		ResponseEntity responseBody = new RestTemplate().getForEntity("http:localhost:8080/test", String.class);
		return responseBody.toString();
	}
	
	//here we can give any exception as parameter to handle, in fact we can have multiple fall back methods to handle different exceptions.
	//here we have captured all the exceptions under Exception.
	public String someFallbackMethod(Exception ex) {
		return "Some Fall back response to notify this microservice instance is down or slow";
	}
	
	public String circuitFallbackMethod(Exception ex) {
		return "Dummy Circuit Breaker Response";
	}
	
	
}