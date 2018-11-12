package hx.insist.dao;

import java.util.List;

import hx.insist.domain.Reply;

//操作留言Reply的Dao
public interface ReplyDao {
	//增加一个留言
	boolean add(Reply reply,int n);//n==0 发表评论  n!=0发表回复
	
	//查找某条帖子下的所有评论
	List<Reply> searchAllComment(int matter_id);
	
	//查找此条reply消息被谁回复了，返回回复的消息对象
	List<Reply> searchAllReply(Reply reply);
	
	//删除一个留言  删除后，所有回复留言都将被删除
	boolean delete(int reply_id);
	
	//朝找全部评论留言
	public List<Reply> searchAll(int matter_id);
	
	Reply find();
	
	//通过id返回对象 
	Reply getReply(int reply_id);
}