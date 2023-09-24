package com.example.java8.functionalInterface;

public class Test1Test2Implemenation implements Test1Test2Extend{

	@Override
	public void m1() {
		
		System.out.println(" impl m1");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test1Test2Extend test = new Test1Test2Implemenation();
		test.m1();
		
		Test1 test1 = new Test1Test2Implemenation();
		test1.m1();
		
		Test2 test2 = new Test1Test2Implemenation();
		test2.m1();
	}

	

}
