package hx.insist.domain;

import java.util.Date;

public class Matter {
	private int matter_id;			//标题id   主键   自增
	private Date matter_date;			//日期   精确到秒    使用java.util.Date  所以存进数据库存String类型，存之前转换
	private String matter_text;			//标题内容
	private String user_username;		//发表标题的用户username   外键 
	private String matter_content;		//内容详情
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
