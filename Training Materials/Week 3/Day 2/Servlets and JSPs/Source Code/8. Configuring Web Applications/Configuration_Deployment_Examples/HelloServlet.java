package com.mycompany.tomcat;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

import javax.servlet.ServletContext;

import java.util.Locale;

@WebServlet("")
public class HelloServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Get QueryString value
		String name = request.getParameter("name");
		if(name == null){
			name = "";
		}
		
		// Get Greeting
		ServletContext context = request.getServletContext();
		String greeting = context.getInitParameter("greeting");
		
		// output greeting
		response.getWriter().println(greeting + " " + name + " from HelloServlet.class");
	}

}





