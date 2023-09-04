package Controller;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.MyDao;
import dto.FoodType;

@WebServlet("/viewIten")
public class ViewItem extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//logic to fetch data from database
		resp.getWriter().print("<h1>items here...</h1>");
		
		MyDao d=new MyDao();
		List<FoodType> items=d.fetchAllItem();
	
		
		if(items.isEmpty()) {
				resp.getWriter().print("<h1 style=color:red>No items</h1>");
				req.getRequestDispatcher("AdminHomePage.html").include(req, resp);
		}else{
			req.setAttribute("list", items);
			req.getRequestDispatcher("ViewMenu.jsp").include(req, resp);
		}
	}	
}
