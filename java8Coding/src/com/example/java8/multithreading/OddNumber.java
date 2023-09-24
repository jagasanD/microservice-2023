package com.example.java8.multithreading;

public class OddNumber implements Runnable{

	EvenOddNumber eo=null;
	public OddNumber(EvenOddNumber eo) {
		this.eo=eo;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			eo.displayOdd(i);
		}
	}

}
