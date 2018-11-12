1:搭建开发环境
	1.1导开发包
	dom4j开发包
	jstl开发包
	beanUtils开发包
	log4j开发包
	
	1.2创建组织程序的包
	
	hx.insist.dao			(数据访问层接口)
	hx.insist.dao.impl		(数据访问层实现) UserDaoImpl.java  Dao负责与数据库进行交互，获取数据
	hx.insist.service		(业务逻辑层接口)	
	hx.insist.service.impl	(业务逻辑层实现service)
	hx.insist.domain		(javabean)		User.java
	hx.insist.web.controller  (处理请求的servlet)
	hx.insist.web.UI		(给用户提供界面)
	hx.insist.utils
	junit.test
	
	WEB-INF/jsp文件
	1.3创建代表数据库的xml文件
	
	
	注册，登陆
	登陆成功后显示所有已注册用户列表，可以依据username查找某用户
	
	
	///////////////////
	用户
	create database logweb;
	
	CREATE DATABASE IF NOT EXISTS logweb default character set utf8 COLLATE utf8_general_ci;
	
	create database logweb;
	use logweb;
	
	create table Users(
		id varchar(100),
		username varchar(40) NOT NULL primary key,
		password varchar(40) NOT NULL,
		email varchar(60) NOT NULL,
		birthday date NOT NULL,
		nickname varchar(40) NOT NULL
	);
	
	create table Matter(
		matter_id int NOT NULL auto_increment primary key,
		matter_date varchar(40) NOT NULL,
		matter_text varchar(40) NOT NULL,
		user_username varchar(40) NOT NULL,
		matter_content text NOT NULL,
		foreign key(user_username) references Users(username)
	);
	
	create table Reply(
		matter_id int NOT NULL,
		reply_id int NOT NULL auto_increment primary key,
		reply_date varchar(40) NOT NULL,
		reply_content text NOT NULL,
		send_username varchar(40) NOT NULL,
		receive_reply_id int,
		foreign key(matter_id) references Matter(matter_id) on delete cascade,
		foreign key(send_username) references Users(username),
		foreign key(receive_reply_id) references Reply(reply_id) on delete cascade
	);
	
	
	
	
	
	
	
	
	
	
	
	private String id;
	private String username;
	private String password;
	private String email;
	private Date birthday;
	private String nickname;
	
	
	
	///////////////////
	帖子
	
	private int matter_id;			//标题id   主键   自增
	private Date matter_date;			//日期   精确到秒    使用java.util.Date  所以存进数据库存String类型，存之前转换
	private String matter_text;			//标题内容
	private String user_username;		//发表标题的用户username   外键 
	private String matter_content;		//内容详情
	
	create table Matter(
		matter_id int NOT NULL auto_increment primary key,
		matter_date varchar(40) NOT NULL,
		matter_text varchar(40) NOT NULL,
		user_username varchar(40) NOT NULL,
		matter_content text NOT NULL,
		foreign key(user_username) references Users(username)
	);
	
	insert into Matter(matter_date,matter_text,user_username,matter_content) values('1988-11-23 00:00:00','javaweb讨论','111111','大家一起来讨论javaweb知识啊');
	insert into Matter(matter_date,matter_text,user_username,matter_content) values('1987-11-23 00:00:00','国际金融讨论','222222','大家一起来讨论国际金融危机啊');
	insert into Matter(matter_date,matter_text,user_username,matter_content) values('1987-11-23 00:00:00','qqqqqq','222222','qqqqqqqqqqq');
	insert into Matter(matter_date,matter_text,user_username,matter_content) values('1987-11-23 00:00:00','wwwww','222222','wwwwwwwwwwwwwwww');
	insert into Matter(matter_date,matter_text,user_username,matter_content) values('1987-11-23 00:00:00','eeeeee','222222','eeeeeeeeeeeeeeeeeee');
	
	delete from Matter where id = 3;
	
	insert into Matter(matter_date,matter_text,user_username,matter_content) values('1987-11-23 00:00:00','rrrrrr','333333','rrrrrrrrrr');
	
	
	
	///////////////////
	评论或回复
	
	private int matter_id;		//外键  这条评论所属的标题的id
	private int reply_id;		//主键  这条评论的id
	private Date reply_date;
	private String reply_content;	//		评论内容
	private String send_username;	//外键  评论者的id
	private int receive_reply_id;//外键  这条评论所评论的评论的id
	
	
	matter_id相同且receive_reply_id为空的信息为同一帖子下所有评论内容
	
	
	create table Reply(
		matter_id int NOT NULL,
		reply_id int NOT NULL auto_increment primary key,
		reply_date varchar(40) NOT NULL,
		reply_content text NOT NULL,
		send_username varchar(40) NOT NULL,
		receive_reply_id int,
		foreign key(matter_id) references Matter(matter_id) on delete cascade,
		foreign key(send_username) references Users(username),
		foreign key(receive_reply_id) references Reply(reply_id) on delete cascade
	);
	
	insert into Reply(matter_id,reply_date,reply_content,send_username) values(1,'1987-11-23 00:00:00','aaaaa','111111');
	
	
	create table aaa(id int NOT NULL auto_increment primary key,name varchar(10));
	insert into aaa (name) values("qq");
	insert into aaa (name) values("ww");
	insert into aaa (name) values("ee");
	insert into aaa (name) values("rr");
	insert into aaa (name) values("tt");
	delete from aaa where id = 2;
	select * from aaa;
	insert into aaa (name) values("yy");
	
	
	
	
	
	