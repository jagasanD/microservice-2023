package com.example.java8.functionalInterface.defaultMethod;

public class EImplBoth implements Default1,Default2 {

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		Default1.super.m1();
		Default2.super.m1();
	}

}
