package edu.web.servlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login_test")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 파라미터(request parameter)의 값을 읽어옴
		// GET 방식에서 요청 파라미터는 URL 주소의 query string에 포함되어 있음.
		// http://localhost:8080/Web06_Servlet/login_test?userid=xxx&userpw=xxx
		// - http: 프로토콜
		// - localhost: 서버 주소(도메인 이름)
		// - 8080: 포트번호
		// - Web06_Servlet: context root(서버에서 파일을 찾아갈 최초 경로)
		System.out.println("LoginServlet doGet() 호출");
		login(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet doPost() 호출");
		login(request, response);
	}
	
	// HttpServletRequest : 요청한 HTTP의 객체(ip 주소, 파라미터 등)를 저장하는 클래스
	// HttpServletResponse : HTTP 요청에 대응하는(보내는) 정보를 저장하는 클래스
	// * 중요 : request와 response의 객체를 생성하고 호출하는 역할은 서버에서 컨트롤
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("login() 호출");
		String ip = request.getRemoteAddr(); // 요청한 HTTP의 IP주소를 얻어옴
		System.out.println("[" + ip + "]");
		
		// 요청 파라미터(request parameter)의 값을 읽어옴.
		String userid = request.getParameter("userid"); // login.html -> name="userid"
		String password = request.getParameter("password"); // login.html -> name="password"
		System.out.println("아이디 : " + userid);
		System.out.println("비밀번호 : " + password);
		
		/* 새로운 페이지를 생성하는 방식 */
		// 요청에 대응하는 데이터 인코딩 설정
		response.setCharacterEncoding("UTF-8");
		
		// PrintWriter 클래스
		// - HTML 페이지를 생성해주는 클래스
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>").
		append("<head><meta charset='utf-8'></head>").
		append("<body>").
		append("<h1>로그인 결과 페이지</h1>").
		append("아이디 : " + userid + "<br>").
		append("비밀번호 : " + password + "<br>").
		append("</body>").
		append("</html>");
	}

}
