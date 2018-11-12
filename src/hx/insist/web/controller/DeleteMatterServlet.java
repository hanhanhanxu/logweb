package hx.insist.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hx.insist.dao.MatterDao;
import hx.insist.dao.impl.MatterDaoImpl;
import hx.insist.domain.User;


@WebServlet("/DeleteMatterServlet")
public class DeleteMatterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteMatterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String smatter_id = request.getParameter("matter_id");
		int matter_id = Integer.parseInt(smatter_id);
		MatterDao mdao = new MatterDaoImpl();
		mdao.delete(matter_id);
		response.sendRedirect(request.getContextPath() + "/UserselfServlet");
		//request.getRequestDispatcher("/WEB-INF/jsp/userinformation.jsp").forward(request, response);
		return ;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
