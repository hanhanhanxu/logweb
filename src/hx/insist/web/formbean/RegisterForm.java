package hx.insist.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {
	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	private String nickname;
	private String checkcode;
	private String checkcode2;
	
	private Map<String, String> errors = new HashMap<String, String>();
	

	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPassword2() {
		return password2;
	}



	public void setPassword2(String password2) {
		this.password2 = password2;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getBirthday() {
		return birthday;
	}



	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getCheckcode() {
		return checkcode;
	}



	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}





	public String getCheckcode2() {
		return checkcode2;
	}



	public void setCheckcode2(String checkcode2) {
		this.checkcode2 = checkcode2;
	}



	public Map<String, String> getErrors() {
		return errors;
	}



	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}



	/* username不能位空  且是6-8位字母
	 * password不能位空  且是6-8位字母
	 * password2不能位空，且不能与第一个不同
	 * email不能为空  格式正确
	 * nickname不能为空 汉字
	 * 生日不能为空 且格式必须正确
	 * checkcode不能为空且必须正确
	 * 
	 * 空白无效
	 */
	public boolean validate1() {
		boolean isOK = true;
		
		if(username==null || username.trim().equals("")) {
			isOK = false;
			errors.put("username", "账号不能为空！");
		}else {
			if(!this.username.matches("\\d{6,8}")) {
				isOK = false;
				errors.put("username", "账号必须为6-8位数字！");
			}
		}
		
		if(password==null || password.trim().equals("")) {
			isOK = false;
			errors.put("password", "密码不能为空！");
		}else {
			if(!this.password.matches("[A-Za-z0-9]{6,8}")) {
				isOK = false;
				errors.put("password", "密码必须为6-8位数字或字母或其组合！");
			}
		}
		
		if(password2==null || password2.trim().equals("")) {
			isOK = false;
			errors.put("password2", "确认密码不能为空！");
		}else {
			if(!password2.equals(password)) {
				isOK = false;
				errors.put("password2", "两次输入密码不一致！");
			}
		}
		
		if(email==null || email.trim().equals("")) {
			isOK = false;
			errors.put("email", "邮箱不能为空！");
		}else {
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")) {
				isOK = false;
				errors.put("email", "邮箱格式不正确！");
			}
		}
		
		if(birthday==null || birthday.trim().equals("")) {
			isOK = false;
			errors.put("birthday", "出生日期不能为空！");
		}else {
			try {
				DateLocaleConverter dlc = new DateLocaleConverter();
				dlc.convert(birthday,"yyyy-MM-dd");
			}catch(Exception e) {
				isOK = false;
				errors.put("birthday", "出生日期格式不正确！");
			}
		}
		
		if(nickname==null || nickname.trim().equals("")) {
			isOK = false;
			errors.put("nickname", "昵称不能为空！");
		}else {
			if(!this.nickname.matches("[\u4e00-\u9fa5]+")) {
				isOK = false;
				errors.put("nickname", "昵称必须是汉字！");
			}
		}
		
		if(checkcode==null || checkcode.trim().equals("")) {
			isOK = false;
			errors.put("checkcode", "验证码不能为空！");
		}/*else {
			if(!checkcode.equals(checkcode2)) {
				isOK = false;
				errors.put("checkcode", "验证码输入不正确:" + checkcode + "," + checkcode2);
			}
		}*/
		
		return isOK;
	}
}
