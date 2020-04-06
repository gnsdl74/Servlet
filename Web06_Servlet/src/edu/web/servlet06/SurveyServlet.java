package edu.web.servlet06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/survey")
public class SurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SurveyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String pageName = "/game.jsp";
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String game = request.getParameter("game");
		String location = path + pageName + "?name=" + name + "&age=" + age + "&game=" + game;
		System.out.println(location);
		response.sendRedirect(location);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
