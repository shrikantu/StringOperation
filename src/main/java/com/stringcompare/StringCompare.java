package com.stringcompare;

public class StringCompare {

	public static void main(String[] args) {
	EmployeeCompare e1 = new EmployeeCompare(1,"shrikant" ,"15");
	EmployeeCompare e2 = new EmployeeCompare(1,"shrikant" ,"12");
	
System.out.println(e1.compareTo(e2));

	}

}
