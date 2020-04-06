package edu.web.servlet04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ForwardTestServlet() {
        super();
    }

    // forward : URL 주소 유지. request/response 객체 유지
    // - 같은 웹 서버 내에 있는 파일들로만 이동이 가능
    // redirect : URL 주소 바뀜. request/response 객체 소멸
    // - 같은 서버/다른 서버에 있는 페이지로 이동이 가능
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("forward doGet() 호출");
		
		/* 나의 궁금증 ? getParameter()와 getAttribute()는 무슨 차이점인가 ?
		   -> HttpServletRequest 명세를 보면 setAttribute 는 있지만 setParameter 는 없다.
		      (개발자가 설정한 값이 아닌 사용자의 입력값을 받아오는 것이기 때문)
		   
		  parameter : 브라우저(사용자)에서 넘어온 값 
		   -> getParameter는 스트링 타입
		   -> getParameter는 스트링값을 다루기때문에 주로 쿼리스트링값등을 받는데 사용
		   
		  attribute : 개발자가 코딩으로 설정하는 값 
		   -> getAttribute 는 오브젝트 타입
		   -> getAttribute는 오브젝트 타입을 다루기때문에 자바빈객체나 다른클레스객체등을 받을때 사용
		 */
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		
		System.out.println("이름 : " + name + ", 나이 : " + age + ", 이메일 : " + email);
		/* 기존 페이지에 데이터를 보내는 방식 */
		// info.html -> ForwardTestServlet.java -> result.jsp
		// html은 데이터를 읽어오는 동적 기능이 없기 때문에 jsp로 데이터를 받아와야 함
		
		// forward 방식에서 페이지를 이동할 때는
		// RequestDispatcher 인터페이스의 forward(request, response)메소드를 사용
		// URL이 변경되지 않고 이동함
		
		/* 
		   ServletContext가 request의 최상위 클래스[즉, request의 데이터를 포함하고 있음]
		   - 두 가지 모두 이미 Server에 올라와있기 때문에 메모리 사용정도는 비슷
		   - 차이는 코드의 효율성정도
		 */
		//ServletContext context = getServletContext();
		RequestDispatcher dp = request.getRequestDispatcher("/result.jsp");
		
		// request에 있는 데이터를 jsp에 전달
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("forward doPost() 호출");
		response.sendRedirect("https://www.google.com");
	}

}
