package com.example.java8.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraySort {

	public static void main(String[] args) {
		
		int arry [] = {1,0,1,0,1,0};
		
	int [] list =	Arrays.stream(arry).sorted().toArray();
	
	Object [] arr =Stream.of(arry).sorted().toArray();
	
	
	for(int i=0;i<list.length;i++) {
		System.out.println(list[i]);
	}
	
	System.out.println("****************************************");
	
	List<Integer>  list1 =Arrays.stream(arry).boxed().sorted((a,b)-> b.compareTo(a)).collect(Collectors.toList());
	
	list1 =Arrays.stream(arry).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	
	list1.forEach(val->{
		System.out.println(val);
	});

	System.out.println("****************************************");
	
	}

}
