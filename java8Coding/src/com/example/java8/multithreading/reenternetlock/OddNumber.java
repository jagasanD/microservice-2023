package com.example.java8.multithreading.reenternetlock;

public class OddNumber implements Runnable{
	
	
	EvenOdd eo=null;
	public OddNumber(EvenOdd eo) {
	
		this.eo=eo;
	}

	@Override
	public void run() {
			for(int i=0;i<=100;i++) {
			eo.displayOdd(i);
	}
	}

}
