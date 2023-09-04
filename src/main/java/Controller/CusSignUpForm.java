package Controller;

import java.io.IOException;

import java.time.LocalDate;
import java.time.Period;

import dao.MyDao;
import dto.Customer;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = "/signup", loadOnStartup = 1)
@MultipartConfig
public class CusSignUpForm extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("mobile"));
		String pass = req.getParameter("pass");

		// date logic
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		int age = Period.between(dob, LocalDate.now()).getYears();
		String gender = req.getParameter("male");
		String country = req.getParameter("country");

		// image logic Recive and convert to byte
		Part pic = req.getPart("photos");
		byte[] pi = null;
		pi = new byte[pic.getInputStream().available()];
		pic.getInputStream().read(pi);
		MyDao d = new MyDao();

		// logic to verify main and phone number
		if (d.fetchByEmail(email) == null && d.fetchByPhone(phone) == null) {
                      
			Customer cus = new Customer();
			cus.setName(name);
			cus.setEmail(email);
			cus.setPhone(phone);
			cus.setPass(pass);
			cus.setDob(dob);
			cus.setGender(gender);
			cus.setCountry(country);
			cus.setAge(age);
			cus.setPic(pi);

			//persisting 
			d.add(cus);

			resp.getWriter().print("<h1>account created </h1>");
		
			req.getRequestDispatcher("LoginPage.html").include(req, resp);
		} else {
			resp.getWriter().print("<h1>mail and phone number shoud be uniqe</h1>");
			req.getRequestDispatcher("SignupForm.html").include(req, resp);
			
		}
	}
}
