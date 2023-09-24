package com.example.java8.interImp;
@FunctionalInterface
public interface Interface3 extends Interface1,Interface2{

	@Override
	default void def1() {
		
		Interface1.super.def1();
		Interface2.super.def1();
	}

	
}
