package hx.insist.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hx.insist.dao.MatterDao;
import hx.insist.dao.UserDao;
import hx.insist.dao.impl.MatterDaoImpl;
import hx.insist.dao.impl.UserDaoImpl;
import hx.insist.domain.Matter;
import hx.insist.domain.User;

@WebServlet("/BoardUserServlet")
public class BoardUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//发帖人详情
		String username = request.getParameter("user_username");
		UserDao udao = new UserDaoImpl();
		User user = udao.getUser(username);//得到用户信息
		request.setAttribute("watch_user", user);
		
		MatterDao mdao = new MatterDaoImpl();
		List<Matter> list = mdao.search(username);//得到此用户的帖子信息
		request.getSession().setAttribute("watch_user_Matter", list);
		request.getRequestDispatcher("/WEB-INF/jsp/puserinformation.jsp").forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
