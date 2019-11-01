<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>
<%@ include file="/include/nav.jsp"%>



<%-- <h1>${sessionScope.username}</h1> --%>

<c:if test="${empty sessionScope.user}">
	<script>
	alert('인증이 되지않은 유저입니다.');
	location.href="/blog/user/login.jsp";
	</script>
</c:if>


<!--================Contact Area =================-->
<section class="contact_area">

	<div class="container">
		<div class="row">

			<div class="col-lg-12">
				<form class="row contact_form" action="/blog/board?cmd=updateBoard&id=${board.id}" method="post" id="contactForm" novalidate="novalidate">
					<div class="col-md-12">
						<div class="form-group">
							<input type="text" class="form-control" id="title" name="title" value="${board.title}">
						</div>

					</div>
					<div class="col-md-12">
						<div class="form-group">
							<textarea class="form-control" name="content" id="content" rows="20">
							${board.content}
							</textarea>
						</div>
					</div>
					<div class="col-md-12 text-right">
						<button type="submit" value="submit" class="btn submit_btn">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<!--================Contact Area =================-->
<br>
<br>

<script>
      $('#content').summernote({
        placeholder: 'Hello bootstrap 4',
        tabsize: 2,
        height: 100
      });
      $('.dropdown-toggle').dropdown();
</script>
<%@ include file="/include/footer.jsp"%>
