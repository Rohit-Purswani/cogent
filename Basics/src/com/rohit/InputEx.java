package com.rohit;
import java.io.*;
import java.util.*;

public class InputEx {

	public static void main(String[] args) throws IOException{
		int x=2;int y=3;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string");
		String s1=br.readLine();
		System.out.println("Your name is:"+s1);
		System.out.println("enter first number");
		int s2=sc.nextInt();
		System.out.println("enter second number");
		int s3=sc.nextInt();
		System.out.println("the result is:"+(s2+s3));
		System.out.println((x>y)?x:y);
		int z=x<<1;int s=y<<2;
		System.out.println(z);
		System.out.println(s);
	}
}