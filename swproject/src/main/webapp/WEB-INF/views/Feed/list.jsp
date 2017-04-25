<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
</script>

<%@ include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
<div class="row">
	<!--  left column -->
	<div class="col-md-12">
		<!--  general form elements -->
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">Feed List</h3>
			</div>

			<div class='box-body'>
				<select name="searchType">
					<option value="n"
						<c:out value = "${cri.searchType == null?'selected':''}"/>>
						---</option>
					<option value="f"
						<c:out value = "${cri.searchType eq 'f'?'selected':''}"/>>
						Feed</option>
					<option value="i"
						<c:out value = "${cri.searchType eq 'i'?'selected':''}"/>>
						ID</option>
					<option value="fi"
						<c:out value = "${cri.searchType eq 'fi'?'selected':''}"/>>
						Feed OR ID</option>
				</select> <input type="text" name='keyword' id="keywordInput"
					value='${cri.keyword}'>
				<button id='searchBtn'>Search</button>
				<button id='newBtn'>New Feed</button>
			</div>
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Feed PAGE</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">F_Number</th>
							<th>MyFeed</th>
							<th>ID</th>
							<th>Time</th>
						</tr>

						<c:forEach items="${list}" var="FeedVO">
							<tr>
								<td>${FeedVO.f_Number}</td>
								<td><a
									href='/Feed/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&f_Number=${FeedVO.f_Number}'>${FeedVO.myFeed}</a></td>
								<td>${FeedVO.ID}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${FeedVO.f_Time}" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="box-footer">
					<div class="text-center">
						<ul class="pagination">
							<c:if test="${pageMaker.prev}">
								<li><a
									href="list${pageMaker.makeSearch(pageMaker.startPage -1)}">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage}"
								end="${pageMaker.endPage}" var="idx">
								<li
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
								</li>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a
									href="list${pageMaker.makeSearch(pageMaker.endPage +1)}">&raquo;</a></li>
							</c:if>
						</ul>
					</div>
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

<script>
	$(document).ready(
			function() {
				$('#searchBtn').on(
						"click",
						function(event) {
							self.location = "list"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keywordInput').val();
						});

				$('#newBtn').on("click", function(evt) {
					self.location = "register";
				});
			});
</script>