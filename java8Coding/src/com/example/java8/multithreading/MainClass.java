package com.example.java8.multithreading;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EvenOddNumber eo = new EvenOddNumber();
		EvenNumber evn = new EvenNumber(eo);
		OddNumber  odd = new OddNumber(eo);
		
		Thread t1 = new Thread(evn);
		Thread t2 = new Thread(odd);
		t1.start();
		t2.start();
		
		
		
	}

}
