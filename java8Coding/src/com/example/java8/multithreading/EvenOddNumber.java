package com.example.java8.multithreading;

public class EvenOddNumber {


	
public void displayEven(int num) {

		synchronized (this) {
			
			if (num % 2 == 0) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(" even F " + num);
				
				
			}
			this.notifyAll();

		}
	}

public void displayOdd(int num) {

	synchronized (this) {
		
		if (num % 2 != 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(" odd F " + num);
			
		}
		this.notifyAll();

	}
}

}
