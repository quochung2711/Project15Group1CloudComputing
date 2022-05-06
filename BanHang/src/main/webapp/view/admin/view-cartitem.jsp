<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Gio hang</title>
</head>
<body>
	<div class="container-fluid">
		<div class="col-md-12 content">
			<div class="panel panel-default">
				<div style="margin-top: 30px;" class="panel-heading">Thông tin
					giỏ hàng</div>
				<div class="panel-body">
					<div class="page-wrapper">
						<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

						<div class="container">
							<h3 class="text-center">Thông tin tất cả đơn hàng</h3>
							<hr>
							<div class="container text-left"></div>
							<br>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Mã đơn hàng</th>
										<th>Mã giỏ hàng</th>
										<th>Mã sản phẩm</th>
										
										<th>Mã người đặt</th>
										<th>Số lượng</th>
										<th>Tên người đặt</th>
										<th>Tên xe</th>
										<th>Ngày đặt hàng</th>
										<th>Gía</th>
										<th>Lựa chọn</th>
										
									</tr>
								</thead>
								<tbody>
									<!--   for (Todo todo: todos) {  -->
									<c:forEach items="${listcart}" var="map">
										<tr>
											<td>${map.cartitemid}</td>
											<td>${map.cartid }</td>
											<td>${map.product_id}</td>
											<td>${map.user_id }</td>
											<td>${map.quantity }</td>
											<td>${map.user_fullname }</td>
											<td>${map.pro_name }</td>
											<td>${map.buydate }</td>
											<td>${map.price }</td>

											<td>
											<a
												href="${pageContext.request.contextPath}/admin/cart-remove?cartid=${map.cartitemid}">Xóa</a></td>
										</tr>
									</c:forEach>
									
									<!-- } -->
									
								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>