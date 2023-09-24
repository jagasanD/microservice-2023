package com.example.java8.objectsorm;

public class C extends A implements I {

	@Override
	public void getMessage() {
		System.out.println("C class");
		
	}

	
	public static void main(String args[]) {
		
		C c = new C();
		c.getMessage();
		
		A a = new C();
		a.getMessage();
	}
}
