package com.example.java8.multithreading.reenternetlock;


public class mainClass {
	
	
	public static void main(String[] args) {

		EvenOdd eo = new EvenOdd();
		EvenNumber evn = new EvenNumber(eo);
		OddNumber  odd = new OddNumber(eo);
	
	Thread t1 = new Thread(evn);
	Thread t2 = new Thread(odd);
	t1.start();
	t2.start();
	
	}
	

}
