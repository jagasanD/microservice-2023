package com.example.java8.sort;

import java.time.Duration;
import java.time.LocalTime;

public class FindSecondLargest {

	public static void main(String[] args) {

		int a[] = { 12, 35, 1, 10, 1, 34 };
		int n = a.length;
		LocalTime startTime = LocalTime.now();
		int answer = findSecondLargest(a, n);

		System.out.println("The second largest element in the array is: " + answer);
		
		 // Execution - end time
        LocalTime endTime = LocalTime.now();
        // find difference
        Duration duration = Duration.between(startTime, endTime);
        long differenceInNano = duration.getNano();
        
        System.out.println(differenceInNano);
		
		
	}

	private static int findSecondLargest(int[] a, int n) {

		 /*
        Initialize the variable first_largest with the value 0 and second_largest with the value -1.
        */
        int first_largest = 0;
        int second_largest = -1;

        /*
        Now update the values of first_largest and second_largest in each iteration as per the approach.
        */
        for (int i = 0; i < n; i++) {
            if (a[i] > a[first_largest]) {
                second_largest = first_largest;
                first_largest = i;
            } else if (a[i] < a[first_largest]) {
                if (second_largest == -1 || a[second_largest] < a[i])
                    second_largest = i;
            }
        }

        return a[second_largest];
	}
	/*
	Complexity Analysis
	In this effective approach to find second largest element in array, 
	we are traversing the array only once. Apart from that, we are not using any extra space 
	rather than two variables namely first_largest and second_largest.

	Time Complexity
	The time complexity of the above approach to find second largest number in array is O(n),
	 where n is the number of elements present in the array.

	Space Complexity
	The space complexity of the above approach is O(1).
	
	O(n*log(n)) means you are doing better than o(n2) but worse than O(n) linear 
	
	o(n) < o(n*log(n))  < o(n2)
	
	*/
	//17208900

}
