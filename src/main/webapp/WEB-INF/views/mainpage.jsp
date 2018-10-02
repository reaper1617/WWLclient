<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Main page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<style>
		
		.gradientbackgr{
  			background: #fffff0;
	 		background: radial-gradient(#0ed61f, #bfc2ff);
		}
	</style>
</head>
<body class="gradientbackgr">


<div class="container-fluid">



	<div class = "container-fluid">
		<h2>Fixed-top container</h2>
 		<nav class="nav nav-tabs bg-primary bg-light navbar-light fixed-top">
			<a class="navbar-brand" href="#">Main page</a>
			<!-- Nav tabs -->
		</nav>


	</div>
	<br>
	<div class = "container-fluid">

  			<div id="manageorders" >
    				<div class = "sticky-top">
						<h3>Orders <input type="button" class="btn btn-primary" onclick="updateOrders()" value="update"/></h3>
					</div>
				<div>
					<table id="myTable" class="table table-bordered table-active table-hover">
    						<thead>
      							<tr>
        							<th>Id</th>
        							<th>Description</th>
									<th>Date/time</th>
									<th>Status</th>
      							</tr>
						</thead>
							<tbody id="tablebody">
							<%--<c:if test="${ordersList != null}">--%>
								<%--<c:forEach items="${ordersList}" var="order">--%>
									<%--<tr>--%>
										<%--<td>${order.personalNumber}</td>--%>
										<%--<td>${order.description}</td>--%>
										<%--<td>${order.date}</td>--%>
										<%--<td>${order.status}</td>--%>
									<%--</tr>--%>
								<%--</c:forEach>--%>
							<%--</c:if>--%>
							</tbody>
    					</table>
				</div>
				<br>


		</div>
		
	</div>
	<div class = "container-fluid ">
		<nav class="nav nav-tabs bg-light navbar-light fixed-bottom">
			<a class="navbar-brand" href="#">WorldWideLogistics</a>
			<!-- Nav tabs -->
			<ul class="nav nav-tabs bg-light navbar-light" role="tablist">
			    <li class="nav-item">
			    	<a class="nav-link active " data-toggle="tab" href="#home">Home</a>
		    	    </li>
			    <%--<li class="nav-item">--%>
			    	<%--<a class="nav-link" data-toggle="tab" href="#about">About</a>--%>
 			    <%--</li>--%>
		       </ul>

		</nav>
	</div>
	
</div>


<%--<script>--%>
<%--function updateOrders() {--%>
    <%--alert("In function Update!")--%>
	<%--$.ajax(--%>
	    <%--type= "get",--%>
		<%--url = "http://localhost:8080/rest/mainservice/orders",--%>
		<%--async=true,--%>
		<%--dataType="json",--%>
		<%--success(function (resp) {--%>
           <%--// var arr = JSON.parse(resp);--%>
            <%--for(i in resp){--%>
                <%--var order = resp[i];--%>
                <%--alert("i = " + i + order);--%>
                <%--$('#myTable > tbody:last-child').append('<tr>order.id</tr><tr>order.personalNumber</tr><tr>order.description</tr><tr>order.status</tr>');--%>
            <%--}--%>
        <%--})--%>
	<%--)--%>
<%--}--%>
<%--</script>--%>

<script>
	function updateOrders() {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function() {
            if (this.readyState === 4 && this.status === 200) {
                var myObj = JSON.parse(this.responseText);
                for(var i = 0; i < myObj.length; i++) {
                   $('#tablebody').append('<tr> <td>' + myObj[i].id + '</td> <td>' + myObj[i].description + '</td> <td>' + myObj[i].personalNumber + '</td> <td>' + myObj[i].status + '</td>   </tr>');
                }
            }
        };
        xmlhttp.open("GET", "http://localhost:8081/getorders", true);
        xmlhttp.send();
    }

</script>

</body>
</html>
