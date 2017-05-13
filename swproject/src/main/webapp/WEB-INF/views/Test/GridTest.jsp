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
<!-- Main content -->
<div class="gird">
	<!--  left column -->
	<c:forEach items="${list}" var="Feed">
		<table class="grid-item">
			<tr>
				<th style="width: 10px">F_Number</th>
				<th>MyFeed</th>
				<th>ID</th>
				<th>Time</th>
			</tr>
			<tr>
				<td>${Feed.f_Number}</td>
				<td><a
					href='/Feed/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&f_Number=${Feed.f_Number}'>${Feed.myFeed}</a></td>
				<td>${Feed.ID}</td>
				<td>${Feed.f_Time}</td>
			</tr>
		</table>
	</c:forEach>
</div>

<script type="text/javascript">
	$('.grid').masonry({
		itemSelector : '.grid-item',
		columnWidth : 160
	});
</script>