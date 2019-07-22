package com.java.common.data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Fruit {
	private String name;
	private int qty;
	private BigDecimal price;

	public Fruit(String name, int qty, BigDecimal price) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
	}

	public Fruit() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", qty=" + qty + ", price=" + price + "]";
	}

	public List<Fruit> getFuit() {
		List<Fruit> items = Arrays.asList(new Fruit("apple", 10, new BigDecimal("9.99")),
				new Fruit("banana", 20, new BigDecimal("19.99")), 
				new Fruit("orang", 10, new BigDecimal("29.99")),
				new Fruit("watermelon", 10, new BigDecimal("29.99")),
				new Fruit("papaya", 20, new BigDecimal("9.99")),
				new Fruit("apple", 10, new BigDecimal("9.99")),
				new Fruit("banana", 10, new BigDecimal("19.99")),
				new Fruit("apple", 20, new BigDecimal("9.99")));

		return items;
	}

}
