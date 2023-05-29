package com.wileyedge.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wileyedge.model.Student;

/**
 * Servlet implementation class StudentRegistrationServlet
 */
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentRegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int mobile = Integer.parseInt(request.getParameter("mobile"));
		String address = request.getParameter("address");
		Student student = new Student(name, age, mobile, address);
		request.setAttribute("student", student);
		System.out.println("Student created:" + student);

		RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
		rd.forward(request, response);
	}

}
