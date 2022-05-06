<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container-fluid">
	<div class="col-md-12 content">
		<div class="panel panel-default">
			<div style="margin-top:30px;" class="panel-heading">Thông tin tài khoản</div>
			<div class="panel-body">
			<div class="page-wrapper">
			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

			<div class="container">
				<h3 class="text-center">Danh sách tài khoản</h3>
				<hr>
				<div class="container text-left">

					<a href="admin-addAC"
						class="btn btn-success">Thêm tài khoản</a>
				</div>
				<br>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Tên</th>
							<th>Số điện thoại</th>
							<th>Tài khoản</th>
							<th>Mật khẩu</th>
							<th>Email</th>
							<th>Mã quyền</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<!--   for (Todo todo: todos) {  -->
						<c:forEach var="row" items="${listalluser}">
							<tr>
								<td>${row.id}</td>
								<td>${row.fullname}</td>
								<td>${row.phone}</td>
								<td>${row.username}</td>
								<td>${row.password}</td>
								<td>${row.email}</td>
								<td>${row.roleid}</td>
								<td><a href="admin-edit?uid=<c:out value='${row.id}'/>">Sửa</a>
						     &nbsp; <a href="admin-delete?id=<c:out value='${row.id}'/>">Xóa</a></td>
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
