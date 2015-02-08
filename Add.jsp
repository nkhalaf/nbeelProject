<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8080/test/Add"  method="get"  id="form">
<input type="text" name="userName"  placeholder="userName"><br>
<input type="password"   id="pass1" name="password" placeholder="password"><br>
<input  type="password" name="password2" id="pass2" placeholder="confrim the password"><br>
<input type="text" name="admin" placeholder="admin 0=yes  1= no"><br>
<input type="button" value = "Add" onclick="dothis2()">
</form>
<script type="text/javascript">
 function dothis2(){
	 alert("here");
	 var form = document.getElementById("form");
	 if(vaild()){
		 form.submit();
		 
		 
	 }
	 
	 
 }

function vaild(){
 var passwrod = document.getElementById("pass1").valueOf();
 var password2 = document.getElementById("pass2").valueOf();
 if(password1==password2){
   return  true ;
 }
 else
	 return false ;
}

</script>


</body>
</html>