package hx.insist.service.impl;

import java.util.List;

import hx.insist.dao.MatterDao;
import hx.insist.domain.Matter;
import hx.insist.factory.DaoFactory;

public class MatterServiceImpl {
	private MatterDao mdao = DaoFactory.getInstance().createDao(MatterDao.class);
	
	//得到所有帖子，在页面显示
	public List<Matter> getAllMatter(){
		return mdao.getAll();
	}
	
	//发表帖子
	public void post(Matter matter) {
		mdao.add(matter);
	}
	
}
