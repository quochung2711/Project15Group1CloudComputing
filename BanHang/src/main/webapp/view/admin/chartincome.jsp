<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ page import="java.util.*,java.sql.*"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%
Gson gsonObj = new Gson();
Map<Object, Object> map = null;
List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
String dataPoints = null;

try {
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection connection = DriverManager.getConnection(
	"jdbc:sqlserver://LAPTOP-RMQJTE8B\\SQLEXPRESS01:1433;databaseName=dbxehoi;user=sa;password=21052711;useUnicode=true;characterEncoding=UTF-8");
	Statement statement = connection.createStatement();

	ResultSet resultSet = statement.executeQuery("select * from soluong");

	while (resultSet.next()) {
		resultSet.getString(1);
		resultSet.getInt(2);
		map = new HashMap<Object, Object>();
		map.put("y", resultSet.getInt(2));
		map.put("legendText", resultSet.getString(1));
		map.put("label", resultSet.getString(1));
		list.add(map);
		dataPoints = gsonObj.toJson(list);
	}
	connection.close();
} catch (SQLException e) {
	out.println(
	"<div  style='width: 50%; margin-left: auto; margin-right: auto; margin-top: 200px;'>Could not connect to the database. Please check if you have mySQL Connector installed on the machine - if not, try installing the same.</div>");
	dataPoints = null;
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">


<title>Admin page</title>
<style>
.panel{
	border: 1px;
	margin-top: 500px;
}
</style>
</head>
<body>
	<div id="page-content-wrapper" class="page-content-toggle">
		<div class="container-fluid">
			<h1></h1>

			<div class="row">
				<div id="content" class="col-md-8 col-md-offset-1 col-xs-12">
					<div id='chartContainer'></div>
				</div>
			</div>
			
	
			<!-- /row -->
		</div>
		<!-- footer -->
		<!-- /footer -->
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<div class="panel">
		<p><c:forEach var="income" items="${listincome }">
			<p>Ngày bán: ${income.date }</p>
			<p>Tổng số tiền thu được: ${income.money}$</p>
		</c:forEach>
		</p>
	</div>


	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>



	<!-- /.container-fluid -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/chart-area-demo.js"></script>
	<script src="assets/demo/chart-bar-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.12"></script>
	<script type="text/javascript">
		$(function() {
			var chart = new CanvasJS.Chart("chartContainer", {
				title : {
					text : "Xe bán được"
				},
				animationEnabled : true,
				legend : {
					verticalAlign : "center",
					horizontalAlign : "left",
					fontSize : 20,
					fontFamily : "Helvetica"
				},
				theme : "light2",
				data : [ {
					type : "pie",
					indexLabelFontFamily : "Garamond",
					indexLabelFontSize : 20,
					indexLabel : "{label}: {y} car",
					startAngle : -20,
					showInLegend : true,
					toolTipContent : "{legendText} {y} car",
					dataPoints :<%out.print(dataPoints);%>
		} ]
			});
			chart.render();
		});
	</script>


</body>

</html>
