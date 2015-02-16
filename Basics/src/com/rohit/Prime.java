package com.rohit;
import java.util.*;

public class Prime {

	public static void main(String[] args) {
		
		      System.out.println("Enter the number till which prime number to be printed: ");
		      int n = new Scanner(System.in).nextInt();
		      System.out.println("Printing prime number from 1 to " + n);
		      for(int number = 2; number<=n; number++)
		          if(isPrime(number)){
		              System.out.println(number);
		          }
		      }

		    public static boolean isPrime(int number){
		        for(int i=2; i<number; i++){
		           if(number%i == 0){
		               return false;
		           }
		        }
		        return true; 
		    
		    }
		

		

	}


