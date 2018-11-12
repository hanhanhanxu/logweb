package hx.insist.service.impl;

import hx.insist.dao.ReplyDao;
import hx.insist.domain.Reply;
import hx.insist.factory.DaoFactory;

public class ReplyServiceImpl {
	private ReplyDao rdao = DaoFactory.getInstance().createDao(ReplyDao.class);
	
	//发表评论  或  回复 			 n==0 发表评论  n!=0发表回复
	public void replies(Reply reply,int n) {
		rdao.add(reply,n);
	}
}
