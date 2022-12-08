

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
			RequestDispatcher rd=request.getRequestDispatcher("Register.html");
			out.println("<center>Please Fill All The Fields..</center>");
			rd.include(request, response);
		}
		else {
		
		try 
	{
				
		Class.forName("com.mysql.jdbc.Driver");
		Connection 
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
		PreparedStatement pst=con.prepareStatement("insert into lms.book_details values(?,?,?,?,?);");
		con.setAutoCommit(false);
		pst.setString(1,bk_code);
		pst.setString(2, bk_title);
		pst.setString(3, author);
		pst.setInt(4, Integer.parseInt(bk_edition));
		pst.setFloat(5, Float.parseFloat(price));
		pst.addBatch();
		int [] i=pst.executeBatch();
		con.commit();
		for(int j=1;j<=i.length;j++) 
		{
			out.println("<html><body><style>body{background-color: #00b36b;}</style><center>Book Details Are Inserted...</center></body></html>");
			request.getRequestDispatcher("Register.html").include(request, response);
		}
			
	} 
	catch (Exception e) 
		{
			System.out.println(e);
		}
		
		}
		
	}

}
