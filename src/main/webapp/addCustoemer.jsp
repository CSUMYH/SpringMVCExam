<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           <%@ page isELIgnored="false" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<script type="text/javascript" src="<%=basePath %>js/jquery.1.11.3.min.js"></script>

<script type="text/javascript">
 window.onload=function(){
	$.post("address.do",function(data){
		html="";
		for(var i=0;i<data.length;i++){
			
		html+="<option value="+data[i].address+">"+data[i].address+"</option>";		
		}
		$("#address").html(html);
	});
 }

</script>


 <style type="text/css">
 body{
 	margin:0px;
	text-align: center;	
	background-color: rgb(217,217,225);
	}
	
		span{
		width: 10%;
		float:left;
	}
		.head{
	width: 100%;
	height: 50px;
	background-color: rgb(45,195,232);
	}
	.user{
	width: 40%;
	float: right;
	font-size: 24px;
	}
	
	.left_body{
	float:left;
	width: 20%;
	height:800px;
	border-right:1px solid #000;
	border-bottom:1px solid #000;
	}
	
	.right_body{
	float:left;
	width: 70%;
	height:800px;
	}
	.mod{
	width: 100%;
	height: 50px;
	}
	
	.right_head{
	clear:both;
	width: 100%;
	height: 50px;
	background-color: white;
	}
	.font_head{
	width:30%;
	font-size: 24px;
	float: left;

	}
	.login{
	clear:both;
	
	}
 </style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="head">
<span class="user">${name}</span>
</div>
<div class="left_body">
	<button class="mod" value="Customer管理">Dashboard</button>
	<button class="mod" value="Film管理">应用设置</button>
	<button class="mod" value="Film管理">管理设置</button>
	<button class="mod" value="Film管理">数据配置</button>
	<button class="mod" value="Film管理">主数据管理</button>
	<button class="mod" value="Film管理">发货单管理</button>			
</div>

<div class="right_body">
<div class="right_head"><span class="font_head">创建Customer</span></div>
<div class="login">
	<form action="add.do">
	<div class="write">
	<tr>
		<div class="word"><span>FirstName:</span> <input type="text" name ="first_name"></div>
	</tr>
	<tr>
		<div class="word"><span>LastName:</span><input type="text" name="last_name"></div>
	</tr>
	<tr>
		<div class="word"><span>Email:</span><input type="text" name="email"></div>
	</tr>
	<tr>

		<div class="word"><span>Address:</span>
		<select name="address" id="address">
	
	    </select></tr></div>
	  <input type="submit" value="新建" /> 
	  <input type="reset" value="取消"/>
	   </div>
	</form>
	<a href="index.jsp">返回index</a>
	</div>
	</div>
</body>
</html>
