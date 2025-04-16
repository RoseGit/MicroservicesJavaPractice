package com.rose.microservices.limit.service.bean;

public class Limits {
	private int minimum;
	private int maximun;

	public Limits() {
		super();
	}
	
	public Limits(int minimum, int maximun) {
		super();
		this.minimum = minimum;
		this.maximun = maximun;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximun() {
		return maximun;
	}

	public void setMaximun(int maximun) {
		this.maximun = maximun;
	}

	@Override
	public String toString() {
		return "Limits [minimum=" + minimum + ", maximun=" + maximun + "]";
	}

}
