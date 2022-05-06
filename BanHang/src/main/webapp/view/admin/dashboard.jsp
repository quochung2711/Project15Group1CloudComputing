<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="java.util.*,java.sql.*" %>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>

<jsp:include page="/view/admin/home.jsp">
	<jsp:param value="Column Chart" name="pageTitle"/>
	<jsp:param value="<div id='chartContainer'/>" name="content"/> 	
</jsp:include>

<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
String dataPoints = null;

List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
	Connection connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-RMQJTE8B\\SQLEXPRESS01:1433;databaseName=dbxehoi;user=sa;password=21052711;useUnicode=true;characterEncoding=UTF-8");
	Statement statement = connection.createStatement();
	
	ResultSet resultSet = statement.executeQuery("select * from doanhthutheongay");
	int i =0;
	while(resultSet.next()){
		map = new HashMap<Object,Object>(); 
		map.put("label", resultSet.getDate(1)); 
		map.put("y", resultSet.getInt(2)); 
		list.add(map);
		dataPoints = gsonObj.toJson(list);
	}
	connection.close();
}
catch(SQLException e){
	out.println("<div  style='width: 50%; margin-left: auto; margin-right: auto; margin-top: 200px;'>Could not connect to the database. Please check if you have mySQL Connector installed on the machine - if not, try installing the same.</div>");
	dataPoints = null;
}

%>
<script type="text/javascript">
    $(function () {
        var chart = new CanvasJS.Chart("chartContainer", {
            theme: "light2",
            animationEnabled: true,
            title: {
                text: "Doanh thu"
            },
            data: [{
                type: "column",
                indexLabel: "{label} {y}$",
                dataPoints: <%out.print(dataPoints);%>
            }]
        });
        chart.render();
    });
</script>