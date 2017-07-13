<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<!-- CSS TEST -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="/resources/bootstrap/js/masonry.pkgd.min.js"></script> 
<link href="/resources/bootstrap/css/masonry_grid.css" rel="stylesheet" type="text/css" />
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
								<div class="grid-item">
									<div class="div-first grid-color1"><p style="font-weight:800;">Feed | ${List.ID}</p></div>
									<hr>
									<div class="grid-color0">${List.f_Number} | ${List.f_Time}</div>
									<hr>
									<div class="grid-color0">${List.myFeed}</div>
								</div>
							</c:if>
							<c:if test="${List.c_Group == 'News' || List.c_Group eq 'News'}">
								<div class="grid-item">
									<div class="div-first grid-color2"><p style="font-weight:800;">NEWS | ${List.n_Source}</p></div>
									<hr>
									<c:choose>
									<c:when test="${List.n_IMG == '' }">
									<div class="grid-color0" style="text-align:center;">
										NO IMAGE
									</div>
									</c:when>
									<c:otherwise>
									<div class="grid-color0" style="text-align:center;">
										<p>
											<a href="${List.URL}">
												<img src="${List.n_IMG}">
											</a>
										</p>
									</div>
									</c:otherwise>
									</c:choose>
									<hr>
									<div class="grid-color0">
										<a href="${List.URL}"><font color="black">${List.n_Title}</font></a>
									</div>
								</div>
							</c:if>
							<c:if test="${List.c_Group == 'SNS' || List.c_Group eq 'SNS'}">
								<div class="grid-item">
									<div class="div-first grid-color3"><p style="font-weight:800;">SNS | ${List.s_User}</p></div>
									<hr>
									<div class="grid-color0" style="display:inline-block;">
										${List.s_Content}
									</div>
									<hr>
									<div class="grid-color0">
										<a href="${List.s_Addr}"><font color="black">${List.s_Addr}</font></a>
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