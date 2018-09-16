<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
   $(function(){
	   $(".delete").click(function(){
	       var b=confirm("确定要删除"+$(this).next(":hidden").val()+"吗?");
	       if(b){
	          var dom=$(this).parent().parent();
	    	   $.post(this.href,{"time":new Date()},function(data){
	    		   if(data=="1"){
	    			   alert("删除成功!");
	    			   dom.remove();
	    		   }else{
	    			   alert("删除失败!");
	    		   }
	    	   });
	       }
		   return false;
	   });
   });
</script>
<body>
   <center>
    <h1>员工信息</h1>
    <a href="emp-input.action">添加新员工</a>
    <hr>
    <table cellpadding="1" cellspacing="0" border="1">
       <tr>
         <th>员工姓名</th>
         <th>员工邮箱</th>
         <th>出生日期</th>
         <th>创建时间</th>
         <th>所属部门</th>
         <th>操作</th>
       </tr>
       <s:iterator value="list">
         <tr>
           <td>${lastName}</td>
           <td>${email}</td>
           <td>
             <s:date name="birth" format="yyyy-MM-dd"/>
           </td>
           <td>${createTime }</td>
           <td><a href="emp-input.action?empid=${id}">修改</a><a class="delete" href="emp-delete.action?empid=${id}">删除</a><input type="hidden"value="${lastName}"></td>
         </tr>
       </s:iterator>
    </table>
   </center>
</body>
</html>