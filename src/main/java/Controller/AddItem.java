package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.MyDao;
import dto.FoodType;
import javax.servlet.annotation.MultipartConfig;

@WebServlet(urlPatterns = "/additem")
@MultipartConfig
public class AddItem  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String name =req.getParameter("itemname");
//		String foodtype=req.getParameter("type");
//		double price=Double.parseDouble(req.getParameter("price"));
//		int quantity=Integer.parseInt(req.getParameter("quantity"));
//		
		
		String name=req.getParameter("itemname");
		String foodtype=req.getParameter("type");
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		double price=Double.parseDouble(req.getParameter("price"));
		//pic
		Part pic = req.getPart("picture");
		byte[] pi = null;
		pi = new byte[pic.getInputStream().available()];
		pic.getInputStream().read(pi);
		
		
		MyDao d = new MyDao();
		
		FoodType f=new FoodType();
		f.setName(name);
		f.setType(foodtype);
		f.setQuantity(quantity);
		f.setPrice(price);
		f.setPic(pi);
		
		d.addfoodtype(f);
		
		System.out.println(name);
		System.out.println(foodtype);
		System.out.println(quantity);
		System.out.println(price);
		System.out.println(pi);
		
		
		resp.getWriter().print("<h1>Item Added Sccessfully...!!!</h1>");
		req.getRequestDispatcher("AdminHomePage.html").include(req, resp);
	}
}
