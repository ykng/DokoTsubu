package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostTweetLogic;
import model.Tweet;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// confirm whether tweet list is exsist
		ServletContext application = this.getServletContext();
		List<Tweet> tweetList = (List<Tweet>) application.getAttribute("tweetList");

		if(tweetList == null){
			tweetList = new ArrayList<Tweet>();
			application.setAttribute("tweetList", tweetList);
		}

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if(loginUser != null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}else{
			response.sendRedirect("/DokoTsubu/");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tweetText = request.getParameter("tweet");

		if(tweetText != null && tweetText.length() != 0){
			ServletContext application = this.getServletContext();
			List<Tweet> tweetList = (List<Tweet>) application.getAttribute("tweetList");

			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			String userName = loginUser.getName();

			Tweet tweet = new Tweet(userName, tweetText);
			PostTweetLogic postTweetLogic = new PostTweetLogic();
			postTweetLogic.execute(tweet, tweetList);

			application.setAttribute("tweetList", tweetList);
		}else{
			request.setAttribute("errorMsg", "There is no tweet inputed");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}
}
