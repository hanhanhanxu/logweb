<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 导入标签库 后面的c是随意字母单词 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>首页</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" />
</head>
<body>

		<a href="${pageContext.request.contextPath }/RegisterUIServlet">注册</a>
		<a href="${pageContext.request.contextPath }/LoginUIServlet">登陆</a>

</body>
</html>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>首页</title>
	<style type="text/css">
	 h1{
       font-family:"Times New Roman", Times, serif;
       color:#6600ff;
    }
    span
    {
       margin-right:10px;
       float:right;
    }
    a{font-size:24px;}
    a:link {color:#000000;}   / * 未访问链接*/
	a:visited {color:#0000FF;}  /* 已访问链接 */
	a:hover {color:#FF00FF;}  /* 鼠标移动到链接上 */
	a:active {color:#00FF00;}  /* 鼠标点击时 */
	</style>
</head>
<body style="text-align: center;background-image:url('${pageContext.request.contextPath}/img/index.jpg');">

   <h1>主页</h1>

	<span><a href="${pageContext.request.contextPath }/RegisterUIServlet">注册</a></span>
	<span><a href="${pageContext.request.contextPath }/LoginUIServlet">登陆</a></span>
</body>
</html>