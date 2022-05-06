<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div id="contact-page" class="container">
    		 <h1>Đây là danh sách đơn hàng của bạn</h1>
    		<div class="container">
							<h3 class="text-center">Thông tin tất cả đơn hàng</h3>
							<hr>
							<div class="container text-left"></div>
							<br>
							<c:if test="${sessionScope.account != null}">
								<li class ="nav-item">
									<a class="nav-link" href="#"><i class="fa fa-user"></i> Hello, ${account.fullname}</a>
								</li>
								
							</c:if>
							<input readonly type="text" id="buyid" name="buyid" value="<c:out value='${account.id}' />" />
							<c:if test="${sessionScope.account == null}">
							<li>
							<a href="${pageContext.request.contextPath}/login2"></a>
							</li>
							</c:if>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Mã đơn hàng</th>
										<th>Mã giỏ hàng</th>
										<th>Mã sản phẩm</th>
										
									
										<th>Số lượng</th>
										<th>Tên người đặt</th>
										<th>Tên xe</th>
										<th>Ngày đặt hàng</th>
										<th>Gía</th>
										<th>Lựa chọn</th>
										
									</tr>
								</thead>
								<tbody>
									<!--   for (Todo todo: todos) {  -->
									<c:forEach items="${listorderbyid}" var="map">
										<tr>
											<td>${map.cartitemid}</td>
											<td>${map.cartid }</td>
											<td>${map.product_id}</td>
						
											<td>${map.quantity }</td>
											<td>${map.user_fullname }</td>
											<td>${map.pro_name }</td>
											<td>${map.buydate }</td>
											<td>${map.price }</td>

											<td>
											<a
												href="${pageContext.request.contextPath}/admin/cart-remove?cartid=${map.cartitemid}">Hủy</a></td>
										</tr>
									</c:forEach>
									
									<!-- } -->
									
								</tbody>
							</table>
						</div>

</div>	
    	