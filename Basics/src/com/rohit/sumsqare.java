package com.rohit;
import java.util.*;

public class sumsqare {

	public static void main(String[] args) {
		
		int sum=0,sum1=0,sum2=0;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter value of n: ");
		int n=input.nextInt();
		for(int i=1;i<=n;i++)
		{
		int sq=i*i;
		sum1+=sq;
		}
		System.out.println(sum1);
		for(int i=1;i<=n;i++)
		{
		sum+=i;
		}
		sum2=sum*sum;
		System.out.println(sum2);
		int diff=0;
		if(sum1>sum2)
		{
		diff=sum1-sum2;
		}
		else
		{
		diff=sum2-sum1;
		}
		System.out.println(diff);
		}
		

	}


