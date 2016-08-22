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
<script src="<%=basePath %>js/bootstrap.min.js"></script>
 <link href="<%=basePath %>js/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
var pn=1;

function exit(){
	var answer = confirm("是否退出系统！");
	if(answer){
	window.location.href="exit.do";
	}
}

function deletecus(obj){
	
	var id= obj.id
	
	var answer = confirm("是否删除此条数据！") 
	if(answer){
		$.get("delete.do",{'customer_id': id},function(){		
		})
	}
}
	

function altRows(id){
	if(document.getElementsByTagName){  
		
		var table = document.getElementById(id);  
		var rows = table.getElementsByTagName("tr"); 
		 
		for(i = 0; i < rows.length; i++){          
			if(i % 2 == 0){
				rows[i].className = "evenrowcolor";
			}else{
				rows[i].className = "oddrowcolor";
			}      
		}
	}
}



// 	$.post("customer.do",function(data){
// 		var html="";
// 		for(var i=0;i<data.length;i++){
// 			html+="<tr><td><a href="+"\""+"#myModal"+"?customer_id="+data[i].customer_id+"\">操作 |</a>"+"<a href="+"\""+"delete.do"+"?customer_id="+data[i].customer_id+"\"> 删除</a>"+"</td><td>"+data[i].first_name+"</td>"+"<td>"+data[i].last_name+"</td>"+"<td>"+data[i].address_id+"</td>"+"<td>"+data[i].email+"</td>"+"<td>"+data[i].customer_id+"</td>"+"<td>"+data[i].last_update+"</td></tr>";
// 		}
// 		$("#content").html(html);
// 	});
	
	function getData(pn){
	  var	pn=$("#current-page").text();
	$.post("customer.do",function(data){
		var totalCount = data.length;//总记录数
		var pageSize= 10;//每页显示多少条记录
		var pageTotal = Math.ceil(totalCount / pageSize);//页数
		var startPage = pageSize * (pn-1);

		var endPage = startPage + pageSize - 1;
		var html="";
		if(pageTotal ==1){//当只有一页时
			for(var i=0;i<totalCount;i++){
				html+="<tr><td><button data-toggle="+"\""+"modal"+"\""+"data-target="+"\""+"#myModal"+"\""+" id="+"\""+data[i].customer_id+"\">操作 |</button>"+"<button onclick="+"\""+"deletecus(this)"+"\""+" id="+"\""+data[i].customer_id+"\"> 删除</button>"+"</td><td>"+data[i].first_name+"</td>"+"<td>"+data[i].last_name+"</td>"+"<td>"+data[i].address_id+"</td>"+"<td>"+data[i].email+"</td>"+"<td>"+data[i].customer_id+"</td>"+"<td>"+data[i].last_update+"</td></tr>";
			}
		}else{
			for(var i= startPage,k=0;i<endPage,k<pageSize;i++,k++){
				if(i==totalCount){
					break;//当遍历到最后一条记录时，跳出循环
				}
				html+="<tr><td><button data-toggle="+"\""+"modal"+"\""+"data-target="+"\""+"#myModal"+"\""+" id="+"\""+data[i].customer_id+"\">操作 |</a>"+"<button onclick="+"\""+"deletecus(this)"+"\""+" id="+"\""+data[i].customer_id+"\"> 删除</button>"+"</td><td>"+data[i].first_name+"</td>"+"<td>"+data[i].last_name+"</td>"+"<td>"+data[i].address_id+"</td>"+"<td>"+data[i].email+"</td>"+"<td>"+data[i].customer_id+"</td>"+"<td>"+data[i].last_update+"</td></tr>";
			}
		}
		$("#content").html(html);
	});
	}
	window.onload=function() { 
	
		
		$.post("address.do",function(data){
			html="";
			for(var i=0;i<data.length;i++){
				
			html+="<option value="+data[i].address+">"+data[i].address+"</option>";		
			}
			$("#address").html(html);

		});
		
		$.post("customer.do",function(data){
			var totalCount = data.length;
			var pageSize =10;
			var pageTotal=Math.ceil(totalCount / pageSize);
			$("#next").click(function(){
				pn=$("#current-page").text();
				if(pn==pageTotal){
					alert("后面没有了");
					pn=pageTotal;
					$("#current-page").text(pn);
				}else{
					pn++;
					$("#current-page").text(pn);
					gotoPage(pn);
				}
			});
			$("#prev").click(function(){
				pn=$("#current-page").text();
				if(pn==1){
					alert("前面没有了");
					pn=1;
				}else{
					pn--;
					$("#current-page").text(pn);
					gotoPage(pn);
				}
			});
		    $("#firstPage").click(function() {    
		        	$("#current-page").text(1);
                  pn=$("#current-page").text();
                  gotoPage(pn);  
              });  
      		$("#lastPage").click(function() {  
      		$("#current-page").text(pageTotal);  
      		pn=$("#current-page").text();
                  gotoPage(pn);  
              });  
		})
		
	
	function gotoPage(pn){
		getData(pn);
	}
	

	}

	
</script>


<style type="text/css">
body{
	text-align: center;	
	background-color: rgb(217,217,225);
	}
table.altrowstable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #a9c6c9;
	border-collapse: collapse;
	margin: auto;
}
table.altrowstable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.altrowstable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
.oddrowcolor{
	background-color:#d4e3e5;
}
.evenrowcolor{
	background-color:#c3dde0;
}

	.login{
	width: 30%;
	height:200px;
	background-color: rgb(185,208,232);
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
		span{
		width: 20px;
		float: left;
	}
	
	.head{
	width: 100%;
	height: 50px;
	background-color: rgb(45,195,232);
	}
	.user{
	width: 20%;
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
</style>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="head">
<span class="user">${name}</span>
<button id ="exit" onclick="exit()">退出</button>
</div>
<div class="left_body">
	<button class="mod" value="Customer管理">Customer管理</button>
	<button class="mod" value="Film管理">Film管理</button>
</div>
<div class="right_body">
<a href="addCustoemer.jsp" >新建</a>
<table  class="altrowstable" id="alternatecolor">

		<tr>
			<th>操作</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Address</th>
			<th>Email</th>
			<th>CustomerID</th>
			<th>LastUpdate</th>
		</tr>
		<tbody id="content">
	
		</tbody>
</table>

<span id="current-page">1</span>
<a id="firstPage">首页</a>
<a id="prev">上一页</a>
<a id="next">下一页</a>
<a id="lastPage">最后一页</a>
</div>



<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
           	  修改操作
            </h4>
         </div>
         <div class="modal-body">
           <form action="">
			<div >
			<tr>
		<div ><span>FirstName:</span><input type="text" id="first_name" name ="first_name"></div>
			</tr>
			<tr>
		<div><span>LastName:</span><input type="text" id="last_name" name="last_name"></div>
			</tr>
			<tr>
		<div ><span>Email:</span><input type="text" id="email" name="email"></div>
			</tr>
			<tr>
		<div ><span>Address:</span>
		<select name="address" id="address">
	    </select></tr></div>
	   </div>
	   <input type="submit" value="提交">
	   <input type="reset" value="重置">
	</form>
         </div>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
</body>
</html>