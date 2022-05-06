<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div id="contact-page" class="container">
<c:if test="${sessionScope.account != null}">
<center>
    		 <p><font size="6px" color="blue">Chúc mừng khách hàng ${account.fullname} đã đặt hàng thành công!</font> </p>
    		 <p><font size="6px" color="blue" >Vui lòng đến địa chỉ: 1 Đ. Võ Văn Ngân, Linh Chiểu, Thủ Đức, Thành phố Hồ Chí Minh để thực hiện thanh xem xe và thanh toán !</font></p>
    		 <p><font size="6px" color="blue" >Mọi thắc mắc có thể gửi qua số điện thoại: 0786234776 hoặc email: 19133010@student.hcmute.edu.vn</font></p>
    		 <p>Xin chân thành cảm ơn quý khách, chúc quý khách vạn sự tốt lành!</p>
  </center>
    		 <h2><a href="${pageContext.request.contextPath}/home">Tiếp tục mua sắm</a></h2>
 </c:if>	   		 
</div>	
    	