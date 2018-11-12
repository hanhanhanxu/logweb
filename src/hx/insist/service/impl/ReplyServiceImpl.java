package hx.insist.service.impl;

import hx.insist.dao.ReplyDao;
import hx.insist.domain.Reply;
import hx.insist.factory.DaoFactory;

public class ReplyServiceImpl {
	private ReplyDao rdao = DaoFactory.getInstance().createDao(ReplyDao.class);
	
	//��������  ��  �ظ� 			 n==0 ��������  n!=0����ظ�
	public void replies(Reply reply,int n) {
		rdao.add(reply,n);
	}
}
