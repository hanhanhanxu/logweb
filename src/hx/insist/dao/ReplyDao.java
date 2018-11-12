package hx.insist.dao;

import java.util.List;

import hx.insist.domain.Reply;

//��������Reply��Dao
public interface ReplyDao {
	//����һ������
	boolean add(Reply reply,int n);//n==0 ��������  n!=0����ظ�
	
	//����ĳ�������µ���������
	List<Reply> searchAllComment(int matter_id);
	
	//���Ҵ���reply��Ϣ��˭�ظ��ˣ����ػظ�����Ϣ����
	List<Reply> searchAllReply(Reply reply);
	
	//ɾ��һ������  ɾ�������лظ����Զ�����ɾ��
	boolean delete(int reply_id);
	
	//����ȫ����������
	public List<Reply> searchAll(int matter_id);
	
	Reply find();
	
	//ͨ��id���ض��� 
	Reply getReply(int reply_id);
}