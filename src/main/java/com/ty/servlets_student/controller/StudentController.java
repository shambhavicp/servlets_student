package com.ty.servlets_student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.servlets_student.dao.StudentDAO;
import com.ty.servlets_student.dto.Student;

public class StudentController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String fatherName=req.getParameter("fathername");
		String motherName=req.getParameter("mothername");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		ServletContext context=getServletContext();
		String school=context.getInitParameter("school");
		
		ServletConfig config=getServletConfig();
		long fees=Long.parseLong(config.getInitParameter("fees"));
		
		
		Student student=new Student();
		student.setName(name);
		student.setFatherName(fatherName);
		student.setMotherName(motherName);
		student.setEmail(email);
		student.setPassword(password);
		student.setSchool(school);
		student.setFees(fees);
		
		StudentDAO studentDAO=new StudentDAO();
		studentDAO.saveStudent(student);
		
		PrintWriter out=resp.getWriter();
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("successform.html");
		requestDispatcher.forward(req, resp);
		
		
		
	}

}
