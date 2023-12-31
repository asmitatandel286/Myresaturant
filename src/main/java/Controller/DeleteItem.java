package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDao;
import dto.FoodType;

@WebServlet("/delete")
public class DeleteItem extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		MyDao d=new MyDao();
		FoodType item=d.find(id);
		d.delete(item);
		
		resp.getWriter().print("<h1>Data deleted successfully...</h1>");
		req.getRequestDispatcher("ViewMenu.jsp").include(req, resp);
	}
}
