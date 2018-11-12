<%--
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.hx.insist.com" prefix="insist" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>

</head>
<body>

	昵称:${user.nickname }<br/>
	用户名:${user.username }<br/>
	发表的帖子:<br/>
	<table border="1">
			<tr>
				<th>帖子</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
			<c:forEach var="matter" items="${user_Matter}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/BoardMatterServlet?matter_id=${matter.matter_id} " >${matter.matter_text }</a></td>
					<td><insist:dateFO date="${matter.matter_date }"/></td>
					<td><a href="${pageContext.request.contextPath}/DeleteMatterServlet?matter_id=${matter.matter_id} " >删 除</a></td>
				</tr>
			</c:forEach>
	</table>
	<br/>
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
<title>个人信息</title>
  <style>
      body{
		        background-image:url('${pageContext.request.contextPath}/img/7.png');
		    	background-repeat: no-repeat;
				background-size:cover ;
				font-size:18px;
				font-family: "微软雅黑";    
		   }
     
       a{text-decoration: none;}
  </style>
  
<script type="text/javascript">
    	function deleteitem(matter_id){
	    	var b=window.confirm("真的删除吗?");
	    	if(b){
	    		window.location="${pageContext.request.contextPath }/DeleteMatterServlet?matter_id="+matter_id;
	    	} 
    	}
</script>

</head>
<body>
     <table>
         <tr>
          <td>昵称:</td>
          <td>${user.nickname }</td>
         </tr>
         <tr>
          <td>用户名:</td>
          <td>${user.username }</td>
         </tr>
     </table>
	发表的帖子:<br/><br/>
	<table border="1">
			<tr>
				<th>帖子</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
			<c:forEach var="matter" items="${user_Matter}">
				<tr>
				<%--这里的matter_text跳转到之前加载所有帖子页面中的哪个点击详情超链接了 --%>
					<td><a href="${pageContext.request.contextPath}/BoardMatterServlet?matter_id=${matter.matter_id} " >${matter.matter_text }</a></td>
					<td><insist:dateFO date="${matter.matter_date }"/></td>
					<%--<td><a href="javascript:void(0);" target="_blank" onclick="deleteitem(${matter.matter_id});return false;">删 除</a></td> --%>
					<td><a href="javascript:void(0);" onclick="deleteitem('${matter.matter_id}')">删 除</a></td>
				</tr>
			</c:forEach>
	</table>
	<br/>
		<a href="${pageContext.request.contextPath }/BoardUIServlet"><button>返回</button></a>
</body>
</html>