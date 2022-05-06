<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<section>
		<div class="container">
			<div class="row">
				<!-- left -->
				<%@ include file="/common/web/left.jsp" %>
				<!-- end-left -->
				<div class="col-sm-9">
					<div class="blog-post-area">
						<h2 class="title text-center">Tin tức mới nhất</h2>
						<c:forEach items="${listNews}" var="o">
							<div class="single-blog-post">
								<h3>${o.title }</h3>
								<div class="post-meta">
									<ul>
										<li><i class="fa fa-user"></i> Mac Doe</li>
										<li><i class="fa fa-calendar"></i> ${o.createDate }</li>
									</ul>
									<span>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star-half-o"></i>
									</span>
								</div>
								<a href="">
									<img src="<c:url value="${o.imageNew }" />" alt="">
								</a>
								<p>${o.brief }</p>
								<a  class="btn btn-primary" href="blog-detail?nid=${o.newID }">Read More</a>
							</div>
						</c:forEach>
						<div class="pagination-area">
							<ul class="pagination">
								<li><a href="" class="active">1</a></li>
								<li><a href="">2</a></li>
								<li><a href="">3</a></li>
								<li><a href=""><i class="fa fa-angle-double-right"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>