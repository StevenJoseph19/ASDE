package servlets;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Context
 */
@WebServlet("/context_count")
public class Servlet_Context extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Context() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get a reference to the servlet context
		ServletContext ctx = request.getServletContext();

		// initialize the count variable to 1
		int tempCount = 1;

		// Get or create counter attribute
		Object att = ctx.getAttribute("counter");

		if (att != null) {

			AtomicInteger count = (AtomicInteger) att;
			tempCount = count.incrementAndGet();
		} else {
			AtomicInteger count = new AtomicInteger(1);
			ctx.setAttribute("counter", count);
		}

		// report the current count
		response.getWriter().println("Servlet Count = " + tempCount);
	}

}
