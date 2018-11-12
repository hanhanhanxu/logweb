package hx.insist.web.formbean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import hx.insist.dao.MatterDao;
import hx.insist.dao.impl.MatterDaoImpl;
import hx.insist.service.impl.BusinessServiceImpl;

public class PostForm {
	private int matter_id;			//����id   ���� 
	private Date matter_date;			//****��Ϊ���Լ����õģ����Կ���ֱ����ΪDate��
	private String matter_text;			//��������
	private String user_username;		//���������û�username   ��� 
	private String matter_content;		//��������
	private Map error = new HashMap();
	
	


	public int getMatter_id() {
		return matter_id;
	}


	public void setMatter_id(int matter_id) {
		this.matter_id = matter_id;
	}


	public Date getMatter_date() {
		return matter_date;
	}


	public void setMatter_date(Date matter_date) {
		this.matter_date = matter_date;
	}


	public String getMatter_text() {
		return matter_text;
	}


	public void setMatter_text(String matter_text) {
		this.matter_text = matter_text;
	}


	public String getUser_username() {
		return user_username;
	}


	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}


	public String getMatter_content() {
		return matter_content;
	}


	public void setMatter_content(String matter_content) {
		this.matter_content = matter_content;
	}


	public Map getError() {
		return error;
	}


	public void setError(Map error) {
		this.error = error;
	}


	public boolean validate1() {
		boolean isOK = true;
		
		if(matter_text==null || "".equals(matter_text)) {
			isOK = false;
			error.put("matter_text", "���ⲻ��Ϊ��!");
		}
		
		if(matter_content==null || "".equals(matter_content)) {
			isOK = false;
			error.put("matter_content", "���ⲻ��Ϊ��!");
		}
			
		return isOK;
	}
}
