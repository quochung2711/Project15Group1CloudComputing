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
                        
                      <form action="<%=request.getContextPath()%>/admin-insertnews" method="post">
                        
                         
						<br>
						

						<fieldset class="form-group">
                            <label>Image</label> <input type="text" class="form-control" name="image">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Title</label> <input type="text"  class="form-control" name="title">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Brief</label> 
                             <textarea rows="3" cols="70" class="form-control" name="brief"></textarea>
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Content</label> 
                            <textarea rows="9" cols="70"  class="form-control" name="content"></textarea>
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