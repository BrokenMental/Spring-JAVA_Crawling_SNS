<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<!-- CSS TEST -->
<link href="/resources/bootstrap/css/test.css" rel="stylesheet"
	type="text/css" />
</head>
<%@ include file="include/header.jsp"%>
<!-- Main content -->
<div class="row">
	<!--  left column -->
	<div class="col-md-12">
		<!--  general form elements -->
		<div class="box">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Home PAGE</h3>
				</div>
				<div class="box-body">
					<div class="grid">
						<!--  left column -->
						<c:forEach items="${list}" var="List">
							<c:if test="${List.f_Group == 'Feed' || List.f_Group eq 'Feed'}">
								<div class="grid-item">
									<table>
										<tr>
											<th style="width: 10px">F_Number</th>
											<td class="td-style">${List.f_Number}</td>
										</tr>
										<tr>
											<th>MyFeed</th>
											<td class="td-style">${List.myFeed}</td>
										</tr>
										<tr>
											<th>ID</th>
											<td class="td-style">${List.ID}</td>
										</tr>
										<tr>
											<th>Time</th>
											<td class="td-style">${List.f_Time}</td>
										</tr>
									</table>
								</div>
							</c:if>
							<c:if test="${List.c_Group == 'News' || List.c_Group eq 'News'}">
								<div class="grid-item" style="background: white">
									<table class="table-style">
										<tr>
											<th style="width: 10px">Title</th>
											<td class="td-style"><a href="${List.URL}">${List.n_Title}</a></td>
										</tr>
										<tr>
											<th>URL</th>
											<td class="td-style">${List.URL}</td>
										</tr>
									</table>
								</div>
							</c:if>
							<c:if test="${List.c_Group == 'SNS' || List.c_Group eq 'SNS'}">
								<div class="grid-item" style="background: skyblue">
									<table class="table-style">
										<tr>
											<th style="width: 10px">S_Content</th>
											<td class="td-style">${List.s_Content}</td>
										</tr>
										<tr>
											<th>S_User</th>
											<td class="td-style">${List.s_User}</td>
										</tr>
									</table>
								</div>
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
	<%@ include file="include/footer.jsp"%>
</div>

<script type="text/javascript">
	$('.grid').masonry({
		itemSelector : '.grid-item',
		columnWidth : 160
	});
</script>