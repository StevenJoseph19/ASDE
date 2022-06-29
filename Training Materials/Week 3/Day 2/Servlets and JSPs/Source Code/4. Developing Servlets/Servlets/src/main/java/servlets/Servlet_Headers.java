package servlets;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Headers
 */
@WebServlet("/headers")
public class Servlet_Headers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Headers() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set content type
		response.setContentType("text/plain");

		String name = request.getParameter("name");

		if (name == null) {
			name = "";

		}

		// Determine language to use
		Locale locale = request.getLocale();

		String languageTag = locale.toLanguageTag().substring(0, 2);

		// Determine Greeting Language

		String greeting;

		switch (languageTag) {
		case "fr": // French
			greeting = "Bonjour ";
			break;

		case "de": // German
			greeting = "Guten Tag ";
			break;

		default: // anything else
			greeting = "Hello ";
			break;
		}

		response.getWriter().println(greeting + name);
		
		response.setHeader("Content-Language", languageTag);
	}

}
