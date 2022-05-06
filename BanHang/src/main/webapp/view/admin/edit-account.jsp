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
                    <form action="<%=request.getContextPath()%>/admin-update" method="post">
                       
                        
                        
                       	<header>Cập nhật thông tin</header>     
                                <br>
                                <br>

                        <c:if test="${user != null}">
                            <input type="hidden" name="uid" value="<c:out value='${user.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Tên đầy đủ</label> <input type="text" value="<c:out value='${user.fullname}' />" class="form-control" name="fullname" >
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Số điện thoại</label> <input type="text" value="<c:out value='${user.phone}' />" class="form-control" name="phone">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Tên đăng nhập</label> <input type="text" value="<c:out value='${user.username}' />" class="form-control" name="username" required="required" readonly>
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Mật khẩu</label> <input type="text" value="<c:out value='${user.password}' />" class="form-control" name="password">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Email</label> <input type="text" value="<c:out value='${user.email}' />" class="form-control" name="email" readonly>
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Mã Quyền</label> <input type="text" value="<c:out value='${user.roleid}' />" class="form-control" name="roleid">
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