

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
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
		
		try 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection 
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
		PreparedStatement pst=con.prepareStatement("insert into lms.book_details values(?,?,?,?,?);");
		ResultSet rs=pst.executeQuery("select * from book_details");
		while(rs.next()) 
		{
		out.println("<html><body><style>body{background-color: #00b36b;}</style></body></html>");
		out.println("<b>"+"Book_Code : "+rs.getString(1)+"</b>"+"<br>");
		out.println("Book_Title : "+rs.getString(2)+"&nbsp;");
		out.println("Author :"+rs.getString(3)+"&nbsp;");
		out.println("Book_Edition : "+rs.getInt(4)+"&nbsp;");
		out.println("Price : "+rs.getFloat(5)+"<br>"+"<br>");
		}
		
	} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

}
