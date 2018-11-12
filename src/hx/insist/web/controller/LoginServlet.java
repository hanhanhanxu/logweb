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
			//�û���½�ɹ�����ת�����԰�ҳ��,����¼�û�����Ϣ
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/BoardUIServlet");
			//response.sendRedirect(request.getContextPath() + "/board"); //�ض��� ����������������������һ���µ�url��ַ���൱��ֱ���ٵ�ַ����������һ�飬��粻��ֱ�ӷ���WEB-INF����Ķ���
			//request.getRequestDispatcher("/WEB-INF/jsp/board.jsp").forward(request, response);//ת��
			return ;
		}
		
		request.setAttribute("message", "�û������������!");
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
