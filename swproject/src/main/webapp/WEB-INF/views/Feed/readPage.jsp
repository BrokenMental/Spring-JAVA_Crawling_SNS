<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../include/header.jsp"%>
<!-- Main content -->
<script>
	$(document).ready(function() {
		var formObj = $("form[role='form']"); // formObj는 아래에 나오는 form태그를 의미한다.

		console.log(formObj);

/* 		$(".btn-warning").on("click", function() {
			formObj.attr("action", "/sboard/modifyPage");
			formObj.attr("method", "get");
			formObj.submit();
		}); */

		$(".btn-danger").on("click", function() {
			formObj.attr("action", "/sFeed/removePage");
			formObj.submit();
		});

		$(".btn-primary").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/sFeed/list");
			formObj.submit(); 
			
			// window.history.back(); // 완료알림창이 뜬다.
		});

	});
</script>
<section class="content">
<div class="row">
	<!--  left column -->
	<div class="col-md-12">
		<!--  general form elements -->
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">READ PAGE</h3>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">ID</label> <input type="text"
							name='ID' class="form-control" value="${feedVO.ID}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Feed</label>
						<textarea class="form-control" name="myFeed" rows="3"
							readonly="readonly">${feedVO.myFeed}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Time</label> <input type="text"
							name="f_Time " class="form-control" value="${feedVO.f_Time}"
							readonly="readonly">
					</div>
				</div>

				<form role="form" action="modifyPage" method="post">
					<input type='hidden' name='f_Number' value="${feedVO.f_Number}"> <input
						type='hidden' name='page' value="${cri.page}"> <input
						type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">
				</form>

				<!-- /.box-body -->
				<div class="box-footer">
					<!-- <button type="submit" class="btn btn-warning">Modify</button> -->
					<button type="submit" class="btn btn-danger">REMOVE</button>
					<button type="button" class="btn btn-primary">BACK</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /.col (left) -->
</div>
<!--  /.row --> </section>
<div style="bottom: 0px;">
	<%@ include file="../include/footer.jsp"%>
</div>
<!-- /.content -->
