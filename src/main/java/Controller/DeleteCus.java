package Controller;

import java.io.IOException;

import dao.MyDao;
import dto.Customer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletecus")
public class DeleteCus extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// session verification
				if (req.getSession().getAttribute("admin") == null) {
					resp.getWriter().print("<h1 style='color:red'>Invalid session</h1>");
					req.getRequestDispatcher("LoginPage.html").include(req, resp);

				} else {

		int id=Integer.parseInt(req.getParameter("id"));
		
		MyDao dao=new MyDao();
		Customer c=dao.findcusId(id);
		
		dao.deleteCus(c);
		
		resp.getWriter().print("<h1>Customer deleted successfully...</h1>");
		req.getRequestDispatcher("ViewCus.jsp").include(req, resp);
	}
}
}