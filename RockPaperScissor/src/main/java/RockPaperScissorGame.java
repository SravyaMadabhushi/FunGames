
import java.util.Random;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/RockPaperScissorGame")
public class RockPaperScissorGame extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userChoice= request.getParameter("choice");
		System.out.println("userChoice : "+userChoice);
		String choice[]= {"Rock","Paper","Scissor"};
		
		Random rand = new Random();
		int computerChoiceValue=rand.nextInt(3);
		String computerChoice=choice[computerChoiceValue];
		System.out.println("Computer Choice : "+computerChoice);
		String message="";
		
		if(userChoice.equals(computerChoice))
		{
			message="Tie 🙂";
		}
		
		else if((userChoice.equals("Rock") && computerChoice.equals("Scissor")) ||( userChoice.equals("Paper") && computerChoice.equals("Rock")) ||( userChoice.equals("Scissor") && computerChoice.equals("Paper")))
		{
			message="You Win!! 🏆";
		}
		else
		{
			message="Computer Win!! 💻";
		}
		request.setAttribute("info", message);
		getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
		
	}

}
