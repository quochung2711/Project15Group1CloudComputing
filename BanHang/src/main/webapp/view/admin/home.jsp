<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ page import="java.util.*, java.text.*" %>
<%@ page import="java.util.*,java.sql.*" %>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
String dataPoints = null;

List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection=DriverManager.getConnection("jdbc:mysql://productdatabase.cluster-chqkcwcq83qc.us-east-1.rds.amazonaws.com:3306/ProductDATABASE","admin","21052711");
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

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin page</title>
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
			<div>
	<c:forEach var="income" items="${listincome }" >
				<p>Ngày bán: ${income.date }</p>
				<br>
				<p>Tổng số tiền thu được: ${income.money }</p>
			</c:forEach>
	</div>
			<!-- /row -->
		</div>
		<!-- footer -->
	<!-- /footer -->
	</div>
	
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	


	<!-- /.container-fluid -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.12"></script>
<script type="text/javascript">
    $(function () {
        var chart = new CanvasJS.Chart("chartContainer", {
            theme: "light2",
            animationEnabled: true,
            title: {
                text: "Doanh thu qua các ngày"
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


</body>

</html>
