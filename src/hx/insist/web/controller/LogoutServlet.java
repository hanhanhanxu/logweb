package hx.insist.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			session.removeAttribute("user");
			session.removeAttribute("Matters");
			session.removeAttribute("user_Matter");
		}
		
		//注销成功，跳转页面
		request.setAttribute("message", "已注销账户，浏览器将在三秒后跳转到首页...<meta http-equiv='refresh' content='3;url="+ request.getContextPath() +"/index.jsp'");
		 															    //<meta http-equiv='refresh' content='10;url=/logweb/index.jsp'>
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
