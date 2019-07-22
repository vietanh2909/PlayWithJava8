package com.java.tutorials.unit12;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterMapExample {
	public static void main(String[] args) {
		Map<Integer, String> hosting = new HashMap<>();
		hosting.put(1, "linode.com");
		hosting.put(2, "heroku.com");
		hosting.put(3, "digitalocean.com");
		hosting.put(4, "aws.amazon.com");
		
		String result = "";
		
		result = hosting.entrySet().stream()
				.filter(x -> x.getValue().equals("heroku.com"))
				.map(map -> map.getValue())
				.collect(Collectors.joining());
		
		result = hosting.entrySet().stream()
					.filter(x -> {
						if(x.getValue().equals("heroku.com") ||  x.getValue().equals("digitalocean.com")) {
							return true;
						}
						return false;
					}).map(map -> map.getValue())
					.collect(Collectors.joining(","));
		
		System.out.println(result);
	}
}
