<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %> 

	<div class="col-md-10 content">
		<div class="panel panel-default">
		<div style="margin-top:30px;" class="panel-heading">Thông tin loại</div>
			<div class="panel-body">
			<div class="page-wrapper">
			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

			<div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                    <form action="<%=request.getContextPath()%>/admin-home-category-updatecategory" method="post">
                       
                        
                        
                       	<header>Cập nhật loại sản phẩm</header>     
                                <br>
                                <br>

                        <c:if test="${category != null}">
                            <input type="hidden" name="cid" value="<c:out value='${category.catalogID}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Tên loại</label> <input type="text" value="<c:out value='${category.cname}' />" class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Mô tả</label> <input type="text" value="<c:out value='${category.cDescription}' />" class="form-control" name="decription">
                        </fieldset>

                       
                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
		
		</div>
			</div>
		</div>
	</div>
	
