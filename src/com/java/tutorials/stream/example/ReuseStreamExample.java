package com.java.tutorials.stream.example;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.java.common.data.Developer;

public class ReuseStreamExample {
	public static void main(String[] args) {
		// Using supplier
		
		List<Developer> developers = new Developer().getDevelopers();
		
		Supplier<Stream<List<Developer>>> supplier = () -> Stream.of(developers);
		
		supplier.get().forEach(System.out :: println);
		
	}
}
