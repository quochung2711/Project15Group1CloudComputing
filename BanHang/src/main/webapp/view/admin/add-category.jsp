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
                        
                      <form action="<%=request.getContextPath()%>/admin-home-category-insert" method="post">
                        
                         
						<br>
                          <fieldset class="form-group">
                            <label>Tên loại</label> <input type="text" value="<c:out value='${row.cname}' />" class="form-control" name="namesp" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Mô tả</label> <input type="text" value="<c:out value='${row.cDescription}' />" class="form-control" name="des">
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
