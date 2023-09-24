package com.example.java8.multithreading;

public class EvenNumber implements Runnable{

	EvenOddNumber eo=null;
	public EvenNumber(EvenOddNumber eo) {
	
		this.eo=eo;
	}

	@Override
	public void run() {
			for(int i=0;i<=100;i++) {
			eo.displayEven(i);
	}
	}

}
