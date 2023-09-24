package com.example.java8.interImp;

@FunctionalInterface
interface Inter1 {

	// public void m1();
	public void m2();
}

@FunctionalInterface
public interface Inter2 extends Inter1 {

	public void m2();
}
