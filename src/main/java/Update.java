

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		String bk_title=request.getParameter("bk_name");
		String author=request.getParameter("author");
		String bk_edition=request.getParameter("bk_edition");		
		String price=request.getParameter("price");
		
		if(bk_code.isEmpty()||bk_title.isEmpty() ||author.isEmpty()|| bk_edition.isEmpty()||price.isEmpty())
		{
			RequestDispatcher rd=request.getRequestDispatcher("Update.html");
			out.println("<center>Please Fill All The Fields..</center>");
			rd.include(request, response);
		}
		else {
		
		
		try 
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection 
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
		PreparedStatement pst=con.prepareStatement("update book_details set book_title=?,  author=?, book_edition=?, price=?  where book_code=?");
		Statement stm= con.createStatement();
		int i =stm.executeUpdate("update book_details set book_title='"+bk_title+"',author='"+author+"', "
				+ "book_edition='"+Integer.parseInt(bk_edition)+"',price='"+Float.parseFloat(price)+"' where book_code='"+bk_code+"'");
		if(i==0) 
		{
			out.println("<html><body><center>Record Does Not Exist...</center></body></html>");
			request.getRequestDispatcher("Update.html").include(request, response);
		}
		else 
		{
			out.println("<html><body><center>Book_Details Updated..</center></body></html>");
			request.getRequestDispatcher("Update.html").include(request, response);
		}
	} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		}

	}

}
