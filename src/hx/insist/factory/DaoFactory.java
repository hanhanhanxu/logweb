package hx.insist.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	//单例设计  new对象时加载配置文件
	private Properties daoConfig = new Properties();
	
	private DaoFactory() {//构造函数
		InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
		try {
			daoConfig.load(in);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	private static DaoFactory instance = new DaoFactory();
	public static DaoFactory getInstance() {
		return instance;
	}
	
	
	//							UserDao.class
	//							给接口的名称
	public <T> T createDao(Class<T> clazz) {
		String name = clazz.getSimpleName();
		String className = daoConfig.getProperty(name);
		try {
			T dao = (T) Class.forName(className).newInstance();
			return dao;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
