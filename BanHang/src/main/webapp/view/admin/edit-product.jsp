<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %> 

	<div class="col-md-10 content">
		<div class="panel panel-default">
		<div style="margin-top:30px;" class="panel-heading">Thông tin sản phẩm</div>
			<div class="panel-body">
			<div class="page-wrapper">
			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

			<div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                    <form action="<%=request.getContextPath()%>/admin-updateproduct" method="post">
                       
                        
                        
                       	<header>Cập nhật thông tin</header>     
                                <br>
                                <br>

                        <c:if test="${product != null}">
                            <input type="hidden" name="pid" value="<c:out value='${product.pID}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Mã loại</label> <input type="text" value="<c:out value='${product.categotyID}' />" class="form-control" name="cateid" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Mã nhà cung cấp</label> <input type="text" value="<c:out value='${product.suplierID}' />" class="form-control" name="spid">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Tên</label> <input type="text" value="<c:out value='${product.pname}' />" class="form-control" name="name">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Gía</label> <input type="text" value="<c:out value='${product.pprice}' />" class="form-control" name="price">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Content</label> <input type="text" value="<c:out value='${product.pcontent}' />" class="form-control" name="content">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>giảm giá</label> <input type="text" value="<c:out value='${product.discount}' />" class="form-control" name="discount">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Hình ảnh</label> <input type="text" value="<c:out value='${product.pimage}' />" class="form-control" name="image">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Số lượng đã bán</label> <input type="text" value="<c:out value='${product.amount}' />" class="form-control" name="amount">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Số lượng còn</label> <input type="text" value="<c:out value='${product.sl}' />" class="form-control" name="sl">
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
