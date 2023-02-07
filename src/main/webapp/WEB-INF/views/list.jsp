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
<form method="post" action="write" id="guestform">
name : <input type="text" name ="name"><br>
<textarea rows="10" cols="50" name="content"form ="guestform"></textarea>
<br>
<input type="submit" value="등록" >
</form>
<br>
<br>
<c:forEach items="${list}" var="guestbook">
${guestbook.id}<br>
${guestbook.name}<br>
${guestbook.content}<br>
${guestbook.regdate}<br>
<a href="delete?id=${guestbook.id}"> 삭제</a><br><br>
</c:forEach>
<br>

</body>
</html>