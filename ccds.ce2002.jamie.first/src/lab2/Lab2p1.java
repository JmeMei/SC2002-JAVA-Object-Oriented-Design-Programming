package lab2;

import java.util.Scanner; 
import java.lang.Math;

public class Lab2p1 { 
	public static void main(String[] args) 
	{ 
		int choice; 
		Scanner sc = new Scanner (System.in);
		do { 
			System.out.println("Perform the following methods:"); 
			System.out.println("1:  multiplication test"); 
			System.out.println("2:  quotient using division by subtraction"); 
			System.out.println("3:  remainder using division by subtraction"); 
			System.out.println("4:  count  the  number of digits"); 
			System.out.println("5:  position of a digit"); 
			System.out.println("6:  extract all odd digits"); 
			System.out.println("7:  quit"); 
			choice = sc.nextInt(); 
			switch (choice) { 
				case 1: /* add mulTest() call */ 
					mulTest();
					break; 
				case 2: /* add divide() call */ 
					break;  
				case 3: /* add modulus() call */ 
					break;  
				case 4: /* add countDigits() call */ 
					break; 
				case 5: /* add position() call */ 
					break;  
				case 6: /* add extractOddDigits() call */ 
					break;  
				case 7: System.out.println("Program terminating …."); 
			}  
		} while (choice < 7); 
	} 
		/* add method code here */ 
	public static void mulTest() {
		Scanner sc = new Scanner(System.in);
		int digit1, digit2, answer, correctCounter=0;
		
		int max = 9, min = 1; //for random digit (random number must be  1-9)
		int range = max - min + 1;
		
		for (int i = 1; i <= 5; i++) {
			digit1 = (int)(Math.random() * range) + min;
			digit2 = (int)(Math.random() * range) + min;
			answer = digit1 * digit2;
			
			//use printf instead of print to support %d
			//System.out.print(String.format("How much is %d times %d?", digit1, digit2));
			//System.out.print("How much is " + digit1 + " times " + digit2 + "?");

			System.out.printf("How much is %d times %d?", digit1, digit2); 
			
			answer = sc.nextInt();
			if(answer == digit1 * digit2) correctCounter++;
		}
		System.out.printf("%d answers out of 5 are correct", correctCounter);
	}
} 