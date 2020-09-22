package mathgame.eric.com;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class PlayerControllerServlet
 */
@WebServlet("/PlayerControllerServlet")
public class PlayerControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlayerDbUtil playerDbUtil; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Resource(name="jdbc/mathgame")
	private DataSource dataSource; 
	
    public PlayerControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			playerDbUtil = new PlayerDbUtil(dataSource); 
			
		} catch (Exception exc) {
			throw new ServletException(exc); 			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/registration-form.jsp"); 
			dispatcher.forward(request, response);			
		} catch (Exception exc) 
		{
			throw new ServletException(exc); 			
		}
	}
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String theCommand = request.getParameter("command"); 
			
			switch (theCommand) {
				case "VALID_REGISTRATION":	
					System.out.println("VALID REGISTRATION...");
					registerPlayer(request, response); 
					break;	
				case "LOG_IN":
					System.out.println("CHECK LOG IN DETAIL...");
					checkLogIn(request, response); 
					break; 	
				case "SAVE":
					System.out.println("SAVING...");
					save(request, response); 
					break; 
				case "MY_SCORE":
					System.out.println("CHECK MY SCORE...");
					displayMyScore(request, response); 
					break; 
				case "RELOAD":
					System.out.println("RELOADING...");
					reload(request, response); 
					break;
				case "HIGH_SCORE":
					System.out.println("CHECK MY SCORE...");
					displayHighScore(request, response); 
					break;
				case "LOG_OUT": 
					System.out.println("LOGGING OUT...");
					logOut(request, response); 
					break; 
				default: 
					System.out.println("DEFAULT COMMAND USED....");				
			}
		} 
		catch (Exception exc) {
			throw new ServletException(exc); 
		}
	}

	private void logOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp"); 
			dispatcher.forward(request, response);			
		} catch (Exception exc) 
		{
			throw new ServletException(exc); 			
		}
		
		
	}

	private void displayHighScore(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("currentUserName"); 
		
		List<PlayerScore> highScores = playerDbUtil.listHighScores(); 
		
		request.setAttribute("HIGH_SCORE_LIST", highScores);
		request.setAttribute("USER_NAME", userName);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/high-score.jsp");
		dispatcher.forward(request, response);
		
	}

	private void reload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("currentUserName"); 
		request.setAttribute("USER_NAME", userName);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/math-game.jsp");
		dispatcher.forward(request, response);
	}

	private void displayMyScore(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String userName = request.getParameter("currentUserName"); 
		
		List<PlayerScore> myScores = playerDbUtil.listPlayerScore(userName); 
		
		request.setAttribute("MY_SCORE_LIST", myScores);
		request.setAttribute("USER_NAME", userName);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/my-score.jsp");
		dispatcher.forward(request, response);
		
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String score = request.getParameter("currentScore");
		String currentUserName = request.getParameter("currentUserName"); 	
		
		playerDbUtil.save(currentUserName, score); 		
		
		request.setAttribute("USER_NAME", currentUserName);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/math-game.jsp");
		dispatcher.forward(request, response);
	}

	private void checkLogIn(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userName = request.getParameter("userName"); 
		String password = request.getParameter("password"); 
		
		boolean checkLogInDetail = playerDbUtil.checkLogIn(userName, password); 
		
		if (checkLogInDetail == true) {
			// Go to mathGame
			request.setAttribute("USER_NAME", userName);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/math-game.jsp");
			dispatcher.forward(request, response);
		} else {
			// Call unsuccessfully Log In page.. 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/unsuccessful-login.jsp"); 
			dispatcher.forward(request, response);			
		}
		
	}

	private void registerPlayer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName"); 
		boolean userNameChecking = playerDbUtil.checkUserName(userName); 
		
		if (userNameChecking == true) {
			System.out.println("USERNAME ALREADY EXIST...");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/invalid-username.jsp"); 
			dispatcher.forward(request, response);
		} 		
		
		String firstName = request.getParameter("firstName"); 
		String lastName = request.getParameter("lastName"); 
		String postCode = request.getParameter("postCode"); 
		String email = request.getParameter("email"); 
		String password = request.getParameter("password"); 
		
		// Create new Player 
		Player player = new Player(userName, firstName, lastName, postCode, email, password); 
		
		// Add to databases 
		playerDbUtil.registerPlayer(player); 
		
		// Redirect to other page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/registration-successfully.jsp"); 
		dispatcher.forward(request, response);
		
	}	

}
