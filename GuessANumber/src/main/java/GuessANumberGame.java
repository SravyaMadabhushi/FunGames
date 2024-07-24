
import java.util.Random;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/GuessANumberGame")
public class GuessANumberGame extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer computerChoice = (Integer) session.getAttribute("computerChoice");
		Integer attempts= (Integer)session.getAttribute("attempts");
		String message="";
		if(computerChoice == null)
		{
			computerChoice =new Random().nextInt(99);
			session.setAttribute("computerChoice", computerChoice);
			attempts=0;
		}
		int guess= Integer.parseInt(request.getParameter("userChoice"));
		attempts++;
		
		if(guess < computerChoice)
			message="Too Low!";
		else if(guess > computerChoice)
			message="Too High!";
		else {
			message="Your guess correct! in  "+attempts+" attempts 🥳";
			computerChoice = new Random().nextInt(99);
			session.setAttribute("computerChoice", computerChoice);
			attempts=0;
			
		}
		System.out.println("ComputerChoice : "+computerChoice);
		session.setAttribute("attempts",attempts);
		request.setAttribute("info", message);
		request.getRequestDispatcher("/result.jsp").forward(request, response);
		
	}

}
