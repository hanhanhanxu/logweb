<%--
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.hx.insist.com" prefix="insist" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帖子详情信息</title>
</head>
<body>
		
		帖子标题:${matter.matter_text }<br/><br/>
		发帖人:${matter_user.nickname }&nbsp;&nbsp;&nbsp;&nbsp;用户名:${matter_user.username }
		<br/>
		<br/>
		发帖时间:<insist:dateFO date="${matter.matter_date }"/>
		<br/>
		<br/>
		详情:<br/>
		${matter.matter_content }
		<br/>
		<br/>
		发表评论:<br/>																<%--帖子id       发帖人信息 --%>
		<%--
		<form action="${pageContext.request.contextPath }/AddcontentServlet?matter_id=${matter.matter_id }&matter_user_username=${user.username}" method="post">
			<textarea name="matter_content" rows="12" cols="35" style="width: 700px;height: 120px;"></textarea>
			<input type="submit" name="submit" value="提 交"/><br/>
		</form>
		<br/>
		<br/>
		吧友评论	:
		<table border="1">
			<tr>
				<th>用户名</th>
				<th>评论id</th>
				<th>评论/回复</th>
				<th>操作</th>
			</tr>
		<c:forEach var="reply" items="${replies }">
			<tr>
				<td>${reply.send_username }</td>
				<td>${reply.reply_id }</td>
				<td>
					<c:if test="${reply.receive_reply_id==0}">评论:${reply.reply_content }</c:if>
					<c:if test="${reply.receive_reply_id!=0}">回复 ${reply.receive_reply_id } :${reply.reply_content }</c:if>
				</td>
				<td>
					<form action="${pageContext.request.contextPath }/AddReplyServlet?matter_id=${matter.matter_id}&receive_reply_id=${reply.reply_id}" method="post">
						<input type="text" name="reply_content" >
						<input type="submit" name="submit" value="回 复">
					</form>
				</td>
			</tr>
		</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath }/BoardUIServlet">返回</a>
</body>
</html>

--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.hx.insist.com" prefix="insist" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帖子详情信息</title>

<style>
     body{
         background-image:url('${pageContext.request.contextPath }/img/10.jpg');
         background-repeat:no-repeat;
         background-size:cover;
         color:#4B0082;
      }
      table,textarea{
         font-size:18px;
         border:2px solid #7B68EE;
      }
</style>

</head>
<body>
		<table>
		<tbody>
		    <tr>
		        <td>帖子标题:</td>
		        <td>${matter.matter_text }</td>
		    </tr>
		    <tr>
		         <td>发帖人:</td>
		         <td>${matter_user.nickname }</td>
		    </tr>
		    <tr>
		        <td>用户名:</td>
		        <td>${matter_user.username }</td>
		    </tr>
		    <tr>
		       <td>发帖时间:</td>
		       <td><insist:dateFO date="${matter.matter_date }"/></td>
		    </tr>
		    </tbody>
		</table>
		</br>
		<span>详情:</span><br/>
		<textarea rows="12" cols="40" readonly="value">${matter.matter_content }</textarea>
		<br/>
		<br/>
		<span>发表评论:</span><br/>																<%--帖子id       发帖人信息 --%>
		<form action="${pageContext.request.contextPath }/AddcontentServlet?matter_id=${matter.matter_id }&matter_user_username=${user.username}" method="post">
			<textarea name="matter_content" rows="12" cols="35" style="width: 700px;height: 120px;"></textarea>
			<input type="submit" name="submit" value="提 交"/><br/>
		</form>
		<br/>
		<br/>
		吧友评论	:
		<%--显示评论 , 还未加入显示留言功能 --%>
		<table border="1">
			<tr>
				<th>用户名</th>
				<th>评论id</th>
				<th>评论/回复</th>
				<th>操作</th>
			</tr>
		<c:forEach var="reply" items="${replies }">
			<tr>
				<td>${reply.send_username }</td>
				<td>${reply.reply_id }</td>
				<td>
					<c:if test="${reply.receive_reply_id==0}"><c:out value="评论: ${reply.reply_content }"/></c:if>
					<c:if test="${reply.receive_reply_id!=0}"><c:out value="回复 ${reply.receive_reply_id } :${reply.reply_content }"/></c:if>
				</td>
				<td>
					<form action="${pageContext.request.contextPath }/AddReplyServlet?matter_id=${matter.matter_id}&receive_reply_id=${reply.reply_id}" method="post">
						<input type="text" name="reply_content" >
						<input type="submit" name="submit" value="回 复">
					</form>
				</td>
			</tr>
		</c:forEach>
		</table>
			
			
			
		<a href="${pageContext.request.contextPath }/BoardUIServlet">返回</a>
</body>
</html>