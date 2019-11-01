<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/include/nav.jsp"%>



<section class="contact_area">
	<div class="container">
		<div class="row">

			<div class="col-lg-12">
				<form class="row contact_form" action="/blog/user?cmd=login" method="POST" id="contactForm">
					<div class="col-md-12">
						<div class="form-group">
						
							<c:choose>
								<c:when test="${empty cookie.username.value}">
									<input type="text" class="form-control" id="username" name="username" placeholder="Enter your ID">
								</c:when>
								
								<c:otherwise>
									<input type="text" class="form-control" id="username" name="username" placeholder="이거 나오면 안됨" value ="${cookie.username.value}">	
								</c:otherwise>
							</c:choose>						
							
						</div>
					</div>

					<div class="col-md-12">
						<div class="form-group">
							<input type="password" class="form-control" id="password" name="password" placeholder="Enter your password">
						</div>
					</div>

					<div class="col-md-12 text-right">
						<label>
							<input type="checkbox" name="rememberMe" value="on">Remember me
						</label>
					</div>

					<div class="col-md-12 text-right">

						<button type="submit" value="submit" class="btn submit_btn">LOGIN</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>

<br>
<br>

<%@ include file="/include/footer.jsp"%>