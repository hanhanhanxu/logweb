package hx.insist.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.portable.OutputStream;

import hx.insist.domain.User;
import hx.insist.exception.UserExistException;
import hx.insist.service.impl.BusinessServiceImpl;
import hx.insist.utils.WebUtils;
import hx.insist.web.formbean.RegisterForm;


//�����û�����    �û���ע�����󣬵õ�ע����Ϣ
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		//1.�Ա��ύ�����ݽ��кϷ���У��
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);//���������˼�룩��һ��form��bean����һ������ �õ�request�ύ�����ݲ���װ��bean��
		boolean b = form.validate1();
		
		String checkcode2 = (String) request.getServletContext().getAttribute("checkcode2");
		boolean a = form.getCheckcode().equals(checkcode2);
		//2.�������ȷ�����ر���ʾ������Ϣ
		if(!b) {
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return ;
		}
		//��֤���Ƿ�������ȷ
		if(!a) {
			form.getErrors().put("checkcode", "��֤�����벻��ȷ!");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return ;
		}
		//3.��ȷ�����service�����û�
		User user = new User();
		WebUtils.copyBean(form, user);//��formbean����userbean��������ͬ����Ϣ������userbean��
		user.setId(WebUtils.generateID());
		
		BusinessServiceImpl  service = new BusinessServiceImpl();
		try {
			service.register(user);
			//6.��service����ɹ�����ת��ȫ����Ϣ��ʾҳ�棬��ʾ�û�ע��ɹ�
			request.setAttribute("message", "��ϲ����ע��ɹ�!����������������ת����ҳ...<meta http-equiv='refresh' content='3;url="+ request.getContextPath() +"/index.jsp'");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return ;
		} catch (UserExistException e) {
			//4.��service�����ɹ���ԭ����username�ظ��������ر�ҳ����ʾ������Ϣ
			form.getErrors().put("username", "ע����˺��Ѵ���!");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return ;//��Ȼ������ȥ�� Ϊʲô��Ҫ���أ�
		}catch(Exception e) {
			//5.��servicec�����ɹ���ԭ�����������⣬����ת���Ѻ���ʾ����ҳ��
			e.printStackTrace();
			request.setAttribute("message", "����������δ֪����!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return ;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
