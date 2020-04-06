package edu.web.servlet02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/LifeCycleServlet", loadOnStartup = 1)
// loadOnStartup :
// - 서버가 실행될 때 서블릿 인스턴스를 메모리에 로드하는 우선 순위를 설정
// - 숫자가 작을수록 init() 함수가 실행되는 순서가 빠름
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LifeCycleServlet() {
		super();
		System.out.println("LifeCycleServlet 생성자 호출");
	}

	// init() : Servlet 인스턴스가 생성된 후 초기화 작업을 위해 호출되는 생명주기메소드
	// - 특별한 설정이 없으면, 서버가 init() 메소드를 호출하여 Servlet을 초기화
	// - Servlet 설정에서 loadOnStartup을 설정하면
    //   우선 순위에 따라서 서버가 실행될 때 init() 메소드가 호출됨
	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycleServlet init() 호출");
		super.init();
	}
	
	// Service() : 외부에서 Servlet으로 특정 HTTP 요청(Get, Post)을 처리하는 생명주기메소드
	// - doGet()과 doPost()가 service()의 역할을 분할해서 담당
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("LifeCycleServlet service() 호출");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// destroy() : Servlet이 종료될 때 호출되는 생명주기메소드
	@Override
	public void destroy() {
		System.out.println("LifeCycleServlet destroy() 호출");
		super.destroy();
	}

}
