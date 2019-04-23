/**
 * 
 */
package com.hq.pojo;

/**
 * @author HQ
 *
 */
public class Flower {
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Flower(int id, String name, double price, String production) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.production = production;
	}
	public Flower(String name, double price, String production) {
		super();
		this.name = name;
		this.price = price;
		this.production = production;
	}
	public Flower() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public int getId() {
		return id;
	}
	private String name;
	private double price;
	private String production;

}
