import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class hello extends HttpServlet{
	private String msg;
	public void init() throws ServletException {
		msg = "Hello World";
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h1>"+msg+"</h1>");
	}
	
	public void destroy(){
	}
}
	