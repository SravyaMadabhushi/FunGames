

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/RegistrationChecking")
public class RegistrationChecking extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user=request.getParameter("uName");
		String pass=request.getParameter("password");
		
		Model model=new Model();
		model.setUser(user);
		model.setPassword(pass);
		String name=user;
		
		int row=0;
		try
		{
			row=model.registrationChecking();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		if(row != 0)
		{
			HttpSession session=request.getSession();
			session.setAttribute("name",name);
			response.sendRedirect("./home.jsp");
		}
		else
			response.sendRedirect("./index.html");
	}

}
