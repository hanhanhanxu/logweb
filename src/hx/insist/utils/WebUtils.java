package hx.insist.utils;

import java.lang.reflect.InvocationTargetException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
//把request中的数据 to 到bean中  给服务器端去做进一步检查
public class WebUtils {											//RegisterForm.class
	public static <T> T request2Bean(HttpServletRequest request,Class<T> beanClass) {//反射
		try {
			//1.创建要封装数据的bean
			T bean= beanClass.newInstance();
			
			//2.把request中的数据整到bean中
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				
				//System.out.println(name + "=" + value);
				BeanUtils.setProperty(bean, name, value);//设置不进去checkcode2
			}
			return bean;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static <T> T request2bean2(HttpServletRequest request,Class<T> beanClass) {
		return null;
	}
	/*
	formbean:
	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	private String nickname;
	private String checkcode;
	private String Tcheckcode;
	
	user:
	private String id;
	private String username;
	private String password;
	private String email;
	private Date birthday;
	private String nickname;
	 */
	public static void copyBean(Object src,Object dest) {
		ConvertUtils.register(new DateLocaleConverter(Locale.CHINESE), Date.class);//不知道这个Locale.CHINESE什么用
		//使用CovertUtils注册创建一个日期格式转换器
		/*ConvertUtils.register(new Converter() {
			@Override
			public Object convert(Class type,Object value) {
				if(value==null) {
					return null;
				}
				String str = String.valueOf(value);
				//String str = (String)value;
				if(str.trim().equals("")) {
					return  null;
				}
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				}catch(ParseException e){
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		}, Date.class);*/
		
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	public static String generateID() {
		return UUID.randomUUID().toString();
	}
	
}
