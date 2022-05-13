<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Category</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<c:forEach items="${listAllCate }" var="cate">
								<div class="panel panel-default">
									<div class="panel-heading active ">
										<h4 class="panel-title "><a href="product?cid=${cate.catalogID }"><i class="fas fa-car"></i> ${cate.cname }</a></h4>
									</div>
								</div>
							</c:forEach>
						</div><!--/category-products-->					
						
						<div class="shipping text-center"><!--shipping-->
							<div class="col-md-3 col-lg-2">
							<img src="<c:url value="https://cdn.sforum.vn/sforum/wp-content/uploads/2018/10/Honor-Watch.jpg" /> " alt="" />
						</div><!--/shipping-->
					</div>
					</div>
				</div>