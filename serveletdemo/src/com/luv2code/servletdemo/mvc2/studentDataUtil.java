package com.luv2code.servletdemo.mvc2;

import java.util.ArrayList;

import java.util.List;

//It's helper class as the model in MVC which will be called by servlet

public class studentDataUtil {

	public static List<Student> getStudents() {
		//create a empty list
		List<Student> students = new ArrayList<>();
		
		//add sample data
		students.add(new Student("Kerr", "Hu", "lovinkerr@gmail.com"));
		students.add(new Student("John", "Doe", "lovinJohn@gmail.com"));
		students.add(new Student("Ke", "Hi", "lovinke@gmail.com"));
		//return the list
		return students;
	}
}
