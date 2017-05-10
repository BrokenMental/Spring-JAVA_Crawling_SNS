<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../include/header.jsp"%>
<!-- Main content -->
<div class="row">
	<!--  left column -->
	<div class="col-md-12">
		<!--  general form elements -->
		<div class="box">

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Crawl List</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th>Title</th>
							<th>URL</th>
						</tr>
						<c:forEach items="${list}" var="Crawl">
							<tr>
								<td style="width: 50%">${Crawl.text()}</td>
								<td>${Crawl.attr("href")}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
<%-- 				<div class="box-footer">
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
				</div> --%>
			</div>
		</div>
	</div>
	<!-- /.col (left) -->
</div>
<!--  /.row -->
<div style="bottom: 0px;">
	<%@ include file="../include/footer.jsp"%>
</div>