<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="addAlien">

<input type="text" name="aid"/><br>
<input type="text" name="aname"/><br>
<input type="text" name="lang"/><br>
<button type="submit">submit</button>
</form>

<br>
<br>
<br>

Retrieve
<form action="getAlien">
<input type="text" name="aid"/><br>
<button type="submit">submit</button>
</form>

<br>
<br>
<br>

<br>
<br>
<br>
Update
<form action="updateAlien">
Id to be updated<input type="text" name="aid"/><br>
Name to be updated<input type="text" name="aname"/><br>
Lang to be updated<input type="text" name="lang"/><br>
<button type="submit">submit</button>

</form>

</body>
</html>