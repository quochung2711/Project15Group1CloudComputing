<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<div id="contact-page" class="container">
    	<div class="bg">
	    	<div class="row">    		
	    		<div class="col-sm-12">    			   			
					<h2 class="title text-center">Liên hệ với chúng tôi</h2>    			    				    				
					</div>
				</div>			 		
			</div>    	
    		<div class="row">  
    		<c:forEach items="${listContact }" var="o">	
	    		<div class="col-sm-12">
	    			<div class="contact-info">
	    				<ul>
	    					<li>Địa chỉ: ${o.ctAddress }</li>
	    					<li>Số điện thoại: ${o.ctPhone }</li>
	    					<li>Email: ${o.ctEmail }</li>
	    				</ul>
	    				<div class="social-networks">
	    					<h2 class="title text-center">Social Networking</h2>
							<ul>
								<li>
									<a href="#"><i class="fa fa-facebook"></i></a>
								</li>
							</ul>
	    				</div>
	    			</div>
    			</div>
    			  	</c:forEach> 			
	    	</div>  
    	</div>	
    	
  