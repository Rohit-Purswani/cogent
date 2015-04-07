package com.rohit;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	String name="Rohit";
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String execute()
	{
		System.out.println("inside Action");
		setName("My name is "+name);
		return "success";
	}
}
