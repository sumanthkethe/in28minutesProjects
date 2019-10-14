package com.in28minutes.microservices.limitsservice;

public class LimitConfiguration {
	private int maxium;
	private int minium;
	public LimitConfiguration() {
		// TODO Auto-generated constructor stub
	}
	public LimitConfiguration(int maxium, int minium) {
		super();
		this.maxium = maxium;
		this.minium = minium;
	}
	public int getMaxium() {
		return maxium;
	}
	public int getMinium() {
		return minium;
	}
}
