<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <style type="text/css">
 body{
	text-align: center;	
	background-image: url(222.jpg);
	background-repeat:no-repeat;
	background-size:100%; 
	}
	.login{
	width: 30%;
	height:200px;
	background-color: rgb(247,247,247);
 	margin: auto;
  	position: absolute;
  	top: 0; left: 0; bottom: 0; right: 0;
	border-radius: 10px;

	}
	

	.write{
		width: 80%;
		height: 30px;
		text-align: center;
		margin: auto;
  		position: absolute;
  		top: 0; left: 0; bottom: 0; right: 0;
	}
	.title1{
	margin-top:20px;
	margin-left:20px;
	 font-size:18px;
	float:left;
	width: 40%;
	}
	.title2{
	margin-top:20px;
	margin-left:20px;
	 font-size:38px;
	float:left;
	width: 20%;
	}
	
	
 </style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="title2"><span>10979 毛昱寰</span></div>
<div class = "login">
<div class="title1">电影租赁管理系统</div>
<form action="Login.do" >
<div class="write">

用户名：<input type="text" name ="name">
		<input type="submit" value = "登录" >
		</div>

</form>
</div>
</body>
</html>