package com.example.java8.multithreading.reenternetlock;

import java.util.concurrent.locks.ReentrantLock;

public class EvenOdd {

	ReentrantLock lock = new ReentrantLock();
	ReentrantLock lock1 = new ReentrantLock();
	public void displayEven(int num) {
			
			if (num % 2 == 0) {
				lock.lock();
				System.out.println(" even F " + num);
			}
			if(lock.getHoldCount()>0)
			lock.unlock();

	}

public void displayOdd(int num) {
		if (num % 2 != 0) {
			lock1.lock();
			System.out.println(" odd F " + num);
			
		}
		if(lock.getHoldCount()>0)
		lock1.unlock();
}
}
