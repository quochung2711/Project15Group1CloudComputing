<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
h1.page-header {
	margin-top: -5px;
}

.sidebar {
	padding-left: 0;
}

.main-container {
	background: #FFF;
	padding-top: 15px;
	margin-top: -20px;
}

.footer {
	width: 100%;
}
</style>
<div class="container-fluid">
	<div class="col-md-12 content">
		<div class="panel panel-default">
			<div style="margin-top: 30px;" class="panel-heading">Thông tin
				tài khoản</div>
			<div class="panel-body">
				<div class="page-wrapper">
					<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
					<div class="container">
						<h3 class="text-center">Danh sách sản phẩm</h3>
						<hr>
						<div class="container text-left">

							<a href="admin-addPro"
								class="btn btn-success">Thêm sản phẩm mới</a>
						</div>
						<br>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>Mã loại</th>
									<!-- <th>Nhà cung cấp</th> -->
									<th>Tên</th>
									<th>Giá</th>
									<!-- <th>Mô tả</th> -->
									<th>Giảm giá</th>
									<th>Hình ảnh</th>
									<th>Đã bán</th>
									<th>Còn</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<!--   for (Todo todo: todos) {  -->
								<c:forEach var="row" items="${listallproduct}">

									<tr>
										<td>${row.pID}</td>
										<td>${row.categotyID}</td>
										<%-- <td>${row.suplierID}</td> --%>
										<td>${row.pname}</td>
										<td>${row.pprice} $</td>
										<%-- <td>${row.pcontent}</td> --%>
										<td>${row.discount}</td>
										<td><img src="<c:url value="${row.pimage }" />"
											style="width: 150px; height: 150px; object-fit: contain"
											alt="" /></td>
										<td>${row.amount}</td>
										<td>${row.sl}</td>
										<td><a
											href="admin-editproduct?pid=<c:out value='${row.pID}'/>">Sửa</a>
											&nbsp; <a
											href="admin-deleteproduct?pid=<c:out value='${row.pID}'/>">Xóa</a></td>
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





	