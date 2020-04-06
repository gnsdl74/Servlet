package edu.web.servlet05;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SendToClientServlet")
public class SendToClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SendToClientServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.setAttribute
		// - 특정 페이지에 데이터를 전송(Server side에 직접 저장)
		// - 문자열뿐만 아니라, 다양한 변수 및 객체를 전송할 수 있음
		// * request.getParameter는 string 형태의 값만 저장
		// request.setParameter(); : 파라미터는 form 외의 위치에서 데이터를 추가할 수 없음
		
		request.setAttribute("name", "고길동");
		request.setAttribute("lived", "서울 강남");
		request.setAttribute("age", 40);
		ServletContext context = getServletContext();
		RequestDispatcher dp = context.getRequestDispatcher("/my_info.jsp");
		
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
