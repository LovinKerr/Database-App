package com.luv2code.servletdemo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luv2code.servletdemo.mvc2.Student;
import com.luv2code.servletdemo.mvc2.studentDataUtil;

/**
 * Servlet implementation class MvcDemoServlet2
 */
@WebServlet("/MvcDemoServlet2")
public class MvcDemoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MvcDemoServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step 1. get the student data from helper class(model)
		List<Student> students = studentDataUtil.getStudents();
		
		//step 2. add students to request attribute
		request.setAttribute("student_list", students);
		
		//step 3. get request dispatcher w/ jsp file
		RequestDispatcher dispatcher = request.getRequestDispatcher("view_students_two.jsp");
		
		//step 4. forward to JSP
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
