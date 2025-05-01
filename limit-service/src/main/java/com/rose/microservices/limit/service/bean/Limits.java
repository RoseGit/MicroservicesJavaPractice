package com.rose.microservices.limit.service.bean;

/**
 * Simple bean with two properties 
 * that are read from the project using the Spring Cloud project(spring-cloud-config-server)
 * using global configuration on git (git-localconfig-repo)
 */
public class Limits {
	private int minimum;
	private int maximun;

	/**
	 * Defautl constructor
	 */
	public Limits() {
		super();
	}
	
	/**
	 * constructor with properties.
	 * @param minimum The value minimum of limit.
	 * @param maximun The value maximum of limit.
	 */
	public Limits(int minimum, int maximun) {
		super();
		this.minimum = minimum;
		this.maximun = maximun;
	}

	/**
	 * @return get the minimum value of limit
	 */
	public int getMinimum() {
		return minimum;
	}

	/**
	 * Set minimum value of limit.
	 * @param minimum The value for minimum
	 */
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	/**
	 * @return get the maximum value of limit
	 */
	public int getMaximun() {
		return maximun;
	}

	/**
	 * Set maximum value of limit.
	 * @param maximun The value for maximum
	 */
	public void setMaximun(int maximun) {
		this.maximun = maximun;
	}

	@Override
	public String toString() {
		return "Limits [minimum=" + minimum + ", maximun=" + maximun + "]";
	}

}
