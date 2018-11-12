package junit.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import hx.insist.dao.impl.MatterDaoImpl;
import hx.insist.domain.Matter;
import hx.insist.domain.Reply;

public class MatterDaoTest {
	@Test
	public void testadd() {//����ȷ
		MatterDaoImpl mdao = new MatterDaoImpl();
		Matter matter = new Matter();
		matter.setMatter_date(new Date());
		matter.setMatter_text("ssss");
		matter.setMatter_content("��ssssssss");
		matter.setUser_username("111111");
		mdao.add(matter);
		
		Matter matter2 = new Matter();
		matter2.setMatter_date(new Date());
		matter2.setMatter_text("���ʽ��ڷ���");
		matter2.setMatter_content("һ��������ʽ�������");
		matter2.setUser_username("222222");
		mdao.add(matter2);
		
		Matter matter3 = new Matter();
		matter3.setMatter_date(new Date());
		matter3.setMatter_text("�����Ŵ��о�");
		matter3.setMatter_content("���������Ŵ�ѧ�о��ɹ�");
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
			System.out.println(matter.getMatter_date());//Date����
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
			System.out.println(matter.getMatter_date());//Date����
			System.out.println(matter.getMatter_text());
			System.out.println(matter.getMatter_content());
			System.out.println(matter.getUser_username());
		}
	}
}
