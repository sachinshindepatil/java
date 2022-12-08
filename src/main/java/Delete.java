

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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
		PrintWriter out = response.getWriter();
		String bk_code=request.getParameter("bk_code");
		if(bk_code.isEmpty())
		{
			RequestDispatcher rd=request.getRequestDispatcher("Delete.html");
			out.println("<center>Please Fill All The Fields..</center>");
			rd.include(request, response);
		}
		else {
		
		try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection 
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
		Statement stm=con.createStatement();
		int i=stm.executeUpdate("delete from lms.book_details where book_code='"+bk_code+"'");
		if(i==0) 
			{
		out.println("<html><body><center><Record Does Not Exist...</center></body></html>");
		request.getRequestDispatcher("Delete.html").include(request, response);
		}
		else 
		{
			out.println("<html><body><center>Book Details Record "
					+ "Deleted...</center></body></html>");
			request.getRequestDispatcher("Delete.html").include(request, response);
		}
	} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		}

	}

}
