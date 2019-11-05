<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajax TEST</h1>
	<hr>


	<div id="demo">
		<h2>The XMLHttpRequest Object</h2>
		<button type="button" onclick="loadDoc()">Change Co0ntent</button>
	</div>

	<script>
		var reply = {
			id:null,
			boardId:'${board.id}',
			userId:'${sessionScope.user.id}',
			content:'나중에 input태그에 적힌 값을 들고오면댐',
			createDate : null
		}
		
		console.log(reply);
		var replyString=JSON.stringify(reply);	//JSON문자열로 변환
		console.log(replyString);

		function loadDoc() {
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {

					console.log(this.responseText);
					var jsonData = JSON.parse(this.responseText);
					console.log(jsonData);
					document.querySelector("#demo").innerHTML = jsonData.name + " " + jsonData.sal;

				}
			};
			xhttp.open("POST", "http://localhost:8000/blog/test", true);
			xhttp.setRequestHeader("Content-type","application:json");	//MIME타입
			xhttp.send(replyString);
		}
	</script>


</body>
</html>