package com.study.microservices.currencyexchange;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity //this is a table in db
public class CurrencyExchange {
	
	public CurrencyExchange(Long id, String from, String to, BigDecimal conversion) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversion = conversion;
	}

	//from is the keyword in db so we can configure the column name using the below annotation
	
	@Column (name="currency_from") //denote column name in the table currency exchange.
	private String from;
	
	@Column (name="currency_to")
	private String to;
	
	
	public String env;
	
	
	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversion() {
		return conversion;
	}

	public void setConversion(BigDecimal conversion) {
		this.conversion = conversion;
	}

	@Id //this is kind of primary key
	private Long id;
	

	private BigDecimal conversion;

	public CurrencyExchange() {
		// TODO Auto-generated constructor stub
	}

}
