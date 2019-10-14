package com.in28minutes.microservices.currencyconvertionservice;

import java.math.BigDecimal;

public class CurrencyConvertionBean {
	private Long id;
	private String from;
	private String to;
	private BigDecimal convertionMultiple;
	private BigDecimal quantiy;
	private BigDecimal totalCalculatedAmount;
	private int port;
	
	public CurrencyConvertionBean() {
		// TODO Auto-generated constructor stub
	}
	
	public CurrencyConvertionBean(Long id, String from, String to, BigDecimal convertionMultiple, BigDecimal quantiy,
			BigDecimal totalCalculatedAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertionMultiple = convertionMultiple;
		this.quantiy = quantiy;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.port = port;
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
	public BigDecimal getConvertionMultiple() {
		return convertionMultiple;
	}
	public void setConvertionMultiple(BigDecimal convertionMultiple) {
		this.convertionMultiple = convertionMultiple;
	}
	public BigDecimal getQuantiy() {
		return quantiy;
	}
	public void setQuantiy(BigDecimal quantiy) {
		this.quantiy = quantiy;
	}
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

}
