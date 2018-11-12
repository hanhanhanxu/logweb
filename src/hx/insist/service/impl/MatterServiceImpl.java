package hx.insist.service.impl;

import java.util.List;

import hx.insist.dao.MatterDao;
import hx.insist.domain.Matter;
import hx.insist.factory.DaoFactory;

public class MatterServiceImpl {
	private MatterDao mdao = DaoFactory.getInstance().createDao(MatterDao.class);
	
	//�õ��������ӣ���ҳ����ʾ
	public List<Matter> getAllMatter(){
		return mdao.getAll();
	}
	
	//��������
	public void post(Matter matter) {
		mdao.add(matter);
	}
	
}
