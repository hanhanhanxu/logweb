<%--
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>留言板</title>
<script type="text/javascript" src="js/jquery1.8.0.min.js"></script>
</head>
<body>
		欢迎您:${user.nickname } 
		<a href="${pageContext.request.contextPath }/PostUIServlet">发帖</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/UserselfServlet">我的空间</a>
		<br/>
		<a href="${pageContext.request.contextPath }/LogoutServlet">注销</a><br/>
		
		<table border="1">
			<tr>
				<th>帖子</th>
				<th>发帖人</th>
			</tr>
			<c:forEach var="matter" items="${Matters}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/BoardMatterServlet?matter_id=${matter.matter_id} " >${matter.matter_text }</a></td>
					<td><a href="${pageContext.request.contextPath}/BoardUserServlet?user_username=${matter.user_username }" >${matter.user_username }</a></td>
				</tr>
			</c:forEach>
		</table>
		
</body>
</html>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>留言板</title>
<script type="text/javascript" src="js/jquery1.8.0.min.js"></script>
  <style> 
      body{
         background-image:url('${pageContext.request.contextPath }/img/12.jpg');
         background-repeat: no-repeat;
         background-size:100%;
      }
      span{
	         font-family: "微软雅黑";
		     font-size: 24px;    
      }
      table{
         margin-left:600px;
         border-color:#8B008B;
      }
  </style>
</head>
<body>
		<span>欢迎您:</span>${user.nickname } 
		<span><a href="${pageContext.request.contextPath }/PostUIServlet">发帖</a></span>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</br></br>
		<span style="margin-left:75px;"><a href="${pageContext.request.contextPath }/UserselfServlet">我的空间</a></span>
		<br/>
		<span style="float:right;margin-top:60px;"><a href="${pageContext.request.contextPath }/LogoutServlet">注销</a><br/></span>
		
		<table border="1">
			<tr>
				<th>帖子</th>
				<th>发帖人</th>
			</tr>
			<c:forEach var="matter" items="${Matters}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/BoardMatterServlet?matter_id=${matter.matter_id} " >${matter.matter_text }</a></td>
					<td><a href="${pageContext.request.contextPath}/BoardUserServlet?user_username=${matter.user_username }" >${matter.user_username }</a></td>
				</tr>
			</c:forEach>
		</table>
		
</body>
</html>