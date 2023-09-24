package com.example.java8;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountLengthGraterThan3 {

	public static void main(String[] args) {
		
		System.out.println(Stream.of("hello","raja","mohan","kumar","hi").filter(val->val.length()>4).count());
		System.out.println(Stream.of("hello","raja","mohan","kumar","hi")
				.filter(val->val.length()>4).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
	}
}
