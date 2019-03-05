import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class Date1 extends HttpServlet{
	private String msg;
	public void init() throws ServletException {

	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Date d = new Date();
		out.println("<h1>"+d.toString()+"</h1>");
	}
	
	public void destroy(){
	}
}
	