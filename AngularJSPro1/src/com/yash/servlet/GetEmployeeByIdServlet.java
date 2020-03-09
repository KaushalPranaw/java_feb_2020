package com.yash.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.yash.entities.Employee;


/**
 * Servlet implementation class GetEmployeeByIdServlet
 */
@WebServlet("/getEmployeeById")
public class GetEmployeeByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployeeByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId=Integer.parseInt(request.getParameter("empId"));
		try(Connection con=DBConnection.getConnection())
		{
			PreparedStatement pst1=con.prepareStatement("select * from emp where emp_id=?");
			pst1.setInt(1, empId);
			ResultSet rst=pst1.executeQuery();
			Employee employee = null;
			ArrayList<Employee> empList=new ArrayList<>();
			while(rst.next())
			{
				 employee=new Employee(rst.getInt("emp_id"), rst.getString("emp_name"), rst.getDouble("emp_salary"), rst.getString("emp_designation"));
				 empList.add(employee);
				
			}
			String jsonData=JSONObject.valueToString(empList);
			ServletOutputStream sos=response.getOutputStream();
			sos.write(jsonData.getBytes());
			
		} catch (ClassNotFoundException | SQLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
