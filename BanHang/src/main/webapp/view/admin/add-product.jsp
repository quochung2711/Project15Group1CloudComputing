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
                        
                      <form action="<%=request.getContextPath()%>/admin-product-add" method="post">
                        
                         
						<br>
                        <fieldset class="form-group">
                            
                            <label>Category</label> 
                            <select name="cateid" class="form-select" required>
                            	<c:forEach items="${listAllCate}" var="o">
                            		<option value="${o.catalogID}">${o.cname }</option>
                            	</c:forEach>
                            </select>                       
                        </fieldset>
                        
                        <fieldset class="form-group">
                          <label>Nhà cung cấp</label> 
                             <select name=spid class="form-select" required>
                            	<c:forEach items="${listallncc}" var="o">
                            		<option value="${o.nccID}">${o.nccName }</option>
                            	</c:forEach>
                            </select>
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Tên</label> <input type="text" value="<c:out value='${row.pname}' />" class="form-control" name="name">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Giá</label> <input type="text" value="<c:out value='${row.pprice}' />" class="form-control" name="price">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Mô tả</label> <input type="text" value="<c:out value='${row.pcontent}' />" class="form-control" name="content">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Giảm giá</label> <input type="text" value="<c:out value='${row.discount}' />" class="form-control" name="discount">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Hình ảnh</label> <input type="text" value="<c:out value='${row.pimage}' />" class="form-control" name="image">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Số lượng đã bán</label> <input type="text" value="<c:out value='${row.amount}' />" class="form-control" name="amount">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Số lượng nhập</label> <input type="text" value="<c:out value='${row.sl}' />" class="form-control" name="sl">
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
	
