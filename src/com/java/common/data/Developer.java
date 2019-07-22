package com.java.common.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Developer {
	private String name;
	private BigDecimal salary;
	private int old;
	
	public Developer() {
		super();
	}
	
	public Developer(String name, BigDecimal salary, int old) {
		super();
		this.name = name;
		this.salary = salary;
		this.old = old;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public int getOld() {
		return old;
	}
	public void setOld(int old) {
		this.old = old;
	}

	public List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
		result.add(new Developer("alvin", new BigDecimal("170000"), 20));
		result.add(new Developer("jason", new BigDecimal("50000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 55));
		
		return result;

	}
	
	public String showInfo() {
		return this.getName() + " has salaray " + this.getSalary();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Developer is " + this.getName() +  " has salary " + this.getSalary() + "\n";
	}
}
