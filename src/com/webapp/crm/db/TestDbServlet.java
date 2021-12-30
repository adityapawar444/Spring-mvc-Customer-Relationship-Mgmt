package com.webapp.crm.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = "appuser";
		String password = "appuser";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String jdbcUrl = "jdbc:mysql://localhost:3306/crm_db?useSSL=false&serverTimezone=UTC";
		
		try {
			
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to Database : " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myconn = DriverManager.getConnection(jdbcUrl, username, password);
			
			out.println("Connection Successful !!!!");
			
			
			myconn.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
