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
		//�õ���������
		String smatter_id = request.getParameter("matter_id");//�õ�String����
		MatterDao mdao = new MatterDaoImpl();
		int matter_id = Integer.parseInt(smatter_id);//ת��Ϊint����
		Matter matter = mdao.getmatter(matter_id);//�õ������ӵ���Ϣ
		
		//�õ����ӵ���������
		ReplyDaoImpl rdao = new ReplyDaoImpl();
		List<Reply> list = rdao.searchAll(matter_id);//�鿴������Ϊmatter_id������������ۡ�//////////////���������ۻظ�
		
		//��Ҫ�õ��������ӵ���
		String matter_user_username = matter.getUser_username();
		UserDao udao = new UserDaoImpl();
		User matter_user = udao.getUser(matter_user_username);

		//���õ�request���������һֱռ������Ϊ�ڶ���requestʱǰһ��request�����Ϣ����ʧ��
		request.setAttribute("matter", matter);//������Ϣ
		request.setAttribute("replies", list);//������Ϣ
		request.setAttribute("matter_user", matter_user);//�����˵���Ϣ
		
		request.getRequestDispatcher("/WEB-INF/jsp/postinformation.jsp").forward(request, response);//ת��
		//������ҳ����ʾ���ػظ���ť  ����servlet���ϻظ�����    �������лظ�
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
