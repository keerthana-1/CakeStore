<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Cake</title>
<link rel="stylesheet" href="css/HomePage.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

</head>
<body style="background-image: url('./Images/addcake.jpeg');background-repeat: no-repeat;background-size: 100% 100%; background-attachment: fixed;">
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

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

<div style="height:auto;width:auto;padding:50px">
<h1>Cake Details</h1><hr><br>
<form action="CakeServlet" method="post" enctype="multipart/form-data">


  
 <div class="form-group">
<label>Cake Name: </label><input class="form-control" type=text name="Name">
</div>
<br>
<div class="form-group">
<label>Cake Price: </label><input class="form-control" type=number name="Price">
</div>
<br>

<%@ page import="Service.*,Domain.*,java.util.*" %>
<% 
List<FlavorObject> flavor=new ArrayList<FlavorObject>();
AddCakeService s=new AddCakeService();
flavor=s.getFlavors();
%>

<div class="input-group">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Flavors</label>
  </div>
  <Select class="custom-select" id="flavor" name="Flavor">
    <option selected>Choose...</option>
    <% 
for(FlavorObject f:flavor){
%>
<option value=<%= f.getId() %>><%= f.getFlavor() %></option>
   
<% 	
}

%>
    
  </select>
</div>

<br>


<%@ page import="Service.*,Domain.*,java.util.*" %>
<% 
List<OccasionObject> occasion=new ArrayList<OccasionObject>();
AddCakeService s1=new AddCakeService();
occasion=s1.getOccasions();
%>

<div class="input-group">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Occasions</label>
  </div>
<Select class="custom-select" id="occasion" name="Occasion">
 <option selected>Choose...</option>
<% 
for(OccasionObject o:occasion){
%>
<option value=<%= o.getId() %>><%= o.getOccasion() %></option>
   
<% 	
}

%>
 </Select>
</div>
<br>
<div class="form-group">
<label>Upload Image:</label><input class="form-control" type="file" id="cakeimg" name="Cakeimg">
</div>
<br>

<input class="btn btn-primary" type="submit" value="Add" />

</form>
</div>
</body>
</html>