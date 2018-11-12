<%--
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.hx.insist.com" prefix="insist" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发帖人信息</title>
</head>
<body>

	昵称:${watch_user.nickname }<br/>
	用户名:${watch_user.username }<br/>
	发表的帖子:<br/>
	
	<table border="1">
		<tr>
			<th>帖子</th>
			<th>时间</th>
		</tr>
	<c:forEach var="matter" items="${watch_user_Matter }">
		<tr>
			<td>${matter.matter_text }</td>
			<td><insist:dateFO date="${matter.matter_date }"/></td>
		</tr>
	</c:forEach>
	</table>
	
	
	<a href="${pageContext.request.contextPath }/BoardUIServlet">返回</a>
	
</body>
</html>
 --%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.hx.insist.com" prefix="insist" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发帖人信息</title>
<style>
      body{
		        background-image:url('${pageContext.request.contextPath}/img/1.jpg');
		    	background-repeat: no-repeat;
				background-size:cover ;
				font-size:18px;
				font-family: "微软雅黑";    
		   }
</style>
</head>
<body>
     <table>
         <tr>
          <td>昵称:</td>
          <td>${watch_user.nickname }</td>
         </tr>
         <tr>
          <td>用户名:</td>
          <td>${watch_user.username }</td>
         </tr>
     </table>
	<span>发表的帖子:</span><br/><br/>
	<table border="1">
		<tr>
			<th>帖子</th>
			<th>时间</th>
		</tr>
	<c:forEach var="matter" items="${watch_user_Matter }">
		<tr>
			<td>${matter.matter_text }</td>
			<td><insist:dateFO date="${matter.matter_date }"/></td>
		</tr>
	</c:forEach>
	</table>
	
	<br/>
	<a href="${pageContext.request.contextPath }/BoardUIServlet"><button>返回</button></a>
	
</body>
</html>