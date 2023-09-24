package com.example.java8.methodrefrence;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

@FunctionalInterface
interface Printable{
	public void print(String message);
}
public class MethodReferenceFirst {
	
	public void display(String mesg) {
		System.out.println(mesg.toUpperCase());
	}
	
	public static int addNumber(int a,int b) {
		
		return (a+b);
	}

	public static void main(String[] args) {
		Function<Integer,Double> f = (input)-> Math.sqrt(input);
		System.out.println(f.apply(4));
		
		Function<Integer,Double> ff =  Math::sqrt;
		System.out.println(ff.apply(8));
		//Static method reference 
		BiFunction<Integer,Integer,Integer> mj  = (a,b)->MethodReferenceFirst.addNumber(a, b);
		System.out.println(mj.apply(10, 20));
		
		BiFunction<Integer,Integer,Integer> mm  = MethodReferenceFirst::addNumber;
		System.out.println(mm.apply(10, 20));
		
		
		Consumer<String> cons = new MethodReferenceFirst()::display;
		cons.accept("hello!");
		
		Printable con = new MethodReferenceFirst()::display;
		con.print("hello guys!");
		
		

	}

}