<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<section id="slider"><!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					
					
				</div>
			</div>
		</div>
	</section><!--/slider-->
	
	
<div class="container">
	<div class="row">
		<!-- left -->
				<%@ include file="/common/web/left.jsp" %>
		<!-- end-left -->
		<div class="col-sm-9 padding-right">
			<div class="features_items">
				<!--features_items-->
				<h2 class="title text-center">TOP NEW CAR</h2>
				<c:forEach items="${list6product }" var="bao">
					<div class="col-sm-4">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<a class="car-name" href="productdetail?pid=${bao.pID }">
									<img style ="height:150px;" src="<c:url value="${bao.pimage }" />" alt="" />
									<h2> ${bao.pprice }$</h2>
									<p> ${bao.pname }</p>
									</a>
									<c:if test="${sessionScope.account != null}">
										<a href="${pageContext.request.contextPath}/member/cart-add?pid=${bao.pID}&quantity=1" class="btn btn-default add-to-cart"><i
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

			<div class="recommended_items">
				<!--recommended_items-->
				<h2 class="title text-center">Sản phẩm bán chạy</h2>
				<div id="recommended-item-carousel" class="carousel slide"
					data-ride="carousel">
					<div class="carousel-inner">
						<div class="item active">
							<c:forEach begin="0" end="2" items="${list5bestseller }" var="bs">
								<div class="col-sm-4">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
											<a class="car-name" href="productdetail?pid=${bs.pID }">
												<img style ="height:150px;" src="<c:url value="${bs.pimage}" />" alt="" />
												<h2>${bs.pprice } $</h2>
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
												<h2>${bs.pprice } $</h2>
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
					<a class="left recommended-item-control"
						href="#recommended-item-carousel" data-slide="prev"> <i
						class="fa fa-angle-left"></i>
					</a> <a class="right recommended-item-control"
						href="#recommended-item-carousel" data-slide="next"> <i
						class="fa fa-angle-right"></i>
					</a>
				</div>
			</div>
			<!--/recommended_items-->


		</div>
	</div>
</div>
