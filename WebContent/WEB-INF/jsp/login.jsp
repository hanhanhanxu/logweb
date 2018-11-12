<%--
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
		账号:
		<input type="text" name="username"><br/>
		密码:
		<input type="password" name="password">
		<span class="message" >${message }</span><br/>
		<input type="submit" name="submit" value="登 陆">
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
<title>登陆界面</title>

<style type="text/css">
body
{
      margin: 0;
      padding:0;
      font-family: georgia,serif;
      color:#3a3a3a;
      background-repeat:no-repeat;
}
.clear{clear:both;}
form
{
	width: 406px;
	margin: 180px auto 0;
}
label
{
	width: 115px;
	text-align: right;
	float: left;
	margin: 0 10px 0 0;
	padding: 9px 0 0 0;
	font-size: 16px;
}
input
{
	width: 220px;
	display: block;
	padding: 4px;
	margin: 0 0 10px 0;
	font-size: 18px;
	color: #3a3a3a;
	font-family: georgia,serif;
}
#login:focus{background-color:#7FFF00;}
#password:focus{background-color:#7FFF00;}
legend{font-size:24px;}
.button
{
	background-color:#7CFC00;
	border: 1px solid #999;
	-moz-border-radius: 5px;
	padding: 5px;
	color: black;
	font-weight: bold;
	-webkit-border-radius: 5px;
	font-size: 13px;
	width: 70px;
}
.button:hover{background:  #cc6666;color: black;}
.button:active{background: #000099;color:white;}

</style>

</head>
<body style="background-image: url('${pageContext.request.contextPath }/img/login.jpg');">

	<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
	<fieldset>
	      <legend><strong>登录</strong></legend>
		   <label for="login"><strong>&nbsp;&nbsp;账&nbsp;&nbsp;&nbsp;号：</strong></label>
		    <input type="text"  id="login" name="username">
		    <div class="clear"></div>
		   <label for="password"><strong>密&nbsp;&nbsp;&nbsp;&nbsp;码:</strong></label>
		    <input type="password" id="password" name="password"><br/>
		    <span class="message" >${message }</span><br/>
		    <div class="clear"></div>
		 <input type="submit" style="margin: -20px 0 0 287px;" class="button" name="submit" value="登陆" />
       </fieldset>
	</form>
	
</body>
</html>