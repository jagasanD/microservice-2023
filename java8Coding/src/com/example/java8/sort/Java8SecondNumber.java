package com.example.java8.sort;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;

public class Java8SecondNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalTime startTime = LocalTime.now();
		Integer[] numbers = {5, 9, 11, 2, 8, 21, 1};
		Integer secondLargestNumber = Arrays
				.stream(numbers)
				//.boxed()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst()
				.get();
		
		 // Execution - end time
        LocalTime endTime = LocalTime.now();
        // find difference
        Duration duration = Duration.between(startTime, endTime);
        long differenceInNano = duration.getNano();
        
System.out.println(differenceInNano);

		
	}

}
//1040400
//19365600
