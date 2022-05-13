<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">
	<div class="col-md-12 content">
		<div class="panel panel-default">
			<div style="margin-top:30px;" class="panel-heading">Tin tức</div>
			<div class="panel-body">
			<div class="page-wrapper">


			<div class="container">
				<h3 class="text-center">Danh sách bài viết</h3>
				<hr>
				<div class="container text-left">

					<a href="admin-news-add"
						class="btn btn-success">Thêm bài viết</a>
				</div>
				<br>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<!-- <th>AuthorID</th> -->
							<th>Image</th>
							<th>Title</th>
							<th>Brief</th>
							<th>Content</th>
							<th>Create date</th>
							<th>Update date</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<!--   for (Todo todo: todos) {  -->
						<c:forEach var="row" items="${listallnew}">
							<tr>
								<td>${row.newID}</td>
								<%-- <td>${row.authorID}</td> --%>
								<td>${row.imageNew}</td>
								<td>${row.title}</td>
								<td>${row.brief}</td>
								<td>${row.content}</td>
								<td>${row.createDate}</td>
								<td>${row.updateDate}</td>
								<td><a href="admin-home-news-showeditnew?nid=<c:out value='${row.newID}'/>">Sửa</a>
						     &nbsp; <a href="admin-home-news-deletenews?nid=<c:out value='${row.newID}'/>">Xóa</a></td>
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
