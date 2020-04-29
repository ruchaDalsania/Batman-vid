package com.batman.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Java8Collections {

	public static void main(String[] args) {
		List<String> avengersList = Arrays.asList("thor", "wonder woman", "hulk", "ironman", "dr stranger");
		avengersList.forEach(System.out::println);

		avengersList.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		Predicate<String> pred = i -> i.startsWith("K");
		avengersList.forEach(s -> s.concat("@tcs.com"));
		avengersList.forEach(s -> System.out.println(s));
		avengersList.removeIf(n -> (n.charAt(0) == 'S'));
		avengersList.removeIf(pred);
		avengersList.forEach(s -> System.out.println(s.length()));

		System.out.println("---------------------");

		Map<String, String> map = new HashMap<>();
		map.put("Android", "Mobile");
		map.put("Eclipse IDE", "Java");
		map.put("Eclipse RCP", "Java");
		map.put("Git", "Version control system");
//		map.remove("Git");
		map.forEach((k, v) -> System.out.println(">" + k + " : " + v));

		String[] strs =  map.keySet().toArray(new String[map.keySet().size()]);
		System.out.println(strs);

		ArrayList<String> arrs=new ArrayList<String>(map.keySet());
		System.out.println(arrs);
	}

}
