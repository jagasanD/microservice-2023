package com.example.java8.customclass;

import java.util.ArrayList;
import java.util.List;

public class DistinctCustomClass {

	public static void main(String[] args) {
		
		List<Person> list = new ArrayList<>();
		
		list.add(new Person("mohan","M",44));
		list.add(new Person("mohan","M",45));
		list.add(new Person("Shree","F",24));
		list.add(new Person("Raja","M",34));
		list.add(new Person("Raja","M",54));
		list.add(new Person("Mona","F",34));
		
		list =list.stream().distinct().toList();
		
		System.out.println(list);

	}

}
