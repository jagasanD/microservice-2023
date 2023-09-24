package com.example.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultiplyWith3 {

	public static void main(String[] args) {
		
		System.out.println(Stream.of(1,3,4,7,2,6).map(val->val*3).collect(Collectors.toList()));
		//Sum of all number 
		System.out.println(Stream.of(1,3,4,7,2,6).mapToInt(Integer::intValue).sum());
		
		System.out.println(Stream.of(1,3,4,7,2,6).min((s1,s2)->s1.compareTo(s2)));
		System.out.println(Stream.of(1,3,4,7,2,6).max((s1,s2)->s1.compareTo(s2)));
		//perform cube on list elements and filter numbers greater than 50.
		System.out.println(Stream.of(1,3,4,7,2,6).map(val->val*val*val).filter(val->val>50).collect(Collectors.toList()));
		
		//even number 
		System.out.println(Stream.of(1,3,4,7,2,6).filter(val->val%2==0).collect(Collectors.toList()));
		
		System.out.println(Stream.of(1,3,4,7,2,6,10,15).map(s->s.toString()).filter(val->val.startsWith("1")).collect(Collectors.toList()));

		//find duplicate value 
		System.out.println(Stream.of(1,3,4,7,2,2,4,4,6,6,6,6)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream().filter(val->val.getValue()>=2).collect(Collectors.toMap(val->val.getKey(), val->val.getValue())));
		
		System.out.println(Stream.of(1,3,4,7,2,6,10,15).reduce(0,(a,b)->a+b));
	
	// avoid duplicate key by merge function (existing,replacement)->existing
	
	//Stream.of(1,3,4,7,2,2,4,4,6,6,6,6).collect(Collectors.toMap(Book::getReleaseYear, Function.identity(),
		   //   (existing, replacement) -> existing));

	
		
		// Given a String, find the first non-repeated character in it using Stream
		
		
	 String input = "Java Hungry Blog Alive is Awesome";

     Character result = input.chars() // Stream of String       
                             .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                             .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                             .entrySet()
                             .stream()
                             .filter(entry -> entry.getValue() == 1L)
                             .map(entry -> entry.getKey())
                             .findFirst()
                             .get();
     System.out.println(result); 
     //sort reverse order
     
     List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

     myList.stream()
           .sorted(Collections.reverseOrder())
           .forEach(System.out::println);
     
     //
     List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
     
    

     IntSummaryStatistics stats = numbers.stream().mapToInt((x)-> x).summaryStatistics();

     System.out.println("Lowest number in List : " + stats.getMin());
     System.out.println("Avg number in List : " + stats.getAverage());
     System.out.println("Max number in List : " + stats.getMax());
     System.out.println("count number in List : " + stats.getCount());
     System.out.println("Sum number in List : " + stats.getSum());
}
	
}
