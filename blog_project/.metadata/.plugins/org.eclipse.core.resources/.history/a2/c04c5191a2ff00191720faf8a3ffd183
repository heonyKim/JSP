<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ include file="/include/nav.jsp"%>



<!-- Contact Area -->
<section class="contact_area">
	<div class="container">
		<div class="row">

			<div class="col-lg-12">
				<form class="row contact_form" action="/blog/user?cmd=join" method="POST" id="contactForm" onsubmit="return validateCheck()">
					<div class="col-md-6">
						<div class="form-group">
							<input type="text" class="form-control" id="username" name="username" required="required" placeholder="아이디" maxlength="20">
						</div>
					</div>
					<div class="col-md-6">
						<!-- ID OVERLAP CHECK -->
						<div class="col-md-6">
							<div class="form-group float-right">
								<a class="blog_btn" href="#" onClick="usernameCheck()" style="font-size: 10pt;">중복확인</a>
							</div>
						</div>
						<div class="col-md-6">
							<span id="username_input"></span>
						</div>
						<!-- ID OVERLAP CHECK -->
					</div>


					<div class="col-md-12">
						<div class="form-group">
							<input type="password" class="form-control" id="password" name="password" required="required" placeholder="비밀번호" maxlength="20">
						</div>
					</div>

					<div class="col-md-12">
						<div class="form-group">
							<input type="password" class="form-control" id="passwordCheck" name="passwordCheck" required="required" placeholder="비밀번호 확인" maxlength="20">
						</div>
					</div>

					<div class="col-md-12">
						<div class="form-group">
							<input type="email" class="form-control" name="email" required="required" placeholder="이메일" maxlength="40">
						</div>
					</div>



					<div class="col-md-10">
						<div class="form-group">
							<input type="text" class="form-control" name="address" id="roadFullAddr" required="required" placeholder="주소영역" maxlength="60" readonly>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group float-right">
							<a class="blog_btn" href="#" onClick="goPopup();" style="font-size: 10pt;">주소찾기</a>
						</div>
					</div>

					<div class="col-md-12 text-right">
						<button type="submit" value="submit" class="btn submit_btn">JOIN</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<!-- Contact Area -->
<br>
<br>



<script>
	function goPopup() {
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		var pop = window.open("/blog/juso/jusoPopup.jsp", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");

	}
	//주소입력버튼 클릭시 콜백됨
	function jusoCallBack(roadFullAddr) {
		var juso = document.querySelector('#roadFullAddr');
		juso.value = roadFullAddr;
	}

	
	function validateCheck() {

		var password = document.querySelector('#password').value;
		var passwordCheck = document.querySelector('#passwordCheck').value;

		if (password === passwordCheck) {
			console.log("비밀번호가 동일합니다");
			return true;
		} else {
			console.log("비밀번호 틀림");
			alert("비밀번호를 다시확인하세요");
			return false;
		}

	}
	
	
	//아이디 중복확인
	<!-- ID OVERLAP CHECK -->
	var usernameDuplicateCheck = false;
	function usernameCheck(){
		
		var username = document.querySelector("#username").value; //적은 아이디값 받기
		var et = document.querySelector("#username_input");
		
		fetch("/blog/api/user?username="+username).then(function(r){
			return r.text();
		}).then(function(r){
			
			var status = r;
			
			console.log(status);
			if(status ==="ok"){
				et.innerHTML = "<font style='color:green; font-weight:bold; font-size:8pt;'>사용할 수 있는 아이디 입니다.</font>";
				usernameDuplicateCheck = true;
			}else{
				et.innerHTML = "<font style='color:red; font-weight:bold;font-size:8pt;'>사용할 수 없는 아이디 입니다.</font>";
				usernameDuplicateCheck = false;
			}
		});
		
	}
	<!-- ID OVERLAP CHECK -->
	
	
</script>


<%@ include file="/include/footer.jsp"%>