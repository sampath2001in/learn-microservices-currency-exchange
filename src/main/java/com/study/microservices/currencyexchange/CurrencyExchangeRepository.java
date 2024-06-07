/**
 * 
 */
package com.study.microservices.currencyexchange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository is used to contact the db to extend JpaRepository
 * the parameters are which entity to contact in db (here CurrencyExchange table)
 * and the primary key type of that table that is Long (of the Id attribute) 
 */

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
	
	CurrencyExchange findByFromAndTo(String from, String to);
}
