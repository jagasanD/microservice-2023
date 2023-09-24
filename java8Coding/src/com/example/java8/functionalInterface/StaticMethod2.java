package com.example.java8.functionalInterface;

import java.util.function.Consumer;


@FunctionalInterface
interface Printable{
	public void print(String message);
}
public class StaticMethod2 {
	
	public void display(String mesg) {
		System.out.println(mesg.toUpperCase());
	}
	
	public static void main(String[] args) {
		
		Consumer<String> cons = new StaticMethod2()::display;
		cons.accept("hello!");
		Printable con = new StaticMethod2()::display;
		con.print("hello guys!");

	}

}
