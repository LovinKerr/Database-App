package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	//set a reference DB Util
	private StudentDbUtil studentDbUtil;
	
	//use JavaEE resource injection, which inject data source(connection pool) here
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	//initialize studentDbUtil
	//in servlet, they have a special method that you could override init
	
	//init will be called by the app server when this servlet is initialized
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		//create our student db util, pass in the conn pool / datasource
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		// list the students ... in MVC fashion: get the data, set the attribute, use the request dispatcher, send over to JSP
		//define the helper method to do this 
			listStudents(request, response);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	//helper class
	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//throw the exception to the calling program
		
		//get students from db util
		List<Student> students = studentDbUtil.getStudents();
		
		
		System.out.println(students == null? "null" : students.size());
		
		//add students to the request
		request.setAttribute("STUDENT_LIST", students);
		
		//send to JSP page(view)
		//“/” represent root directory, if no "/" represent current directory
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}


}
