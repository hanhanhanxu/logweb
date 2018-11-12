package hx.insist.web.Tag;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Substring extends SimpleTagSupport {
	private String str;

	public void setStr(String str) {
		this.str = str;
	}
	@Override
	public void doTag() throws IOException {
		if(str.length()>10){
			str = str.substring(0, 10) + ".......";
		}
		JspWriter out = getJspContext().getOut();
        out.println( str );
	}
}
