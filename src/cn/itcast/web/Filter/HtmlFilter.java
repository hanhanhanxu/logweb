package cn.itcast.web.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class HtmlFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
	
		chain.doFilter(new Myrequest(request), response);
		//chain.doFilter(request, response);
	}
	
	class Myrequest extends HttpServletRequestWrapper{//sun公司写好的request包装类
		private HttpServletRequest request;
		public Myrequest(HttpServletRequest request) {
			super(request);
			this.request = request;
		}
		
		@Override
		public String getParameter(String name) {//增强(重写)这个getParameter方法
			String value = this.request.getParameter(name);			
			return filter(value);			
		}

		//E:\apache-tomcat-7.0.82-windows-x64\apache-tomcat-7.0.82\webapps\examples\WEB-INF\classes\chat\ChatServlet.java
		public  String filter(String message) {//转义HTML页面

	        if (message == null)
	            return (null);

	        char content[] = new char[message.length()];
	        message.getChars(0, message.length(), content, 0);
	        StringBuffer result = new StringBuffer(content.length + 50);
	        for (int i = 0; i < content.length; i++) {
	            switch (content[i]) {
	            case '<':
	                result.append("&lt;");
	                break;
	            case '>':
	                result.append("&gt;");
	                break;
	            case '&':
	                result.append("&amp;");
	                break;
	            case '"':
	                result.append("&quot;");
	                break;
	            default:
	                result.append(content[i]);
	            }
	        }
	        return (result.toString());
	    }
		
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
