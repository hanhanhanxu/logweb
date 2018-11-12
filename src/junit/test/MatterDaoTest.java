package junit.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import hx.insist.dao.impl.MatterDaoImpl;
import hx.insist.domain.Matter;
import hx.insist.domain.Reply;

public class MatterDaoTest {
	@Test
	public void testadd() {//已正确
		MatterDaoImpl mdao = new MatterDaoImpl();
		Matter matter = new Matter();
		matter.setMatter_date(new Date());
		matter.setMatter_text("ssss");
		matter.setMatter_content("大ssssssss");
		matter.setUser_username("111111");
		mdao.add(matter);
		
		Matter matter2 = new Matter();
		matter2.setMatter_date(new Date());
		matter2.setMatter_text("国际金融分析");
		matter2.setMatter_content("一起分析国际金融走向");
		matter2.setUser_username("222222");
		mdao.add(matter2);
		
		Matter matter3 = new Matter();
		matter3.setMatter_date(new Date());
		matter3.setMatter_text("生物遗传研究");
		matter3.setMatter_content("共享生物遗传学研究成果");
		matter3.setUser_username("333333");
		mdao.add(matter3);
	}
	
	@Test
	public void testfind() {
		
	}
	
	@Test
	public void testgetAll() {
		MatterDaoImpl mdao = new MatterDaoImpl();
		List<Matter> list = mdao.getAll();
		
		for(Matter matter : list) {
			System.out.println(matter.getMatter_id());
			System.out.println(matter.getMatter_date());//Date类型
			System.out.println(matter.getMatter_text());
			System.out.println(matter.getMatter_content());
			System.out.println(matter.getUser_username());
		}
	}
	
	@Test
	public void testsearch() {
		MatterDaoImpl mdao = new MatterDaoImpl();
		List<Matter> list = mdao.search("111111");
		
		for(Matter matter : list) {
			System.out.println(matter.getMatter_id());
			System.out.println(matter.getMatter_date());//Date类型
			System.out.println(matter.getMatter_text());
			System.out.println(matter.getMatter_content());
			System.out.println(matter.getUser_username());
		}
	}
}
