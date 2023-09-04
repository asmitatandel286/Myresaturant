package Controller;

import java.io.IOException;
import java.util.List;

import dao.MyDao;
import dto.Customer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewCus")
public class ViewCust extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// session verification
		if (req.getSession().getAttribute("admin") == null) {
			res.getWriter().print("<h1 style='color:red'>Invalid session</h1>");
			req.getRequestDispatcher("LoginPage.html").include(req, res);

		} else {
			res.getWriter().print("<h1>custemor here...</h1>");

			MyDao d = new MyDao();
			List<Customer> cus = d.fetchCustomer();

			if (cus.isEmpty()) {
				res.getWriter().print("<h1 style=color:red>No items</h1>");
				req.getRequestDispatcher("AdminHomePage.html").include(req, res);

			} else {
				req.setAttribute("list", cus);
				req.getRequestDispatcher("ViewCus.jsp").include(req, res);
			}
		}
	}

}
