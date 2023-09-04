package Controller;

import java.io.IOException;


import dao.MyDao;
import dto.FoodType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditItem extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// session verification
				if (req.getSession().getAttribute("admin") == null) {
					resp.getWriter().print("<h1 style='color:red'>Invalid session</h1>");
					req.getRequestDispatcher("LoginPage.html").include(req, resp);

				} else {

		int id=Integer.parseInt(req.getParameter("id"));
//		int id=Integer.parseInt(req.getParameter("id"));
		
		MyDao d=new MyDao();
		
		FoodType item=d.find(id);
		
		req.setAttribute("item", item);
		req.getRequestDispatcher("Edit.jsp").include(req, resp);
	}
	}
}
