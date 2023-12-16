
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    response.setContentType("text/html");
	    
	    String name=request.getParameter("uname");
	    String pass=request.getParameter("pass");
	    PrintWriter op=response.getWriter();
	    if(name.equals("cvr") && pass.equals("cvr")) {
	    	op.append("<a href='SecondServlet'>continue</a>");
	    	Cookie c1=new Cookie("name",name);
	    	response.addCookie(c1);
//	          response.sendRedirect("success.html");
	          
	    }
	    else {
	    	
		    op.append("<h1>invalid user<br /><br />Register first");
	    	RequestDispatcher rd=request.getRequestDispatcher("Register.html");
	    	rd.include(request, response);
	    	 
	    }
	    op.close();
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
