package hx.insist.domain;

import java.util.Date;

public class Reply {
	private int matter_id;		//���  �������������ı����id
	private int reply_id;		//����  �������۵�id
	private Date reply_date;
	private String reply_content;	//		��������
	private String send_username;	//���  �����ߵ�id
	private int receive_reply_id;//���  �������������۵����۵�id
	public int getMatter_id() {
		return matter_id;
	}
	public void setMatter_id(int matter_id) {
		this.matter_id = matter_id;
	}
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getSend_username() {
		return send_username;
	}
	public void setSend_username(String send_username) {
		this.send_username = send_username;
	}
	public int getReceive_reply_id() {
		return receive_reply_id;
	}
	public void setReceive_reply_id(int receive_reply_id) {
		this.receive_reply_id = receive_reply_id;
	}
}
