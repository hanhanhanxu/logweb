package hx.insist.web.Tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DateFormatOutput extends SimpleTagSupport {
	private Date date;
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public void doTag() throws IOException {
		if(date!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sdate = sdf.format(date);
			JspWriter out = getJspContext().getOut();
	        out.println( sdate );
		}
	}
}
