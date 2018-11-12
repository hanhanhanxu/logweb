package hx.insist.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hx.insist.domain.Reply;
import hx.insist.service.impl.ReplyServiceImpl;

@WebServlet("/AddcontentServlet")
public class AddcontentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddcontentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String matter_content = request.getParameter("matter_content");
		String smatter_id = request.getParameter("matter_id");
		int matter_id = Integer.parseInt(smatter_id);
		String matter_user_username = request.getParameter("matter_user_username");
		
		Reply reply = new Reply();
		reply.setMatter_id(matter_id);
		reply.setSend_username(matter_user_username);
		reply.setReply_date(new Date());
		reply.setReply_content(matter_content);
		
		ReplyServiceImpl service = new ReplyServiceImpl();
		service.replies(reply, 0);
		request.getRequestDispatcher("/BoardMatterServlet").forward(request, response);//×ª·¢
		return ;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
