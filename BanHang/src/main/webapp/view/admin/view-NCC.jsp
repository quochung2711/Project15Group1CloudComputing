<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">
	<div class="col-md-12 content">
		<div class="panel panel-default">
			<div style="margin-top:30px;" class="panel-heading">Supplier</div>
			<div class="panel-body">
			<div class="page-wrapper">


			<div class="container">
				<h3 class="text-center">Danh sách nhà cung cấp</h3>
				<hr>
				<div class="container text-left">

					<a href="admin-addNCC"
						class="btn btn-success">Thêm thêm nhà cung cấp</a>
				</div>
				<br>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<!-- <th>AuthorID</th> -->
							<th>Company name</th>
							<th>Phone</th>
							<th>address</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<!--   for (Todo todo: todos) {  -->
						<c:forEach var="row" items="${listallncc}">
							<tr>
								<td>${row.nccID}</td>
								<td>${row.nccName}</td>
								<td>${row.nccPhone}</td>
								<td>${row.nccAddress}</td>
								<td><a href="admin-showeditNCC?nccid=<c:out value='${row.nccID}'/>">Sửa</a>
						     &nbsp; <a href="admin-deleteNCC?nccid=<c:out value='${row.nccID}'/>">Xóa</a></td>
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
