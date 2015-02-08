package postG.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Nfirst
 */
@WebServlet("/Nfirst")
public class Nfirst extends HttpServlet implements Database {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement pst =null ; 
	
    public Nfirst() {
        super();
        // TODO Auto-g0enerated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		PrintWriter out =    response.getWriter();
		String userName =  request.getParameter("userName");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		openConnection();

	   
	
	   try {
		st = conn.createStatement();
		System.out.println(userName);
		System.out.println(password);
		pst = conn.prepareStatement("SELECT * FROM users WHERE \"userName\"='"+userName+"' and  \"password\" ='"+password+"'");
		rs = pst.executeQuery();
		
		if(rs.next()){
		int isAdmin = rs.getInt(4);
		System.out.println("here  and the admin value is " +isAdmin);
			         if(isAdmin == 1 ){    // if  is user 
				              RequestDispatcher rd = request.getRequestDispatcher("user.jsp");		
				              rd.forward(request, response);
			          }
			          else  if(isAdmin==0){   // go  to the Admin
			        	    RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");		
				              rd.forward(request, response);
				               
			           }
		   session.setAttribute("userName",userName);
	       session.setAttribute("password",password);
            
		}
		else{
	   System.out.println("no value");
              out.print("<script type=\"text/javascript\">"
              +  "window.location =\"http://localhost:8080/test/Login.html\""
              +  "</script>");
		}
		
		
		 closeConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

public  void openConnection(){	
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url + dbName, userName, "02030203");
			Statement st=conn.createStatement();
		} catch (SQLException  | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


}
public  void closeConnection(){
	try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
