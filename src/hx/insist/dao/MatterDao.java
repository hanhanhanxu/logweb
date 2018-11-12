package hx.insist.dao;

import java.util.List;

import hx.insist.domain.Matter;
//操作标题Matter的Dao
public interface MatterDao {
	//增加标题
	boolean add(Matter matter);
	
	//删除标题  根据标题id
	boolean delete(int matter_id);
	
	//根据matter_id得到这个Matter的信息
	Matter getmatter(int matter_id);
	
	//得到所有标题
	List<Matter> getAll();
	
	//查找标题 根据user_id找出某用户创建的所有标题
	List<Matter> search(String user_id);
	
	
	Matter find();
}
