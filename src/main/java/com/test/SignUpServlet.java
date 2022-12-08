package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		if(name.isEmpty()||password.isEmpty())
		{
			out.println("<html><body><center>Please Fill From Properly...</center></body></html>");
			request.getRequestDispatcher("signUp.jsp").include(request, response);
		}
		else
		{
			
		try 
		{
			char c=name.charAt(0);
			if(c>='a' && c<='z' || c>='A' && c<='Z')
			{
				
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = null;

	 			
		con	= DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
	 
		PreparedStatement pst=con.prepareStatement("insert into login values(?,?);");
		pst.setString(1,name);
		pst.setString(2, password);
		pst.executeUpdate();
		out.println("<html><body><center>User Created Sucessfully...</center></body></html>");
		request.getRequestDispatcher("signUp.jsp").include(request, response);
			}
			else 
			{
				out.println("<html><body><center>Please Fill Name Properlry...</center></body></html>");
				request.getRequestDispatcher("signUp.jsp").include(request, response);
			}
		}catch(SQLIntegrityConstraintViolationException S)
		{
			out.println("<html><body><center>UserName already Taken...</center></body></html>");
			request.getRequestDispatcher("signUp.jsp").include(request, response);
		}
		catch(NumberFormatException N)
		{
			out.println("<html><body><center>Please Fill UserName  Properly...</center></body></html>");
			request.getRequestDispatcher("signUp.jsp").include(request, response);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
		}
	}

}
