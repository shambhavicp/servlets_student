package com.ty.servlets_student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.servlets_student.dao.StudentDAO;
import com.ty.servlets_student.dto.Student;

public class StudentLogin extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		ServletContext context=getServletContext();
		String school=context.getInitParameter("school");
		 
		StudentDAO studentDAO=new StudentDAO();
	
		Student student=studentDAO.getStudent(id);
		if(email.equals(student.getEmail()) && password.equals(student.getPassword()) ) {
			
			resp.sendRedirect("https://stackoverflow.com/");
		}
		else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.html");
			requestDispatcher.forward(req, resp);
		}
	}

}
