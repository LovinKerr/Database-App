package com.luv2code.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Define datasource/connectio pool for Resource Injection
	//add annotation here
	@Resource(name="jdbc/web_student_tracker") // exactly same name used in our context config file
	private DataSource dataSource; //data member? filed?
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Step 1. Set up the printwriter --> to send data back to browser
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain"); //set the content type
		
		//Step 2. Get a connection to the database
		//set up some SQL object here as null for now
		Connection myConn = null; //?
		Statement myStmt = null; //?
		ResultSet myRs = null; //? will assign it in the following steps
		
		try { 
			myConn = dataSource.getConnection();
		
		//Step 3. Create a SQL statements
		String sql = "select * from student";
		myStmt = myConn.createStatement();
		
		//Step 4. Execute SQL query
		myRs = myStmt.executeQuery(sql);
		
		//Step 5. Process the result set
		while (myRs.next()) {
			String email = myRs.getString("email"); //getting the email from that given column name
			out.println(email); //send data back to browser, no to the standard out
		}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
}

