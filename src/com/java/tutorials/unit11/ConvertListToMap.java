package com.java.tutorials.unit11;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.java.common.data.Hosting;

public class ConvertListToMap {
	private static List<Hosting> list;
	public static void main(String[] args) {
		  list = new Hosting().getListHosting();
	        
	      Map<Integer, String> collect = list.stream().collect(Collectors.toMap(Hosting :: getId, Hosting :: getDomain));
	      
	      System.out.println(combineSort());
	      
	}
	
	public static void convertDuplicateKey() {
		list.add(new Hosting(4, "google.com", 8888));
		Map<Integer, String> result = list.stream().
				collect(Collectors.toMap(Hosting :: getId, Hosting :: getDomain , (oldValue, newValue) -> newValue));
		
		// (oldValue, newValue) -> newValue ==> If the key is duplicated, do you prefer oldKey or newKey?
		
		System.out.println(result);
	}
	
	public static Map<String, Integer> combineSort() {
		list.add(new Hosting(4, "google.com", 8888));
		Map<String, Integer> collect = list.stream()
				.sorted(Comparator.comparingInt(Hosting :: getPort).reversed())
				.collect(Collectors.toMap(Hosting :: getDomain, Hosting :: getPort, (oldValue, newValue) -> newValue, LinkedHashMap :: new));
		
		return collect;
	}
	
}
