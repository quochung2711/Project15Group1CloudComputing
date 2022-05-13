<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %> 


	<div class="col-md-10 content">
		<div class="panel panel-default">
		<div style="margin-top:30px;" class="panel-heading">Thông tin nhà cung cấp</div>
			<div class="panel-body">
			<div class="page-wrapper">


			<div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        
                      <form action="<%=request.getContextPath()%>/admin-home-supplie-insertNCC" method="post">
                        
                         

						<fieldset class="form-group">
                            <label>Company name</label> <input type="text" class="form-control" name="nccname">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Phone</label> <input type="text"  class="form-control" name="nccphone">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Address</label> 
                             <textarea rows="2" cols="70" class="form-control" name="nccaddress"></textarea>
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