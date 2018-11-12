1:���������
	1.1��������
	dom4j������
	jstl������
	beanUtils������
	log4j������
	
	1.2������֯����İ�
	
	hx.insist.dao			(���ݷ��ʲ�ӿ�)
	hx.insist.dao.impl		(���ݷ��ʲ�ʵ��) UserDaoImpl.java  Dao���������ݿ���н�������ȡ����
	hx.insist.service		(ҵ���߼���ӿ�)	
	hx.insist.service.impl	(ҵ���߼���ʵ��service)
	hx.insist.domain		(javabean)		User.java
	hx.insist.web.controller  (���������servlet)
	hx.insist.web.UI		(���û��ṩ����)
	hx.insist.utils
	junit.test
	
	WEB-INF/jsp�ļ�
	1.3�����������ݿ��xml�ļ�
	
	
	ע�ᣬ��½
	��½�ɹ�����ʾ������ע���û��б���������username����ĳ�û�
	
	
	///////////////////
	�û�
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
	����
	
	private int matter_id;			//����id   ����   ����
	private Date matter_date;			//����   ��ȷ����    ʹ��java.util.Date  ���Դ�����ݿ��String���ͣ���֮ǰת��
	private String matter_text;			//��������
	private String user_username;		//���������û�username   ��� 
	private String matter_content;		//��������
	
	create table Matter(
		matter_id int NOT NULL auto_increment primary key,
		matter_date varchar(40) NOT NULL,
		matter_text varchar(40) NOT NULL,
		user_username varchar(40) NOT NULL,
		matter_content text NOT NULL,
		foreign key(user_username) references Users(username)
	);
	
	insert into Matter(matter_date,matter_text,user_username,matter_content) values('1988-11-23 00:00:00','javaweb����','111111','���һ��������javaweb֪ʶ��');
	insert into Matter(matter_date,matter_text,user_username,matter_content) values('1987-11-23 00:00:00','���ʽ�������','222222','���һ�������۹��ʽ���Σ����');
	insert into Matter(matter_date,matter_text,user_username,matter_content) values('1987-11-23 00:00:00','qqqqqq','222222','qqqqqqqqqqq');
	insert into Matter(matter_date,matter_text,user_username,matter_content) values('1987-11-23 00:00:00','wwwww','222222','wwwwwwwwwwwwwwww');
	insert into Matter(matter_date,matter_text,user_username,matter_content) values('1987-11-23 00:00:00','eeeeee','222222','eeeeeeeeeeeeeeeeeee');
	
	delete from Matter where id = 3;
	
	insert into Matter(matter_date,matter_text,user_username,matter_content) values('1987-11-23 00:00:00','rrrrrr','333333','rrrrrrrrrr');
	
	
	
	///////////////////
	���ۻ�ظ�
	
	private int matter_id;		//���  �������������ı����id
	private int reply_id;		//����  �������۵�id
	private Date reply_date;
	private String reply_content;	//		��������
	private String send_username;	//���  �����ߵ�id
	private int receive_reply_id;//���  �������������۵����۵�id
	
	
	matter_id��ͬ��receive_reply_idΪ�յ���ϢΪͬһ������������������
	
	
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
	
	
	
	
	
	