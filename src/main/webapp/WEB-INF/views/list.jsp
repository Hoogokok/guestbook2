<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
 <style>
 .form-inline {
   flex-flow: row wrap;
   align-items: center;
 }

.form-inline input {
  vertical-align: middle;
  margin: 1px 1px 1px 0;
  padding: 2px;
  background-color: #fff;
  border: 1px solid #ddd;
}
.form-inline textarea {
  vertical-align: middle;
  margin: 5px 10px 5px 0;
  padding: 10px;
  background-color: #fff;
  border: 1px solid #ddd;
}

</style>
    
</head>
<body>
<form method="post" class="form-inline" action="write" id="guestform">
<label for="name">이름 :</label>
<input  type="text" name ="name"><br>
<label for="pwd">비밀번호 :</label>
<input type = "password" name="password"> <br>
<textarea rows="10" cols="50" name="content"form ="guestform"></textarea>
<br>
<input type="submit" value="등록" >
</form>
<br>
<br>
<c:forEach items="${list}" var="guestbook">
${guestbook.no}<br>
${guestbook.name}<br>
${guestbook.content}<br>
${guestbook.reg_date}<br>
<a href="delete?no=${guestbook.no}"> 삭제</a><br><br>
</c:forEach>
<br>

</body>
</html>