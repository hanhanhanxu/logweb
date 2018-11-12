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


//处理用户请求    用户的注册请求，得到注册信息
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		//1.对表单提交的数据进行合法性校验
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);//（面向对象思想）做一个form表单bean，做一个工具 得到request提交的数据并封装到bean中
		boolean b = form.validate1();
		
		String checkcode2 = (String) request.getServletContext().getAttribute("checkcode2");
		boolean a = form.getCheckcode().equals(checkcode2);
		//2.如果不正确则跳回表单提示错误消息
		if(!b) {
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return ;
		}
		//验证码是否输入正确
		if(!a) {
			form.getErrors().put("checkcode", "验证码输入不正确!");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return ;
		}
		//3.正确则调用service增加用户
		User user = new User();
		WebUtils.copyBean(form, user);//把formbean中与userbean变量名相同的信息拷贝到userbean中
		user.setId(WebUtils.generateID());
		
		BusinessServiceImpl  service = new BusinessServiceImpl();
		try {
			service.register(user);
			//6.若service处理成功则跳转到全局消息显示页面，提示用户注册成功
			request.setAttribute("message", "恭喜您，注册成功!浏览器将在三秒后跳转到首页...<meta http-equiv='refresh' content='3;url="+ request.getContextPath() +"/index.jsp'");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return ;
		} catch (UserExistException e) {
			//4.若service处理不成功且原因是username重复，则跳回表单页面提示错误消息
			form.getErrors().put("username", "注册的账号已存在!");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return ;//既然都跳出去了 为什么还要返回？
		}catch(Exception e) {
			//5.若servicec处理不成功且原因是其他问题，则跳转到友好提示错误页面
			e.printStackTrace();
			request.setAttribute("message", "服务器出现未知错误!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return ;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
