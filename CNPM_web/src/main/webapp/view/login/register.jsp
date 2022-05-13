<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<div class="container">
		<div class="row main">
			<div class="main-login main-center">
				<h5>Đăng ký tài khoản</h5>
				<form class="" method="post"
					action="${pageContext.request.contextPath}/register" method="post">
					<c:if test="${alert != null}">
						<p class="alert alert-danger">${alert}</p>
					</c:if>
					
					
					
					<div class="form-group">
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fas fa-user fa" aria-hidden="true"></i></span> <input
									type="text" class="form-control" name="fullname" id="fullname"
									placeholder="Nhập họ tên của bạn" />
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fas fa-phone fa" aria-hidden="true"></i></span> <input
									type="text" class="form-control" name="phone" id="phone"
									placeholder="Nhập số điện thoại" />
							</div>
						</div>
					</div>
	
					<div class="form-group">
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
									type="text" class="form-control" name="email" id="email"
									placeholder="Nhập email của bạn" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-users fa"
									aria-hidden="true"></i></span> <input type="text" class="form-control"
									name="username" id="username" placeholder="Nhập tên đăng nhập" />
							</div>
						</div>
					</div>

					
					<div class="form-group">
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
									type="password" class="form-control" name="password"
									id="password" placeholder="Nhập mật khẩu" />
							</div>
						</div>
					</div>

					
					<div class="form-group ">
						<button type="submit" class="btn btn-primary btn-lg btn-block login-button">Đăng ký</button>
					</div>
					<div class="form-group ">
						<a href="login2" type="button"
							id="button" class="btn btn-primary btn-lg btn-block login-button">Trở về</a>
					</div>
				</form>
			</div>
		</div>
	</div>

