package com.example.java8.functionalInterface;

interface A{
	
	public static void m1() {
		System.out.println("hi");
	}
}
public class StaticMetohd implements A{

	public void m1() {
		System.out.println("hi");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		StaticMetohd m = new StaticMetohd();
		m.m1();
		
		A m2 = new StaticMetohd();
		A.m1();
		//m2.m1(); //Erros
		
	}

}
