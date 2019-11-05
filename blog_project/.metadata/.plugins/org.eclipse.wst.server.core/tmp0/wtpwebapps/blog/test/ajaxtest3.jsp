<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>Fetch API 사용하기 - promise</h1>

	<button onclick='getNum1()'>버튼</button>


	<script>
	
		
		let num1=0;
		let num2=0;
		let sum=0;
	
		function getNum1() {

			/* fetch("url",{method:"POST"}).then(),then(); */

			fetch("http://localhost:8000/blog/test2", {
				method : "POST",
				body:"안녕"	//보낼 수 있는 데이터 :json, String, object, number
			}).then(function(d) {
				return d.text();
				//return d.json();
			}).then(function(d) {
				num1=d;
				console.log(d);
				getNum2(); //getNum1()에서 data를 완벽하게 받은 후에 getNum2()를 실행
			});

		}

		function getNum2() {
			/* fetch("url",{method:"POST"}).then(),then(); */

			fetch("http://localhost:8000/blog/test3", {
				method : "POST"
			}).then(function(d) {
				return d.text();
				//return d.json();
			}).then(function(d) {
				num2=d;
				console.log(d);
				sum = Number(num1)+Number(num2);
				console.log("sum : "+sum);
			});
		}
		
		
	</script>



</body>
</html>