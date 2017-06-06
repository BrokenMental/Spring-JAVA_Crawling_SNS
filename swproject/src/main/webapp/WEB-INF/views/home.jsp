<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<!-- CSS TEST -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="/resources/bootstrap/js/masonry.pkgd.min.js"></script> 
<link href="/resources/bootstrap/css/test.css" rel="stylesheet" type="text/css" />
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
					<div class="grid" data-masonry='{ "itemSelector": ".grid-item"}'>
						<!--  left column -->
						<c:forEach items="${list}" var="List">
							<c:if test="${List.f_Group == 'Feed' || List.f_Group eq 'Feed'}">
								<div class="grid-item grid-color1">
									<div>${List.f_Number}</div>
									<div>${List.myFeed}</div>
									<div>${List.ID}</div>
									<div>${List.f_Time}</div>
								</div>
							</c:if>
							<c:if test="${List.c_Group == 'News' || List.c_Group eq 'News'}">
								<div class="grid-item grid-item--height2 grid-color2">
									<a href="${List.URL}">${List.n_Title}</a>
								</div>
							</c:if>
							<c:if test="${List.c_Group == 'SNS' || List.c_Group eq 'SNS'}">
								<div class="grid-item grid-item--height3 grid-color3" style="background: skyblue">
									<div style="height:70%;">
										${List.s_Content}
									</div>
									<div>
										<hr>
										${List.s_User}
									</div>
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