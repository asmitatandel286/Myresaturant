package Controller;

import java.io.IOException;

import javax.servlet.http.Part;

import dao.MyDao;
import dto.FoodType;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
@MultipartConfig
public class Update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// session verification
		if (req.getSession().getAttribute("admin") == null) {
			resp.getWriter().print("<h1 style='color:red'>Invalid session</h1>");
			req.getRequestDispatcher("LoginPage.html").include(req, resp);

		} else {

			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("itemname");
			String foodtype = req.getParameter("type");
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			double price = Double.parseDouble(req.getParameter("price"));
			// pic
			Part pic = req.getPart("picture");
			byte[] pi = null;
			pi = new byte[pic.getInputStream().available()];
			pic.getInputStream().read(pi);
			MyDao d = new MyDao();
			FoodType food = new FoodType();
			food.setId(id);
			food.setName(name);
//		food.setPic(pi);
			if (pi.length == 0) {
				food.setPic(d.find(id).getPic());

			} else {
				food.setPic(pi);
			}
			food.setPrice(price);

			food.setQuantity(quantity);
			food.setType(foodtype);

			d.update(food);

			resp.getWriter().print(" <h1>data updated</h1>");
			req.getRequestDispatcher("viewIten").include(req, resp);

		}

	}
}