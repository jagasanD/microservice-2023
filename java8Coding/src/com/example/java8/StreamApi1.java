package com.example.java8;



import java.util.Comparator;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<String> st = Stream.iterate("", (str) -> str + "x"); 
		//System.out.println(st.limit(3).collect(Collectors.toList()));
		System.out.println(st.limit(3).map(str -> str + "y").collect(Collectors.toList()));
		
		//Remove dublicate element 
	System.out.println(Stream.of(1,2,3,4,2,6,1,3,8,9).distinct().collect(Collectors.toList()));
	
	System.out.println(Stream.of(1,2,3,4,2,6,1,3,8,9,2).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
	//Map<String, Long> requirementCountMap = requirements.stream().collect(Collectors.groupingBy(Requirement::getRequirementType, Collectors.counting()));
	
	Entry<Integer,Long>val =	Stream.of(1,2,3,4,2,6,1,3,8,9,2).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().max((s1,s2)->s1.getValue().compareTo(s2.getValue())).get();
	System.out.println(val.getKey()+" = "+val.getValue());
		    
	Integer max = Stream.of(1, 2, 3, 4, 5, 6,7)
            .max(Comparator.comparing(Integer::valueOf))
            .get();
		System.out.println("The Maximum number is: " + max);
	}

}
