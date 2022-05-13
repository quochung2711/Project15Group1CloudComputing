<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div id="contact-page" class="container">

<c:if test="${sessionScope.account != null}">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="well">
    <ul class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">Profile</a></li>
      <li><a href="#profile" data-toggle="tab">Password</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
      
       <form action="<%=request.getContextPath()%>/update-user" method="post">
      	  <c:if test="${user != null}">
                     <input type="hidden" name="uid" value="<c:out value='${user.id}' />" />
           </c:if>
            <label>Full name</label>
            <input type="text" value="<c:out value='${user.fullname}' />" class="input-xlarge" name="fullname">
            <label>Phone</label>
            <input type="text" value="<c:out value='${user.phone}' />"class="input-xlarge" name="phone">
            <label>User name</label>
            <input type="text" value="<c:out value='${user.username}' />" class="input-xlarge" name="username" required="required" readonly>
            <label>Mật khẩu</label> <input type="text" value="<c:out value='${user.password}' />" class="form-control" name="password">
            <label>Email</label>
            <input type="text" value="<c:out value='${user.email}' />" class="input-xlarge" name="email">
            <input type="hidden" value="<c:out value='${user.roleid}' />" class="form-control" name="roleid">
          	<div>
        	    <button class="btn btn-primary">Update</button>
        	</div>
        	<a href="${pageContext.request.contextPath}/home">Về trang chủ</a>
        	
        </form>
     
  </div>
  </div>
  </div>
 </c:if>	   		 
</div>	
    	