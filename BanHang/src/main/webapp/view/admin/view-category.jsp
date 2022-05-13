<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

			<div class="container-fluid">
				<div class="col-md-12 content">
		<div class="panel panel-default">
			<div style="margin-top:30px;" class="panel-heading">Thông tin loại</div>
			<div class="panel-body">
			<div class="page-wrapper">
			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

			<div class="container">
				<h3 class="text-center">Danh sách danh sách loại sản phẩm</h3>
				<hr>
				<div class="container text-left">

					<a href="admin-add-category"
						class="btn btn-success">Thêm loại</a>
				</div>
				<br>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Tên</th>
							<th>Mô tả</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<!--   for (Todo todo: todos) {  -->
						<c:forEach var="row" items="${listAllCate}">
							<tr>
								<td>${row.catalogID}</td>
								<td>${row.cname}</td>
								<td>${row.cDescription}</td>
								<td><a href="admin-home-category-editcategory?cid=<c:out value='${row.catalogID}'/>">Sửa</a>
						     &nbsp; <a href="admin-home-category-deletecategory?cid=<c:out value='${row.catalogID}'/>">Xóa</a></td>
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
			<!-- /.container-fluid -->
