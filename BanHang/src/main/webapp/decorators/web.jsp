<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="/common/taglib.jsp" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title><dec:title default="Trang chủ" /></title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="<c:url value="/template/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/template/css/font-awesome.min.css" />" rel="stylesheet">
    <link href="<c:url value="/template/css/prettyPhoto.css" />" rel="stylesheet">
    <link href="<c:url value="/template/css/price-range.css" />"rel="stylesheet">
    <link href="<c:url value="/template/css/animate.css" />" rel="stylesheet">
	<link href="<c:url value="/template/css/main.css" />" rel="stylesheet">
	<link href="<c:url value="/template/css/responsive.css" />" rel="stylesheet">
	 <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    	<link href="<c:url value="/style/css/style.css" />" rel="stylesheet">
  	
  
</head>

<body>
	<!-- Header -->
	<%@ include file="/common/web/header.jsp" %>
	<!-- End header -->
	
	
	<!-- Content -->
	<dec:body />
	<!--End Content -->
	
	<!-- Footer -->
	<%@ include file="/common/web/footer.jsp" %>
	<!-- End footer -->"
    <script src="<c:url value="/template/js/jquery.js" />"></script>
	<script src="<c:url value="/template/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/template/js/jquery.scrollUp.min.js" />"></script>
	<script src="<c:url value="/template/js/price-range.js" />"></script>
    <script src="<c:url value="/template/js/jquery.prettyPhoto.js" />"></script>
    <script src="<c:url value="/template/js/main.js" />"></script>
</body>
</html>

    