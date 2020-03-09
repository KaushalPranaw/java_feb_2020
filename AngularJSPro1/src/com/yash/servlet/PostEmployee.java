package com.yash.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class PostEmployee
 */
@WebServlet("/postEmployee")
public class PostEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in doget");
		try {
			Connection con=DBConnection.getConnection();
			int empId=Integer.parseInt(req.getParameter("empId"));
			PreparedStatement pst1=con.prepareStatement("select * from emp where emp_id=?");
			pst1.setInt(1, empId);
			
			ResultSet rst=pst1.executeQuery();
			boolean flag=false;
			while(rst.next())
			{
				flag=true;
			}
			PrintWriter out=resp.getWriter();
			if(flag)
				out.print("exists");
			else
				out.print("notexists");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader bufferedReader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			sb.append(str);
		}
		try {
			JSONObject jsonObject = new JSONObject(sb.toString());
			int empId = jsonObject.getInt("empId");
			String empName = jsonObject.getString("empName");
			double empSalary = jsonObject.getDouble("empSalary");
			String empDesignation = jsonObject.getString("empDesignation");

			Connection con = DBConnection.getConnection();
			
			

			PreparedStatement pst = con.prepareStatement("insert into emp values(?,?,?,?)");
			pst.setInt(1, empId);
			pst.setString(2, empName);
			pst.setDouble(3, empSalary);
			pst.setString(4, empDesignation);

			int id = pst.executeUpdate();
			if (id > 0) {
				response.getWriter().print("Inserted with emp ID : " + empId);
			}
			else
				response.getWriter().print("Registration failed");

		} catch (JSONException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
