package com.example.java8.multithreading.reenternetlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutiveFramework {

	public static void main(String[] args) {

		EvenOdd eo = new EvenOdd();
		EvenNumber evn = new EvenNumber(eo);
		OddNumber  odd = new OddNumber(eo);
		
		ExecutorService fixedPool = Executors.newFixedThreadPool(5);
		List<Runnable> list = new ArrayList<>();
		list.add(evn);
		list.add(odd);
		list.forEach((val)->{
			fixedPool.submit(val);
		});
		
		
	}

}
