

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Register")
public class Register extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("uName");
		String email=request.getParameter("uEmail");
		String pass=request.getParameter("password");
		
		Model model=new Model();
		model.setuname(name);
		model.setuEmail(email);
		model.setPassword(pass);
		
		int row=0;
		try {
		 row=model.register();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		session.setAttribute("name",name);
		if(row != 0)
		{
			response.sendRedirect("../SignIn");
			
		}
		else
		{
			response.sendRedirect("./Fail.jsp");
		}
		
	}

}
