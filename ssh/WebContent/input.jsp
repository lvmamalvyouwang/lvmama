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
       $(":input[name='lastName']").change(function(){
    	   var val=$.trim($(this).val());
    	   var $this=$(this);
    	   if(val!=""){
    		   $this.nextAll("font").remove(); 
    		   $.post("emp-isEmployee.action",{"lasName":val,"time":new Date()},function(data){
    			   if(data=="1"){
    				   $this.after("<font color='grenn'>用户名可用</font>");
    			   }else if(data=="0"){
    				   $this.after("<font color='red'>用户名不可用</font>");
    			   }else{
    				   alert("服务器错误!!");
    			   }
    		   });
    	   }else{
    		   alert("用户名不能为空");
    		   $(this).val("");
    	   }
       });
   });
</script>
<body>
   <center>
      <s:if test="#request.empid!=null">
      <h1>修改员工信息</h1>
      </s:if>
      <s:else>
      <h1>添加员工信息</h1>
      </s:else>
      <hr>
      <s:form action="emp-saverOrupdate.action" method="post">
        <s:hidden name="id"></s:hidden>
        <s:textfield name="lastName" label="员工姓名"></s:textfield>
        <s:textfield name="email" label="员工邮箱"></s:textfield>
        <s:textfield name="birth" label="出生日期"></s:textfield>
        <s:select list="#request.depar" listKey="id" listValue="departmentName" name="department.id" label="所属部门"></s:select>
        <s:submit></s:submit>
      </s:form>
   </center>
</body>
</html>