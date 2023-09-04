package Controller;

import java.io.IOException;



import dao.MyDao;
import dto.Customer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class CusLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
//		long phone=Long.parseLong(req.getParameter("mobile"));
		String pass = req.getParameter("pass");
		MyDao d = new MyDao();
		// verify email

		if (email.equals("admin@jsp.com") && pass.equals("admin")) {
			resp.getWriter().print("<h1>Admin login success</h1>");
			
			// getting session and setting value
			req.getSession().setAttribute("admin", "admin");
			
			req.getRequestDispatcher("AdminHomePage.html").include(req, resp);
			
		
		} else {
			Customer cust = d.fetchByEmail(email);
			if (cust == null) {
				resp.getWriter().print("<h1>invalid emain</h1>");
				req.getRequestDispatcher("LoginPage.html").include(req, resp);
			} else {
				if (pass.equals(cust.getPass())) {
					resp.getWriter().print("<h1>login success</h1>");
					req.getRequestDispatcher("index.html").include(req, resp);
				} else {
					resp.getWriter().print("<h1>invalid passwords..</h1>");
					req.getRequestDispatcher("LoginPage.html").include(req, resp);
				}
			}
		}
	}
}
