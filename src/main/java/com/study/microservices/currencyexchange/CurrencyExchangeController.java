package com.study.microservices.currencyexchange;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository currExchRepository;

	@Autowired
	public Environment env;
		
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveCurrencyExchDetails(@PathVariable String from, @PathVariable String to) {
		
		//Hardcoded values:
		//CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, new BigDecimal(83));
		// no need to create new currExchRepository then what is the purpose of spring injection.
		CurrencyExchange currencyExchange = currExchRepository.findByFromAndTo(from, to);
		String env1 = env.getProperty("local.server.port");
		currencyExchange.setEnv(env1);
		return currencyExchange;

	}

}
	