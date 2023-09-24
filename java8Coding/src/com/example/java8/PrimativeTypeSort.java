package com.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrimativeTypeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[]{1,20,30,4,2,8,7,5};
		List<Integer> list = Arrays.stream(numbers).boxed().sorted().collect(Collectors.toList());
		System.out.println(list);

		//Q: How to concatenate List of String/Integer Objects using some separator in Java8?
		
		System.out.println(Arrays.stream(numbers).boxed().map(val-> val+"").collect(Collectors.joining("")));
		
		
		List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
		//Q: How to find only duplicate elements with its count from the String ArrayList in Java8?
		Map<String,Long> namesCount = names
		                             .stream()
						             .filter(x->Collections.frequency(names, x)>1)
						             .collect(Collectors.groupingBy
						             (Function.identity(), Collectors.counting()));
		System.out.println(namesCount);
		
		//Q: How to check if list is empty in Java 8 using Optional, if not null 
		//iterate through the list and print the object?
		
		List<String> notes = new ArrayList<>();
		notes.add("note1");
		notes.add("note2");
		notes.add("note3");
		notes.add("note4");
		notes.add("note5");
Optional.ofNullable(notes)
            .orElseGet(Collections::emptyList) // creates empty immutable list: [] in case noteLst is null
            .stream().filter(Objects::nonNull) //loop throgh each object and consider non null objects
           // .map(note -> Notes::getTagName) // method reference, consider only tag name
            .forEach(System.out::println); // it will print tag names
	}

}
