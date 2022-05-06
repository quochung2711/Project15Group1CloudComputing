<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Quản lý giỏ hàng</title>
</head>
<body>
	<div class="container-fluid">
		<div class="col-md-12 content">
			<div class="panel panel-default">
				<div style="margin-top: 30px;" class="panel-heading">Thông tin giỏ hàng</div>
				<div class="panel-body">
					<div class="page-wrapper">
						<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

						<div class="container">
							<h3 class="text-center">Quản lý giỏ hàng</h3>
							<hr>
							<div class="container text-left"></div>
							<br>
							<table class="table table-striped" >
								<thead>
									<tr>
										<th>Mã sản phẩm</th>
										<th>Tên sản phẩm</th>
										<th>Ảnh</th>
										<th>Số lượng tồn</th>
										<th>Số lượng</th>
										<th>Giá</th>
										<th>Lựa chọn</th>
									</tr>
								</thead>
								<tbody>
									<!--   for (Todo todo: todos) {  -->
									<c:forEach items="${sessionScope.cart}" var="map">
										<tr>
											<td>${map.value.product.pID }</td>
											<td>${map.value.product.pname }</td>
											<c:url
												value="${map.value.product.pimage}"
												var="imageurl"></c:url>
											<td><img src="${imageurl}" /></td>
											<td>${map.value.product.sl}</td>
											<td>${map.value.quantity }</td>
											<td>${map.value.unitPrice}$</td>

											<td><a
												href="${pageContext.request.contextPath}/member/cart-remove?pid=${map.value.product.pID}">Xoa</a></td>
										</tr>
									</c:forEach>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td>Sub-Total</td>
										<td class="text-right">
											<h4>Subtotal:</h4> <c:set var="total" value="${0}" /> 
											<c:forEach items="${sessionScope.cart}" var="map">
												<c:set var="total"
													value="${total + map.value.quantity * map.value.product.pprice}" />
											</c:forEach>
											<div class="total-result-in">
												<span>$ ${total }</span>

											</div>
										</td>
									</tr>
									<!-- } -->
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td><strong>Total</strong></td>
										<td class="text-right"><strong>$ ${total }</strong></td>
									</tr>
								</tbody>
							</table>
							<a href="${pageContext.request.contextPath}/member/order">Đặt trước</a>
							&nbsp;
							&nbsp;
							&nbsp;
							&nbsp;
							<a href="${pageContext.request.contextPath}/home">Tiếp tục mua sắm</a>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>