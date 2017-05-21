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
						<c:forEach items="${list}" var="Test">
							<table class="grid-item">
								<tr>
									<th style="width: 10px">F_Number</th>
									<td>${Test.f_Number}</td>
								</tr>
								<tr>
									<th>MyFeed</th>
									<td><a
										href='/Feed/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&f_Number=${Test.f_Number}'>${Test.myFeed}</a></td>
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
						</c:forEach>
						<c:forEach items="${list1}" var="Test1">
							<table class="grid-item">
								<tr>
									<th>Title</th>
									<td style="width: 50%">${Test1.getN_Title()}</td>
								</tr>
								<tr>
									<th>URL</th>
									<td>${Test1.getURL()}</td>
								</tr>
							</table>
						</c:forEach>
						<c:forEach items="${list2}" var="Test2">
							<table class="grid-item">
								<tr>
									<th>User</th>
									<td>${Test2.getS_User()}</td>
								</tr>
								<tr>
									<th>Content</th>
									<td>${Test2.getS_Content()}</td>
								</tr>
							</table>
						</c:forEach>
						<%-- <c:forEach items="${list}" var="Feed">
		<table class="grid-item">
			<tr>
				<th style="width: 10px">F_Number</th>
				<td>${Feed.f_Number}</td>
			</tr>
			<tr>
				<th>MyFeed</th>
				<td><a
					href='/Feed/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&f_Number=${Feed.f_Number}'>${Feed.myFeed}</a></td>
			</tr>
			<tr>
				<th>ID</th>
				<td>${Feed.ID}</td>
			</tr>
			<tr>
				<th>Time</th>
				<td>${Feed.f_Time}</td>
			</tr>
		</table>
	</c:forEach>
	<c:forEach items="${list1}" var="Crawl">
		<table class="grid-item grid-item--width2 grid-item--height2">
			<tr>
				<th>Title</th>
				<td style="width: 50%">${Crawl.text()}</td>
			</tr>
			<tr>
				<th>URL</th>
				<td>${Crawl.attr("href")}</td>
			</tr>
		</table>
	</c:forEach>
	<c:forEach items="${list2}" var="Crawl2">
		<table class="grid-item grid-item--width3 grid-item--height3">
			<tr>
				<th>User</th>
				<td>${Crawl2.getUser().getScreenName()}</td>
			</tr>
			<tr>
				<th>Content</th>
				<td>${Crawl2.getText()}</td>
			</tr>
		</table>
	</c:forEach> --%>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.col (left) -->
</div>

<script type="text/javascript">
	$('.grid').masonry({
		itemSelector : '.grid-item',
		columnWidth : 160
	});
</script>