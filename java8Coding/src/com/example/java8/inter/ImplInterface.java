package com.example.java8.inter;

interface Emp {

	public static void m1() {

		System.out.println(" static m1");
	}
}

public class ImplInterface implements Emp{

	public void m1() {
		
		System.out.println(" class m1");
	}

	public static void main(String[] args) {
	
		Emp emp = new ImplInterface();
		//emp.m1(); Not allowed because Emp holding ImplClass object reference.
		Emp.m1();
		

	}

}
