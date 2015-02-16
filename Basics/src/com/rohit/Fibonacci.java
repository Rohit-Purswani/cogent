package com.rohit;
import java.util.*;
public class Fibonacci {

	public static void main(String[] args) {
		        System.out.println("Enter number upto which Fibonacci series to print: ");
		        Scanner sc=new Scanner(System.in);
		        int n=sc.nextInt();
		 
		        System.out.println("\nFibonacci series upto " + n +" numbers : ");
		        for(int i=1; i<=n; i++){
		            System.out.print(fibo(i) +" ");
		        }
		    } 
		 
		    public static int fibo(int number){
		        if(number == 1 || number == 2){
		            return 1;
		        }
		 
		        return fibo(number -1) + fibo(number -2); 
		    }
		 
		    public static int fibonaccisequence(int number){
		        if(number == 1 || number == 2){
		            return 1;
		        }
		        int fibo1=1, fibo2=1, fibonacci=1;
		        for(int i= 3; i<= number; i++){
		            fibonacci = fibo1 + fibo2; 
		            fibo1 = fibo2;
		            fibo2 = fibonacci;
		 
		        }
		        return fibonacci; 
		    }     
		

	}


