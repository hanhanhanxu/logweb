package hx.insist.domain;

import java.util.Date;

public class Matter {
	private int matter_id;			//����id   ����   ����
	private Date matter_date;			//����   ��ȷ����    ʹ��java.util.Date  ���Դ�����ݿ��String���ͣ���֮ǰת��
	private String matter_text;			//��������
	private String user_username;		//���������û�username   ��� 
	private String matter_content;		//��������
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
}
