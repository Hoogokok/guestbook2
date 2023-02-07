<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
 <style>
      span{
        border: solid grey;        
      }
      #guestcount{
       font-size: 1.2em
      }
    </style>
    
</head>
<body>
<form method="post" action="delete" id="guestform">
비밀번호 : <input type = "password" name="password"> <br>
<br>
<input type="submit" value="확인" >
</form>

<a href="list"> 메인으로 돌아가기</a><br><br>

<br>
<br>
<br>

</body>
</html>