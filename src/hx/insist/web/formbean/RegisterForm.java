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



	/* username����λ��  ����6-8λ��ĸ
	 * password����λ��  ����6-8λ��ĸ
	 * password2����λ�գ��Ҳ������һ����ͬ
	 * email����Ϊ��  ��ʽ��ȷ
	 * nickname����Ϊ�� ����
	 * ���ղ���Ϊ�� �Ҹ�ʽ������ȷ
	 * checkcode����Ϊ���ұ�����ȷ
	 * 
	 * �հ���Ч
	 */
	public boolean validate1() {
		boolean isOK = true;
		
		if(username==null || username.trim().equals("")) {
			isOK = false;
			errors.put("username", "�˺Ų���Ϊ�գ�");
		}else {
			if(!this.username.matches("\\d{6,8}")) {
				isOK = false;
				errors.put("username", "�˺ű���Ϊ6-8λ���֣�");
			}
		}
		
		if(password==null || password.trim().equals("")) {
			isOK = false;
			errors.put("password", "���벻��Ϊ�գ�");
		}else {
			if(!this.password.matches("[A-Za-z0-9]{6,8}")) {
				isOK = false;
				errors.put("password", "�������Ϊ6-8λ���ֻ���ĸ������ϣ�");
			}
		}
		
		if(password2==null || password2.trim().equals("")) {
			isOK = false;
			errors.put("password2", "ȷ�����벻��Ϊ�գ�");
		}else {
			if(!password2.equals(password)) {
				isOK = false;
				errors.put("password2", "�����������벻һ�£�");
			}
		}
		
		if(email==null || email.trim().equals("")) {
			isOK = false;
			errors.put("email", "���䲻��Ϊ�գ�");
		}else {
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")) {
				isOK = false;
				errors.put("email", "�����ʽ����ȷ��");
			}
		}
		
		if(birthday==null || birthday.trim().equals("")) {
			isOK = false;
			errors.put("birthday", "�������ڲ���Ϊ�գ�");
		}else {
			try {
				DateLocaleConverter dlc = new DateLocaleConverter();
				dlc.convert(birthday,"yyyy-MM-dd");
			}catch(Exception e) {
				isOK = false;
				errors.put("birthday", "�������ڸ�ʽ����ȷ��");
			}
		}
		
		if(nickname==null || nickname.trim().equals("")) {
			isOK = false;
			errors.put("nickname", "�ǳƲ���Ϊ�գ�");
		}else {
			if(!this.nickname.matches("[\u4e00-\u9fa5]+")) {
				isOK = false;
				errors.put("nickname", "�ǳƱ����Ǻ��֣�");
			}
		}
		
		if(checkcode==null || checkcode.trim().equals("")) {
			isOK = false;
			errors.put("checkcode", "��֤�벻��Ϊ�գ�");
		}/*else {
			if(!checkcode.equals(checkcode2)) {
				isOK = false;
				errors.put("checkcode", "��֤�����벻��ȷ:" + checkcode + "," + checkcode2);
			}
		}*/
		
		return isOK;
	}
}
