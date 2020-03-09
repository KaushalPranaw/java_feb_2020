package com.yash.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Calc() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int first = Integer.valueOf(request.getParameter("first"));
		int second = Integer.valueOf(request.getParameter("second"));
		String method = request.getParameter("method");
		switch (method) {
		case "add":
			int sum=first+second;
			response.getWriter().println("Sum = "+sum);
			break;
		case "sub":
			int sub=first-second;
			response.getWriter().println("Sub = "+sub);
			break;
		case "mul":
			int mul=first*second;
			response.getWriter().println("Mul = "+mul);
			break;
		case "div":
			double div=Double.valueOf(first)/Double.valueOf(second);
			response.getWriter().println("Div = "+div);
			break;
		default:
			break;
		}

	}

}
