package com.example.java8.simaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class LoginQuequeUsingSemaphore {

	private static Semaphore semaphore;
	
	public LoginQuequeUsingSemaphore() {
		
	}
	public LoginQuequeUsingSemaphore(Semaphore semaphore){
		
		this.semaphore=semaphore;
		
	}
	
	public boolean tryAcquire() {
		
		return semaphore.tryAcquire();
	}
	
	public void acquire() throws InterruptedException {
		 semaphore.acquire();
	}
	
	public void release() {
		
		semaphore.release();
	}
	
	public int avilableSlot() {
		
		return semaphore.availablePermits();
	}
	
	public static void main(String args[]) {
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		LoginQuequeUsingSemaphore login = new LoginQuequeUsingSemaphore(new Semaphore(5));
		
		IntStream.range(0, 3).forEach(user->{
			
			service.execute(login::tryAcquire);
		});
		
		System.out.println("avialbleSlot "+login.avilableSlot());
		System.out.println("hasQueueThreads "+semaphore.hasQueuedThreads());
		System.out.println("isFair "+semaphore.isFair());
		System.out.println("queueLenght "+semaphore.getQueueLength());
		
		
		
		
	}
}
