package hx.insist.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hx.insist.domain.Reply;
import hx.insist.domain.User;
import hx.insist.service.impl.ReplyServiceImpl;

@WebServlet("/AddReplyServlet")
public class AddReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddReplyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String smatter_id = request.getParameter("matter_id");
		String sreceive_reply_id = request.getParameter("receive_reply_id");
		String reply_content = request.getParameter("reply_content");
		int matter_id = Integer.parseInt(smatter_id);//转换为int类型
		int receive_reply_id = Integer.parseInt(sreceive_reply_id);//转换为int类型
		
		User user = (User) request.getSession().getAttribute("user");
		String send_username = user.getUsername();//评论者为当前登陆用户
		
		Reply reply = new Reply();
		reply.setMatter_id(matter_id);
		reply.setReceive_reply_id(receive_reply_id);
		reply.setReply_content(reply_content);
		reply.setReply_date(new Date());
		reply.setSend_username(send_username);
		
		ReplyServiceImpl serivce = new ReplyServiceImpl();
		serivce.replies(reply, 1);
		request.getRequestDispatcher("/BoardMatterServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
