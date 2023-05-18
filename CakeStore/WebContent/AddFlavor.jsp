<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flavors</title>
<link rel="stylesheet" href="css/HomePage.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

</head>
<body style="background-image: url('./Images/addcake.jpeg');background-repeat: no-repeat;background-size: 100% 100%; background-attachment: fixed;">

<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<script>
function addForm(){
	document.getElementById("delete").style.visibility="hidden";
	document.getElementById("add").style.visibility="visible";
}
function deleteForm(){
	document.getElementById("add").style.visibility="hidden";
	document.getElementById("delete").style.visibility="visible";
}

</script>


<nav class="navbar navbar-expand-lg navbar-light" style="background-image: url('./Images/signup2.png');background-repeat: no-repeat;background-size: 100% 100%; background-attachment: fixed;">
  <a class="navbar-brand" href="Home.jsp" style="padding-left:15px;">Cake Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="Admin.html">Home <span class="sr-only">(current)</span></a>      
     </div>
  </div>
</nav>

<div style="padding:30px;">
<button class="btn btn-dark" type="button" onclick="addForm()">Add Flavor</button> &nbsp&nbsp
<button class="btn btn-dark" type="button" onclick="deleteForm()">Delete Flavor</button>
</div>

<div style="padding:20px">
<form action="FlavorServlet" method="post" id="add" style="visibility:hidden;">
<div class="form-group">
<label>Flavor Name:</label><br>
<input class="form-control" type="text" name="flavor"><br>
</div>
<input class="btn btn-primary" type="submit" value="Add">
</form>
</div>

<div style="padding:40px">
<form action="FlavorServlet" method="post" id="delete" style="visibility:hidden;">
<h3>Available Flavors</h3><br>
<table class="table table-bordered">
<thead>
<th>Flavor</th>
<th>Remove</th>
</thead>
<%@ page import="Service.*,Domain.*,java.util.*" %>
<% 
List<FlavorObject> flavor=new ArrayList<FlavorObject>();
AddCakeService s=new AddCakeService();
flavor=s.getFlavors();
%>

<% 
for(FlavorObject f:flavor){
%>
<tr>
<td><%= f.getFlavor() %></td>
<td><a href="/CakeStore/FlavorServlet?id=<%= f.getId() %>">Delete</a></td>
</tr>			 
<%
}
%>

</table>
</form>
</div>
</body>
</html>