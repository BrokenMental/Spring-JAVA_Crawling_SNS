<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<!-- CSS TEST -->
<link href="/resources/bootstrap/css/test.css" rel="stylesheet"
	type="text/css" />
</head>
<%@ include file="../include/header.jsp"%>
<!-- Main content -->
<div class="row">
	<!--  left column -->
	<div class="col-md-12">
		<!--  general form elements -->
		<div class="box">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Test PAGE</h3>
				</div>
				<div class="box-body">
					<div class="gird">
						<!--  left column -->
						<%-- <c:forEach items="${test}" var="Test">
							<c:if test="${Test.get(0).get(0).c_Group == 'News' || Test.get(0).get(0).c_Group eq 'News'}">
							<table class="grid-item" style="background:white">
								<tr>
									<th style="width: 10px">Title</th>
									<td>${Test.get(0).get(0).n_Title}</td>
								</tr>
								<tr>
									<th>URL</th>
									<td>${Test.get(0).get(0).URL}</td>
								</tr>
							</table>
							</c:if>
							<c:if test="${Test.get(0).get(0).c_Group == 'SNS' || Test.get(0).get(0).c_Group eq 'SNS'}">
							<table class="grid-item" style="background:skyblue">
								<tr>
									<th style="width: 10px">S_Content</th>
									<td>${Test.get(0).get(0).s_Content}</td>
								</tr>
								<tr>
									<th>S_User</th>
									<td>${Test.get(0).get(0).s_User}</td>
								</tr>
							</table>
							</c:if>
						</c:forEach> --%>
						<c:forEach items="${view}" var="Test" varStatus="status">
							<c:if test="${Test.f_Group == 'Feed' || Test.f_Group eq 'Feed'}">
							<table class="grid-item">
								<tr>
									<th style="width: 10px">F_Number</th>
									<td>${Test.f_Number}</td>
								</tr>
								<tr>
									<th>MyFeed</th>
									<td>${Test.myFeed}</td>
								</tr>
								<tr>
									<th>ID</th>
									<td>${Test.ID}</td>
								</tr>
								<tr>
									<th>Time</th>
									<td>${Test.f_Time}</td>
								</tr>
							</table>
							</c:if>
							<c:if test="${Test.c_Group == 'News' || Test.c_Group eq 'News'}">
							<table class="grid-item" style="background:white">
								<tr>
									<th style="width: 10px">Title</th>
									<td>${Test.n_Title}</td>
								</tr>
								<tr>
									<th>URL</th>
									<td>${Test.URL}</td>
								</tr>
							</table>
							</c:if>
							<c:if test="${Test.c_Group == 'SNS' || Test.c_Group eq 'SNS'}">
							<table class="grid-item" style="background:skyblue">
								<tr>
									<th style="width: 10px">S_Content</th>
									<td>${Test.s_Content}</td>
								</tr>
								<tr>
									<th>S_User</th>
									<td>${Test.s_User}</td>
								</tr>
							</table>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.col (left) -->

<div style="bottom: 0px;">
	<%@ include file="../include/footer.jsp"%>
</div>

<script type="text/javascript">
	$('.grid').masonry({
		itemSelector : '.grid-item',
		columnWidth : 160
	});
</script>