package com.rohit;

public class Calculator {
	int i=10;//instance variable
	static int j=56;
	void display()
	{
	System.out.println("Hi");
	}
	int add(int a,int b)
	{
		System.out.println(a+b);
		return a+b;
	}
	/*static{
		System.out.println("calling static");
	}
	{
		System.out.println("calling empty block");
	}*/

	public static void main(String[] args) {
		int k=1;
		System.out.println("Welcome to Java");
		Calculator c1=new Calculator();
		System.out.println(c1.i);
		System.out.println(Calculator.j);
		System.out.println(j);
		System.out.println(k);
		c1.display();
		c1.add(12, 13);
	}

}
