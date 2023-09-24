package com.example.java8.interImp;

@FunctionalInterface
public interface Interface2 {

	public void fun1();
	
	default void def1() {
		System.out.println("--Interface2--");
	}
}
