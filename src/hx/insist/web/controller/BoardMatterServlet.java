package hx.insist.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hx.insist.dao.MatterDao;
import hx.insist.dao.UserDao;
import hx.insist.dao.impl.MatterDaoImpl;
import hx.insist.dao.impl.ReplyDaoImpl;
import hx.insist.dao.impl.UserDaoImpl;
import hx.insist.domain.Matter;
import hx.insist.domain.Reply;
import hx.insist.domain.User;


@WebServlet("/BoardMatterServlet")
public class BoardMatterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardMatterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到帖子详情
		String smatter_id = request.getParameter("matter_id");//得到String类型
		MatterDao mdao = new MatterDaoImpl();
		int matter_id = Integer.parseInt(smatter_id);//转换为int类型
		Matter matter = mdao.getmatter(matter_id);//得到了帖子的信息
		
		//得到帖子的所有评论
		ReplyDaoImpl rdao = new ReplyDaoImpl();
		List<Reply> list = rdao.searchAll(matter_id);//查看标题编号为matter_id下面的所有评论。//////////////不包括评论回复
		
		//还要得到发表帖子的人
		String matter_user_username = matter.getUser_username();
		UserDao udao = new UserDaoImpl();
		User matter_user = udao.getUser(matter_user_username);

		//设置到request域里，不让它一直占着域，因为第二次request时前一个request里的信息就消失了
		request.setAttribute("matter", matter);//帖子信息
		request.setAttribute("replies", list);//评论信息
		request.setAttribute("matter_user", matter_user);//发帖人的信息
		
		request.getRequestDispatcher("/WEB-INF/jsp/postinformation.jsp").forward(request, response);//转发
		//在帖子页面显示加载回复按钮  调到servlet整合回复数据    加载所有回复
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
