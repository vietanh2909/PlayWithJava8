package com.java.tutorials.stream.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.common.data.Developer;

public class ConvertToStreamExample {
	public static void main(String[] args) {
		String[] languages = { "Java", "C#", "C++", "PHP", "Javascript" };
		Stream<String> convertToStream = Stream.of(languages);
		//convertToStream.sorted().forEach(str -> System.out.println(str));
		
		List<String> afterSort = new ArrayList<>();
		List<String> arrLanguages = Arrays.asList(languages);
		
		List<Developer> listDeveloper = new Developer().getDevelopers();
		
		Developer dev = listDeveloper.stream()
				.filter(d -> "jason".equals(d.getName()) &&  new BigDecimal("150000").equals( d.getSalary()))
				.findAny().orElse(null);
		//System.out.println(dev == null ? "Not found developer" : dev.toString());
		
		BigDecimal salary = listDeveloper.stream()
			.filter(d -> d.getName().contains("a"))
			.map(Developer :: getSalary )
			.findAny()
			.orElse(new BigDecimal("0"));
		
		//System.out.println("Salary : " + salary);
		
		List<BigDecimal> collect = listDeveloper.stream().map(Developer :: getSalary).collect(Collectors.toList());
		
		//collect.forEach(System.out :: println);
		
		//intermediateOperations();
		terminalOperations();
	}
	
	// For example Intermediate operations 
	
	public static void intermediateOperations() {
		String[] languages = { "Java", "C#", "C++", "PHP", "Javascript" };
		
		List<String> list = Arrays.asList(languages);
		
		list.stream().skip(1).limit(3).forEach(System.out:: println);
		
		List<Developer> devs = new Developer().getDevelopers();
		
		devs.stream().skip(1).limit(2)
			.sorted( (d1, d2) -> d2.getName().compareTo(d1.getName()) )
			.map(Developer :: showInfo)
			.forEach(System.out :: println);
		
	}
	
	public static void terminalOperations() {
		//Stream<String> streams = Stream.of("C#", "Angular JS", "React JS", "Java", "C#", "HTML");
		//List<String> list = streams.collect(Collectors.toList());
		
		List<Developer> dev = new Developer().getDevelopers();
		
		dev.stream().filter(d -> d.getSalary().equals(new BigDecimal("170000")))
				.collect(Collectors.toList()).forEach(System.out :: println);;
		
		//list.forEach(System.out :: println);
				
	}
	
}
