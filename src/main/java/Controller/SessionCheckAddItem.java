package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/additemsession")
public class SessionCheckAddItem  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// session verification
				if (req.getSession().getAttribute("admin") == null) {
					resp.getWriter().print("<h1 style='color:red'>Invalid session</h1>");
					req.getRequestDispatcher("LoginPage.html").include(req, resp);

				} else {
					req.getRequestDispatcher("AddItem.html").include(req, resp);
	}
	}
}
