
<!------ Include the above in your HEAD tag ---------->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <div class ="header">
        <nav>
            <a href="${pageContext.request.contextPath}/home"><img src="<c:url value="/template/image/banner/TrueCar_Thumbnail.png" /> " class="logo" /></a>
            
                
               
            
        </nav>
        <div class="text-box">
            <h1><span class="auto-input"></span></h1>
            <p>The car will be a happy future!</p>
            <p>Show room online. It's all for you!</p>
              <p>  Creative style, authentic, full of life. </p>
            <p> Excellent quality for the experiencer. </p>
            <p>   Protect your family from wind and rain. </p>
             <p>  Bring happiness to everyone!</p>
            <a href="contact">Contact me</a>
            <a href="${pageContext.request.contextPath}/home" class="btn">View main page</a>

        </div>
        <img src="<c:url value="/template/image/banner/sieu-xe.png"/>" class="super-car"> 

        <div class="container">
            <div class="card-header">
				<h3>Sign in</h3>
			</div>
			<div class="card-body">
				<form class="login" action="${pageContext.request.contextPath}/login2" method="post">
				 <center>
				 		<c:if test="${alert != null}">
							<p class="alert alert-danger">${alert}</p>
						</c:if>
						<span class="input-group-text"><i class="fas fa-user"></i></span>
						<input type="text" name="username"  class="form-control" placeholder="Username">
						<br>
                        <br>
						<span class="input-group-text"><i class="fas fa-key"></i></span>
						<input type="password"  name="password" class="form-control" placeholder="password">
                        <br>
                        <br>
						<input type="submit" value="Sign in" class="btn-login">
                    </center>
				</form>
			</div>
            <center>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					<a>Don't have account?</a>&nbsp;    
					<a href="register" class="register-btn">Sign up</a>
				</div>
				
			</div>
        </center>
        <br>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.12"></script>

    <script>
        var typed = new Typed(".auto-input",
        {
            strings:[" Car of New Future", "A Car make happy", "Unexpensive to buy","My team Deverloper","Designer with Heart"], 
            typeSpeed:100,
            backSpeed:100,
            loop:true
        })
    </script>