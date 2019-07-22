package com.java.tutorials.map.example;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.java.common.data.Developer;

public class StreamMapExample {
	public static void main(String[] args) {
		List<Developer> devs = new Developer().getDevelopers();
		
		//devs.stream().map(Developer :: getName());
				
		List<Developer> results  =	devs.stream().map(dev -> {
				Developer data = new Developer();
				data.setName(dev.getName());
				data.setOld(dev.getOld());
				if(dev.getName().equals("iris")) {
					data.setSalary(new BigDecimal("15000000"));
				}
				return data;
			}).collect(Collectors.toList());
			
			System.out.println(results);
	}


}
