package hx.insist.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hx.insist.domain.User;
import hx.insist.service.impl.BusinessServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		BusinessServiceImpl service = new BusinessServiceImpl();
		User user = service.login(username, password);
		if(user!=null) {
			//用户登陆成功后跳转到留言板页面,并记录用户的信息
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/BoardUIServlet");
			//response.sendRedirect(request.getContextPath() + "/board"); //重定向 发给浏览器，浏览器再请求一个新的url地址，相当于直接再地址栏里又输了一遍，外界不能直接访问WEB-INF下面的东西
			//request.getRequestDispatcher("/WEB-INF/jsp/board.jsp").forward(request, response);//转发
			return ;
		}
		
		request.setAttribute("message", "用户名或密码错误!");
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
