package hx.insist.web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Ϊ�û��ṩע��ҳ��
@WebServlet("/RegisterUIServlet")
public class RegisterUIServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public RegisterUIServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ת��ע��jsp
		request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
