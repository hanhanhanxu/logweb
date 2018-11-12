<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册界面</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/register.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/ShowCalendar.js"></script>
	
	<script type="text/javascript">
	function changeImage(img){
		img.src = img.src + "?" + new Date().getTime();
	}
	</script>
	
</head>
<body>
	注册用户
	
	<form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
	
		登陆账号:<input type="text" name="username" value="${form.username}">(账号由6-8位数字组成)
		<span class = "message">${form.errors.username}</span>
		<br/>
		登陆密码:<input type="password" name="password" value="${form.password}">(密码由6-8位数字或字母组成)
		<span class = "message">${form.errors.password}</span>
		<br/>
		确认密码:<input type="password" name="password2" value="${form.password2}">
		<span class = "message">${form.errors.password2}</span>
		<br/>
		电子邮箱:<input type="text" name="email" value="${form.email}">
		<span class = "message">${form.errors.email}</span>
		<br/>
		出生日期:<input type="text" name="birthday" value="${form.birthday}" id="birthday" title="点击选择" onClick="showCalendar(this.id)">
		<span class = "message">${form.errors.birthday}</span>
		<br/>
		您的昵称:<input type="text" name="nickname" value="${form.nickname}">
		<span class = "message">${form.errors.nickname}</span>
		<br/>
		图片认证:<input type ="text" name="checkcode">
		<img src="${pageContext.request.contextPath}/IdentifyCode" onclick="changeImage(this)" title="换一张" style="cursor:pointer">
		(请输入图片中的数字)<!-- 图片在 hx.insist.web.others的IdentifyCode的servlet中生成-->
		<span class = "message">${form.errors.checkcode}</span><br/>
		
		<div id="formsubmit">
			<span><input class="btn" type="reset" name="reset" value="重 置"></span>
			&nbsp;&nbsp;
			<span><input class="btn" type="submit" name="submit" value="注 册"></span>
		</div>
		
	</form>
</body>
</html>
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册界面</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/ShowCalendar.js"></script>
	<script type="text/javascript">
	function changeImage(img){
		img.src = img.src + "?" + new Date().getTime();
	}
	</script>
	
	<style type="text/css">
	 body{
			margin: 0;
			padding: 0;
			font-size: 16px;
			background: windowframe;
			overflow: hidden;
			text-align:center;
		 }
		 
	table{
	        border:1px soild black;
			width:600px;
			height:190px;     		
	  } 
	  
	  h1{
		    font-family:"Times New Roman",serif;
		    font-size:30px;
		    color:#ff00bf;
		    margin-top:20px;
	   }
	   td{
		    font-size:16px;
		    color:#660066;
	   }
	   .input{
	       float:left;
	   }
	  .input:focus{ background-color:#660066;color:white;}
	</style>
</head>
<body style="background-image: url('${pageContext.request.contextPath }/img/register.jpg');">
   <h1>用户注册</h1>
   
	<form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
	   <table border="1" align="center">
		<tbody>		
		    <tr>
				<td>&nbsp;&nbsp;登&nbsp;陆&nbsp;账&nbsp;号:&nbsp;</td>
				<td><input type="text" class="input" name="username" value="${form.username}">(账号由6-8位数字组成)</td>
				<td><span class = "message">${form.errors.username}</span></td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;登&nbsp;陆&nbsp;密&nbsp;码:&nbsp;</td>
				<td><input type="password" class="input" name="password" value="${form.password}">(密码由6-8位数字或字母组成)</td>
				<td><span class = "message">${form.errors.password}</span></td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;确&nbsp;认&nbsp;密&nbsp;码:&nbsp;</td>
				<td><input type="password" class="input" name="password2" value="${form.password2}"></td>
				<td><span class = "message">${form.errors.password2}</span></td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;电&nbsp;子&nbsp;邮&nbsp;箱:&nbsp;</td>
				<td><input type="text" class="input" name="email" value="${form.email}"></td>
				<td><span class = "message">${form.errors.email}</span></td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;出&nbsp;生&nbsp;日&nbsp;期:&nbsp;</td>
				<td><input type="text" class="input" name="birthday" value="${form.birthday}" id="birthday" title="点击选择" onClick="showCalendar(this.id)"></td>
				<td><span class = "message">${form.errors.birthday}</span></td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;您&nbsp;的&nbsp;昵&nbsp;称:&nbsp;</td>
				<td><input type="text" class="input" name="nickname" value="${form.nickname}"></td>
				<td><span class = "message">${form.errors.nickname}</span></td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;图&nbsp;片&nbsp;认&nbsp;证:&nbsp;&nbsp;</td>
				<td><input type ="text" class="input" name="checkcode"></td>
				<td>
				<img src="${pageContext.request.contextPath}/IdentifyCode" onclick="changeImage(this)" title="换一张" style="cursor:pointer">
				(请输入图片中的数字)<!-- 图片在 hx.insist.web.others的IdentifyCode的servlet中生成-->
				</td>
				<td><span class = "message">${form.errors.checkcode}</span><br/></td>
			</tr>
			<tr>
			<div id="formsubmit">
				<td><span><input class="btn" type="reset" name="reset" value="重 置"></span></td>
				&nbsp;&nbsp;
				<td><span><input class="btn" type="submit" name="submit" value="注 册"></span></td>
			</div>
			</tr>
	     </tbody>
	   </table>
	</form>
	
	
</body>
</html>