<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %> 

	<div class="col-md-10 content">
		<div class="panel panel-default">
		<div style="margin-top:30px;" class="panel-heading">Thông tin tài khoản</div>
			<div class="panel-body">
			<div class="page-wrapper">
			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

			<div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        
                      <form action="<%=request.getContextPath()%>/admin-home-account-insert" method="post">
                        
                         
						<br>
                         <fieldset class="form-group">
                            <label>Tên đầy đủ</label> <input type="text" value="<c:out value='${row.fullname}' />" class="form-control" name="fullname" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Số điện thoại</label> <input type="text" value="<c:out value='${row.phone}' />" class="form-control" name="phone">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Tên đăng nhập</label> <input type="text" value="<c:out value='${row.username}' />" class="form-control" name="username">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Mật khẩu</label> <input type="text" value="<c:out value='${row.password}' />" class="form-control" name="password">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Email</label> <input type="text" value="<c:out value='${row.email}' />" class="form-control" name="email">
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
