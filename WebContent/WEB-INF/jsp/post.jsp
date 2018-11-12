<%--
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发表帖子</title>

	<meta charset="utf-8" />
		<title></title>
		<style>
		  div{
		  	   width: 360px;
		  	   height: 400px;
		  	   border: 2px solid black;
		  	   padding: 40px;
		  	   margin-left:486px;
		  	   
		  }
		  span{
		  	    display: block;
		  	    margin-bottom: 20px;
		  }
		  input,textarea{
		  	border: 2px solid black;
		  }
		</style>

</head>
<body>
		
 	<div class="box">
 		<form action="${pageContext.request.contextPath }/BoardPostServlet" method="post">
		   	      <span>标题：<input type="text" name="matter_text"/></span>
		   	      <span>详情:</span><textarea name="matter_content" rows="12" cols="35" style="width: 349px;height: 292px;"></textarea>
		   	      <br/>
		   	      <br/>
		   	      <input type="submit" name="submit" value="发 帖">&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/BoardUIServlet">返回</a>
		</form>
	</div>
	
	
</body>
</html>
 --%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发表帖子</title>

	<meta charset="utf-8" />
		<title></title>
		<style>
		body{
		        background-image:url('${pageContext.request.contextPath}/img/8.jpg');
		    	background-repeat: no-repeat;
				background-size:cover ;
		   }
		  div{
		  	   width: 360px;
		  	   height: 400px;
		  	   border: 2px solid black;
		  	   padding: 40px;
		  	   margin-left:486px;  
		  	   margin-top:50px;
		  }
		  span{
		  	    display: block;
		  	    margin-bottom: 20px;
		  }
		div,input,textarea,button{
		  	border: 2px solid #8B008B;
		  }
		  #in,button{
		      background-color: #dca995;
		  }
		</style>

</head>
<body>
		
 	<div class="box">
 		<form action="${pageContext.request.contextPath }/BoardPostServlet" method="post">
		   	      <span>标题：<input type="text" name="matter_text"/></span>
		   	      <span>详情:</span><textarea name="matter_content" rows="12" cols="35" style="width: 349px;height: 292px;"></textarea>
		   	      <br/>
		   	      <br/>
		   	      <input id="in" type="submit" name="submit" value="发 帖">&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/BoardUIServlet"><button>返回</button></a>
		</form>
	</div>
	
	
</body>
</html>