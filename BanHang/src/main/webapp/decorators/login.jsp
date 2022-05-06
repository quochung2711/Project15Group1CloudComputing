
<!------ Include the above in your HEAD tag ---------->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %> 
 
<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
  
</head>
<body>


<dec:body />


</body>
<style>
/* Made with love by Mutiullah Samim*/
html,body{
    height: 100%;
    width: 100%;
    position: absolute;
    padding: 0%;
    margin: 0%;
}
.header{
    width: 100%;
    height: 100%;
    position: absolute;
    background: #000;
    color: #fff;
}
nav {
    display: flex;
    width: 100%;
    align-items: center;
    flex-wrap: wrap;
    padding: 20px 0 10px;
}
.logo{
    padding-left: 10%;
    width: 170px;
    cursor: pointer;
}
nav ul{
    padding-left: 10%;
    flex: 1;
    text-align: right;
    padding-right:40px ;
}

nav ul li{
    
    display: inline-block;
    list-style: none;
    margin: 10px 30px;
}
nav ul li a{
    color: #fff;
    text-decoration: none;
    font-size: 17px;
    letter-spacing: 1px;
}
nav ul li a:hover{
    color: #fff724;
}
.text-box{
    padding-left: 10%;
    margin-top: 11%;
    font-size: 17px;
    letter-spacing: 1px;
    line-height: 26px;
}
.text-box h1{
    font-size: 85px;
    line-height: 12px;
}
.text-box a{
    margin-top: 20px;
    display: inline-block;
    border-radius: 6px;
    border: 2px solid #fff724;
    color: #fff724;
    padding: 10px 20px;
    text-decoration: none;
}
.text-box .btn{
    background: #fff724;
    color: #000;
    margin-top: 30px;
    font-weight: 600;
}
.super-car{
    width: 600px;
    position:absolute;
    right: 10%;
    bottom: 0;
    
}
.container{
    margin-top: 30px;
    margin-right: 30px;
    width: 400px;
    position:absolute;
    right: 10%;
    
    top: 8%;
    background:#000;
    width: 350px;
}
.btn-login{
    margin-top: 7px;
    display: inline-block;
    border-radius: 6px;
    border: 2px solid #fff724;
    color: #fff724;
    padding: 10px 10px;
    text-decoration: none;
    background: #000;
    text-align: center;
}
.btn-login:hover{
    color:red;
}
.form-control{
    width: 200px;
    height: 30px;
    text-size-adjust: 45px;
}
.card-footer{
    margin-top: 15px;
}
.card-header h3{
    text-align: center;
    size: 30px;
    color: #fff724;
    
}
.card-footer .register-btn{
    display: inline-block;
    text-decoration: none;
}
.card-footer .register-btn:hover{
    color: #fff724;
}
.card-body input{
    padding-right: 8px;
    border-radius: 6px;
    border: 2px solid #fff724;
    text-decoration: none;
}
.container{
    border-radius: 6px;
    border: 2px solid #fff724;
   
}

</style>
</html>