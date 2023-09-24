package com.example.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedList {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		List list = new ArrayList<>();
		
		list.add(12);
		list.add("jack");
		list.add(24.5);
		list.add(36);
		list.add("aaa");
		
		List<Integer> list1 = new ArrayList<>();
		
		list1.add(10);
		list1.add(20);
		list1.add(50);
		list1.add(70);
		list1.add(5);
		
		list1 =list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		
		System.out.println(list1);

	}

}
