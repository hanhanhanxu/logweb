package hx.insist.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hx.insist.domain.Matter;
import hx.insist.domain.User;
import hx.insist.service.impl.MatterServiceImpl;
import hx.insist.utils.WebUtils;
import hx.insist.web.formbean.PostForm;


@WebServlet("/BoardPostServlet")
public class BoardPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardPostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//发帖提交到这，先封装到bean里   检查数据合法性
		PostForm form = WebUtils.request2Bean(request, PostForm.class);
		form.setMatter_date(new Date());//设置Date
		User user = (User) request.getSession().getAttribute("user");
		form.setUser_username(user.getUsername());
		MatterServiceImpl service = new MatterServiceImpl();
		
		//拷贝bean
		Matter matter = new Matter();
		try {
			BeanUtils.copyProperties(matter, form);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//发帖  (设置id)
		service.post(matter);
		response.sendRedirect(request.getContextPath() + "/BoardUIServlet");
		//request.getRequestDispatcher("/BoardUIServlet").forward(request, response);//转发
		return ;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
