<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %> 

	<div class="col-md-10 content">
		<div class="panel panel-default">
		<div style="margin-top:30px;" class="panel-heading">Thông tin bài viết</div>
			<div class="panel-body">
			<div class="page-wrapper">
			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

			<div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                    <form action="<%=request.getContextPath()%>/admin-home-supplie-editNCC" method="post">
                       
                        
                        
                       	<header>Cập nhật nhà cung cấp</header>     
                                <br>
                                <br>

                        <c:if test="${ncc != null}">
                            <input type="hidden" name="nccid" value="<c:out value='${ncc.nccID}' />" />
                        </c:if>
						


                        <fieldset class="form-group">
                            <label>Company name</label> <input type="text" value="<c:out value='${ncc.nccName}' />" class="form-control" name="name">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Phone</label> <input type="text" value="<c:out value='${ncc.nccPhone}' />" class="form-control" name="phone">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Address</label> 
                             <textarea rows="2" cols="70"class="form-control" name="address"><c:out value='${ncc.nccAddress}' /></textarea>
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
