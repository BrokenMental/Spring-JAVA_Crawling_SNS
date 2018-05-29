<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../include/header.jsp"%>
<!-- Main content -->
<div class="row">
	<!--  left column -->
	<div class="col-md-12">
		<!--  general form elements -->
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">REGISTER PAGE</h3>
				<form role="form" method="post">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">ID</label> <input type="text"
								name='ID' class="form-control" value="user00">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Group</label> <input type="text"
								name='F_Group' class="form-control" value="Feed">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Feed</label>
							<textarea class="form-control" name="MyFeed" rows="3"
								placeholder="Enter Feed"></textarea>
						</div>
					</div>
					<!--  /.box-body -->
					<div class="box-footer">
						<button type="submit" class="btn btn-warning">SUBMIT</button>
						<button type="button" class="btn btn-primary">CANCEL</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- /.col (left) -->
</div>
<!--  /.row -->
<!-- /.content -->
<%@ include file="../include/footer.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form[role='form']"); // formObj는 아래에 나오는 form태그를 의미한다.

		console.log(formObj);

		$(".btn-primary").on("click", function() {
			window.history.back();
		});

	});
</script>