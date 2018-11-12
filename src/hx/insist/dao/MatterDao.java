package hx.insist.dao;

import java.util.List;

import hx.insist.domain.Matter;
//��������Matter��Dao
public interface MatterDao {
	//���ӱ���
	boolean add(Matter matter);
	
	//ɾ������  ���ݱ���id
	boolean delete(int matter_id);
	
	//����matter_id�õ����Matter����Ϣ
	Matter getmatter(int matter_id);
	
	//�õ����б���
	List<Matter> getAll();
	
	//���ұ��� ����user_id�ҳ�ĳ�û����������б���
	List<Matter> search(String user_id);
	
	
	Matter find();
}
