package com.java.tutorials.stream.collector;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.java.common.data.Fruit;

public class GroupByCollectorExample {
	public static void main(String[] args) {
		List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
		
		Map<String, Long> results = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		// add sorting
		
		Map<String, Long> finalMap = new LinkedHashMap<>();
		results.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue()
				.reversed()).forEach(e -> finalMap.put(e.getKey(), e.getValue()));;
		
				
		// group by + count/ sum
		List<Fruit> data = new Fruit().getFuit();
		Map<String, Long> fruitResult = data.stream().collect(Collectors.groupingBy(Fruit :: getName, Collectors.counting()));
		
		Map<String, Integer> sumQuantityOfFruit = data.stream().collect(Collectors.groupingBy(Fruit :: getName, Collectors.summingInt(Fruit :: getQty)));
		
		// group by price
		
		Map<BigDecimal, List<Fruit>> groupByPrice = data.stream().collect(Collectors.groupingBy(Fruit :: getPrice));
		
		// group by price, uses 'mapping' to convert List<Item> to Set<String>
		Map<BigDecimal, Set<String>> groupByPriceAndSetHasSort = new LinkedHashMap<>();
		
		Map<BigDecimal, Set<String>> groupByPriceAndSet  = data.stream()
				.collect(Collectors.groupingBy(Fruit :: getPrice, Collectors.mapping(Fruit :: getName, Collectors.toSet())));
		
		groupByPriceAndSet.entrySet().stream().sorted(Map.Entry.<BigDecimal, Set<String>>comparingByKey()).forEach(k -> groupByPriceAndSetHasSort.put(k.getKey(), k.getValue()));
		
		System.out.println(groupByPriceAndSetHasSort);
	}
}
