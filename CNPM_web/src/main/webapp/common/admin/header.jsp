<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>


<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<a class="navbar-brand" href="admin-home">Trang quản trị</a>
			</div>

			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<ul class="nav navbar-right navbar-top-links">

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<b class="caret"></b>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i>
								User Profile</a></li>
						<li class="divider"></li>
						<li><a href="${pageContext.request.contextPath}/login2"><i class="fa fa-sign-out fa-fw"></i>
								Thoát</a></li>
					</ul></li>
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="input-group-btn">
									<button class="btn btn-primary" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div> <!-- /input-group -->
						</li>
						<li><a href="${pageContext.request.contextPath}/admin-home"><i
								class="fa fa-edit fa-fw"></i>Biểu đồ doanh thu</a></li>
						<li><a href="${pageContext.request.contextPath}/admin-home-account"><i class="fa fa-table fa-fw"></i>
								Quản trị tài khoản</a></li>
						<li><a href="${pageContext.request.contextPath}/admin-home-product"><i class="fa fa-edit fa-fw"></i>
								Quản trị sản phẩm</a></li>
						<li><a href="${pageContext.request.contextPath}/admin-home-category"><i
								class="fa fa-edit fa-fw"></i> Quản trị danh mục</a></li>
						<li><a href="${pageContext.request.contextPath}/admin-home-news"><i
								class="fa fa-edit fa-fw"></i> Quản trị tin tức</a></li>
						<li><a href="${pageContext.request.contextPath}/admin-home-cart"><i
								class="fa fa-edit fa-fw"></i> Quản trị đơn hàng</a></li>
						<li><a href="${pageContext.request.contextPath}/admin-home-supplie"><i
								class="fa fa-edit fa-fw"></i> Quản trị nhà cung cấp</a></li>
						<li><a href="${pageContext.request.contextPath}/admin-home-income"><i
								class="fa fa-edit fa-fw"></i>Số lượng xe bán</a></li>
						<li><a href="${pageContext.request.contextPath}/admin-home-income-thang"><i
								class="fa fa-edit fa-fw"></i>Biểu đồ doanh thu tháng</a></li>
						
					</ul>
					<hr />
					<a href="${pageContext.request.contextPath}/home"> <h3>Về trang chủ</h3></a>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

	