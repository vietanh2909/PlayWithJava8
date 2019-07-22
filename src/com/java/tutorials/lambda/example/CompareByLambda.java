package com.java.tutorials.lambda.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.java.common.data.Developer;

public class CompareByLambda {
	public static void main(String[] args) {
		List<Developer> listDevelopers = getDevelopers();
		
		//before sort
		System.out.println("Before sort");
		for (Developer developer : listDevelopers) {
			System.out.println(developer.getName() +" - " + developer.getSalary());
		}
		
		System.out.println("After sort");
		listDevelopers.sort((o1, o2) -> o1.getSalary().compareTo(o2.getSalary()));
		listDevelopers.forEach(o -> System.out.println(o.getName() + " " + o.getSalary()));
	}
	
	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
		result.add(new Developer("alvin", new BigDecimal("100000"), 20));
		result.add(new Developer("jason", new BigDecimal("50000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 55));
		
		return result;

	}
}
