package hx.insist.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hx.insist.dao.MatterDao;
import hx.insist.dao.impl.MatterDaoImpl;
import hx.insist.domain.Matter;
import hx.insist.domain.User;

@WebServlet("/UserselfServlet")
public class UserselfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserselfServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到已登陆用户发表的所有帖子
		User user = (User) request.getSession().getAttribute("user");
		MatterDao mdao = new MatterDaoImpl();
		List<Matter> list = mdao.search(user.getUsername());
		request.getSession().setAttribute("user_Matter", list);
		request.getRequestDispatcher("/WEB-INF/jsp/userinformation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
