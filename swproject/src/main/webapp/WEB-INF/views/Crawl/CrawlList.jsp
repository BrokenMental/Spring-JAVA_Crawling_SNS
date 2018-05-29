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
							<th>IMG</th>
							<th>URL</th>
						</tr>
						<c:forEach items="${list1}" var="Crawl">
							<tr>
								<td style="width: 50%">${Crawl.n_Title}</td>
								<td><img src="${Crawl.n_IMG}"></td>
								<td>${Crawl.URL}</td>
								<%-- <td style="width: 50%">${Crawl.text()}</td>
								<td>${Crawl.attr("href")}</td> --%>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- /.col (left) -->
</div>
<%-- <c:forEach items="${LTest}"var ="LTest">
<table>
<tr>
<td>${LTest}</td>
</tr>
</table>
</c:forEach> --%>
<!--  /.row -->
<div style="bottom: 0px;">
	<%@ include file="../include/footer.jsp"%>
</div>