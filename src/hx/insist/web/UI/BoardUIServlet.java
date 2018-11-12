package hx.insist.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hx.insist.domain.Matter;
import hx.insist.service.impl.MatterServiceImpl;


@WebServlet("/BoardUIServlet")
public class BoardUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public BoardUIServlet() {
        super();
    }
//登陆成功后跳转到这里
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MatterServiceImpl service = new MatterServiceImpl();
		List<Matter> list = service.getAllMatter();
		//每次回到这里，重新回去session域中的东西
		request.getSession().setAttribute("Matters", list);//把所有评论信息存进session域中
		
		response.sendRedirect(request.getContextPath() + "/board");//重定向
		//request.getRequestDispatcher("/WEB-INF/jsp/board.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
