<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
    
	<section>
		<div class="container">
			<div class="row">
				<!-- left -->
				<%@ include file="/common/web/left.jsp" %>
				<!-- end-left -->
				<div class="col-sm-9 padding-right">
					<div class="product-details"><!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img src="<c:url value="${prodetail.pimage }" />" alt="" />
								<!-- <h3>ZOOM</h3> -->
							</div>
							<div id="similar-product" class="carousel slide" data-ride="carousel">
								
								 
							</div>

						</div>
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
								<img src="images/product-details/new.jpg" class="newarrival" alt="" />
								<h2>${prodetail.pname }</h2>
								<p>Web ID: 1089772</p>
								<img src="images/product-details/rating.png" alt="" />
								<span>
									<span>${prodetail.pprice } $</span>
									<label>Số lượng còn:</label>
									<input type="text" value="${prodetail.sl }" />
									<br /><br />
									<c:if test="${sessionScope.account != null}">
										<a href="${pageContext.request.contextPath}/member/cart-add?pid=${prodetail.pID}&quantity=1" class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Đặt hàng ngay</a>
									</c:if>
									<c:if test="${sessionScope.account == null}">
									<li>
									<a href="${pageContext.request.contextPath}/login2" class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Đặt hàng ngay</a>
									</li>
									</c:if>
								</span>
								<p><b>Availability:</b> In Stock</p>
								<p><b>Condition:</b> New</p>
								
								<!-- <a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a> -->
							</div><!--/product-information-->
						</div>
					</div><!--/product-details-->
					
					<div class="category-tab shop-details-tab"><!--category-tab-->
						<div class="col-sm-12">
							<ul class="nav nav-tabs">
								
								<li class="active"><a href="#reviews" data-toggle="tab"> Giới thiệu</a></li>
								<li><a href="#companyprofile" data-toggle="tab">Các sản phẩm khác</a></li>
							</ul>
						</div>
						<div class="tab-content">
							
							<div class="tab-pane fade" id="companyprofile" >
							<c:forEach items="${listTopNew }" var="p">
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
									<div class="productinfo text-center">
									<a class="car-name" href="productdetail?pid=${p.pID }">
										<img style ="height:150px;" src="<c:url value="${p.pimage }" />" alt="" />
										<h2>${p.pprice } $</h2>
										 <p style="display: -webkit-box; -webkit-line-clamp: 1; -webkit-box-orient: vertical ;overflow: hidden; "> ${p.pname } </p> </a>
										<c:if test="${sessionScope.account != null}">
										<a href="${pageContext.request.contextPath}/member/cart-add?pid=${p.pID}&quantity=1" class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Đặt hàng ngay</a>
										</c:if>
										<c:if test="${sessionScope.account == null}">
										<li>
										<a href="${pageContext.request.contextPath}/login2" class="btn btn-default add-to-cart"><i
											class="fa fa-shopping-cart"></i>Đặt hàng ngay</a>
										</li>
										</c:if>
									</div>
								</div>
									</div>
								</div>
							</c:forEach>	
							</div>
							
							<div class="tab-pane fade active in" id="reviews" >
								<div class="col-sm-12">
									
									<p>${prodetail.pcontent }</p>
								

								</div>
							</div>
							
						</div>
					</div><!--/category-tab-->
					
					<div class="recommended_items"><!--recommended_items-->
						<h2 class="title text-center"> Sản phẩm bán chạy</h2>
						<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">		
									<c:forEach begin="0" end="2" items="${list5bestseller }" var="bs">
										<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
												<a class="car-name" href="productdetail?pid=${bs.pID }">
													<img style ="height:150px;" src="<c:url value="${bs.pimage }" />" alt="" />
													<h2>${bs.pprice }$</h2>
													<p>${bs.pname }</p>
												</a>
													<c:if test="${sessionScope.account != null}">
														<a href="${pageContext.request.contextPath}/member/cart-add?pid=${bs.pID}&quantity=1" class="btn btn-default add-to-cart"><i
														class="fa fa-shopping-cart"></i>Đặt hàng ngay</a>
													</c:if>
													<c:if test="${sessionScope.account == null}">
													<li>
													<a href="${pageContext.request.contextPath}/login2" class="btn btn-default add-to-cart"><i
														class="fa fa-shopping-cart"></i>Đặt hàng ngay</a>
													</li>
													</c:if>
												</div>
												
											</div>
										</div>
									</div>
									</c:forEach>
								</div>
								<div class="item">	
									<c:forEach begin="2" end="4" items="${list5bestseller }" var="bs">
										<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="<c:url value="${bs.pimage }" />" alt="" />
													<h2>${bs.pprice } triệu VNĐ</h2>
													<p>${bs.pname }</p>
													<c:if test="${sessionScope.account != null}">
														<a href="${pageContext.request.contextPath}/member/cart-add?pid=${bs.pID}&quantity=1" class="btn btn-default add-to-cart"><i
														class="fa fa-shopping-cart"></i>Đặt hàng ngay</a>
													</c:if>
													<c:if test="${sessionScope.account == null}">
													<li>
													<a href="${pageContext.request.contextPath}/login2" class="btn btn-default add-to-cart"><i
														class="fa fa-shopping-cart"></i>Đặt hàng ngay</a>
													</li>
													</c:if>
												</div>
												
											</div>
										</div>
									</div>
									</c:forEach>
								</div>
							</div>
							 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
								<i class="fa fa-angle-left"></i>
							  </a>
							  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
								<i class="fa fa-angle-right"></i>
							  </a>			
						</div>
						
					</div><!--/recommended_items-->
					
				</div>
			</div>
		</div>
	</section>
	