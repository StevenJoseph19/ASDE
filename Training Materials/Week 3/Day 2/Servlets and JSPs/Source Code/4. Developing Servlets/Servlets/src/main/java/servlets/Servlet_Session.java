package servlets;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_Session
 */
@WebServlet("/session_count")
public class Servlet_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Session() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get a reference to the session
		HttpSession session = request.getSession();
		
		// Get or create counter attribute
		Object att = session.getAttribute("counter");
		
		// initialize the count variable to 1
		int tempCount = 1;
		
		if (att != null) {

			AtomicInteger count = (AtomicInteger) att;
			tempCount = count.incrementAndGet();
		} else {
			AtomicInteger count = new AtomicInteger(1);
			session.setAttribute("counter", count);
		}
		
		// report the current count
		response.getWriter().println("Session Count = " + tempCount);
	}
	
//	public void invalidate();

}
