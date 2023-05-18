<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<link rel="stylesheet" href="css/HomePage.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

</head>
<body onload="func1()">

<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="js/Home.js"></script>

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #FFB6C1;">
  <a class="navbar-brand" href="Home.jsp" style="padding-left:15px;">Cake Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
      
      <label class="nav-item" style="padding-top:8px;padding-left:800px;padding-right:15px;">Hello <%= session.getAttribute("name") %>!</label>
      
      <a class="nav-item nav-link" href="#!" data-toggle="modal" data-target="#cart" ><i class="fa fa-cart-plus" style="font-size:20px;color:black"></i><span class="ml-0 cart-items"></span></a>
     
      <a class="nav-item nav-link active"  href="ShowUserOrders.jsp">My Orders</a>
    
      <a class="nav-item nav-link active" href="Login.html">Logout</a>
     
     </div>
  </div>
</nav>

<div id="toast"></div>


	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="card" style="width: 50rem;margin-top:20px">
					<div class="card-body">
							<h3 class="text-center my-3"> Cakes in Cart</h3>
						<div class="checkout-cart-body">
							
							
						
						</div>
						
					
					</div>
				
				</div>
			
			</div>
			</div>
			<br>
			<hr>
			<br>
			<div >
				<form>
 					 <div class="form-group">
  						  <label for="InputEmail1">Email address</label>
   						 <input type="email" class="form-control" id="email" name="email" value=<%= session.getAttribute("username") %> >
    					 </div>
  							<div class="form-group">
   							 <label for="InputName">Name</label>
    							<input type="text" class="form-control" id="name" name="name" value=<%= session.getAttribute("name") %> >
 							 </div>
  							<div class="form-group">
   							 <label for="InputPhone">Phone Number</label>
   							 <input type="text" class="form-control" id="phone" name="phone" value=<%= session.getAttribute("phone") %> >
  							</div>
  							<div class="form-group">
    						<label for="InputDate">Delivery Date</label>
    						<input type="text" class="form-control" name="date" id="date" placeholder="YYYY-MM-DD"  value="YYYY-MM-DD"/>
    						
 							 </div>
  							<div class="form-group">
    						<label for="InputAddress">Shipping Address</label>
  							  <textarea class="form-control" id="address" rows="3" name="address"><%= session.getAttribute("address") %></textarea>
  							</div>
 
					</form>
			
			</div>
		
		</div>
		<br><br>
		<div style="text-align:center;">
		
		<button class="btn btn-primary" onclick="placeOrder()">place order</button>
	
		</div>
		
		<br>
		<br>

 <%@include file="Cart.jsp" %>
</body>
</html>