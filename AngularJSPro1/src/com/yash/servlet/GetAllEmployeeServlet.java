package com.yash.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/getAllEmployee")
public class GetAllEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(Connection connection=DBConnection.getConnection();)
		{
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("SELECT * FROM emp");
			List<Employee> empList=new ArrayList<Employee>();
			while(resultSet.next())
			{
				Employee employee=new Employee(resultSet.getInt("emp_id"), resultSet.getString("emp_name"), resultSet.getDouble("emp_salary"), resultSet.getString("emp_designation"));
				empList.add(employee);
			}
			String jsonData=JSONObject.valueToString(empList);
			response.setContentType("application/json");
			ServletOutputStream sos=response.getOutputStream();
			sos.write(jsonData.getBytes());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
