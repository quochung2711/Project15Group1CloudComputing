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
                    <form action="<%=request.getContextPath()%>/admin-home-news-editnews" method="post">
                       
                        
                        
                       	<header>Cập nhật bài viết</header>     
                                <br>
                                <br>

                        <c:if test="${news != null}">
                            <input type="hidden" name="nid" value="<c:out value='${news.newID}' />" />
                             <input type="hidden" name="aid" value="<c:out value='${news.authorID}' />" />
                        </c:if>
						


                        <fieldset class="form-group">
                            <label>Image</label> <input type="text" value="<c:out value='${news.imageNew}' />" class="form-control" name="image">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Title</label> <input type="text" value="<c:out value='${news.title}' />" class="form-control" name="title">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Brief</label> 
                             <textarea rows="3" cols="70"class="form-control" name="brief"><c:out value='${news.brief}' /></textarea>
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Content</label> 
                            <textarea rows="9" cols="70" class="form-control" name="content"><c:out value='${news.content}' /></textarea>
                        </fieldset>                          
            			
            			  <fieldset class="form-group">
                             <label>Create Date</label> <input type="text" value="<c:out value='${news.createDate}' />" class="form-control" name="createdate" required="required" readonly>
                        </fieldset>
                          <fieldset class="form-group">
                            <input type="hidden" type="text" value="<c:out value='${news.updateDate}' />" class="form-control" name="image">
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
