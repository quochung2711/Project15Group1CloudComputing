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
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Tất cả sản phẩm</h2>
						<c:forEach  items="${listAllProd }" var="p">	
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
									<a class="car-name" href="productdetail?pid=${p.pID }"> 
										<img style ="height:150px;" src="<c:url value="${p.pimage }" />" alt="" />
										<h2>${p.pprice } $</h2>
										<p style="display: -webkit-box; -webkit-line-clamp: 1; -webkit-box-orient: vertical ;overflow: hidden; " > ${p.pname } </p> </a>
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
						<!-- <ul class="pagination">
							<li class="active"><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">&raquo;</a></li>
						</ul> -->
					</div><!--features_items-->
				</div>
			</div>
		</div>
	</section>
	
	