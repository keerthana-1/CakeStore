<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="css/HomePage.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="js/Home.js"></script>



<nav class="navbar navbar-expand-lg navbar-light" style="background-image: url('./Images/signup2.png');background-repeat: no-repeat;background-size: 100% 100%; background-attachment: fixed;">
  <a class="navbar-brand" href="Home.jsp" style="padding-left:15px;">Cake Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
      
      <label class="nav-item"  style="padding-top:8px;padding-left:800px;padding-right:15px;">Hello <%= session.getAttribute("name") %>!</label>
      
      <a class="nav-item nav-link" href="#!" data-toggle="modal" data-target="#cart" ><i class="fa fa-cart-plus" style="font-size:20px;"></i><span class="ml-0 cart-items" ></span></a>
     
     <a class="nav-item nav-link active"  href="ShowUserOrders.jsp">My Orders</a>
     
      <a class="nav-item nav-link active"  href="Login.html">Logout</a>
     
     </div>
  </div>
</nav>



<div id="toast"></div>

<div class="row">

	<div id="filters" class="col-md-2" style="height:300vh;background-color:#FFFACD" >
		<div class="list-group mt-4">
			<%@ page import="Service.*,Domain.*,java.util.*" %>
			<% List<FlavorObject> flavor=new ArrayList<FlavorObject>();
			AddCakeService s=new AddCakeService();
			flavor=s.getFlavors();
			%>

			<% 
			for(FlavorObject f:flavor){
			%>
			<a href="Home.jsp?flavor=<%= f.getId() %>" class="list-group-item list-group-item-action" > <%= f.getFlavor() %></a>
   
			<% 	
				}

			%>
			<a href="Home.jsp?flavor=all" class="list-group-item list-group-item-action" > All Flavors </a>
  

			<br>
			<%
			List<OccasionObject> occasion=new ArrayList<OccasionObject>();
			occasion=s.getOccasions();
			%>

			<% 
			for(OccasionObject o:occasion){
			%>

			<a href="Home.jsp?occasion=<%= o.getId() %>" class="list-group-item list-group-item-action" > <%= o.getOccasion() %></a>
   
   
			<% 	
			}

			%>
			<a href="Home.jsp?occasion=all" class="list-group-item list-group-item-action" > All Occasions </a>
  
 
		</div>
		
		

	</div>

 
<div class="col-md-10">

	<div class="row mt-4">

		<div class="col-md-12">

			<div class="card-columns">

				<% 
				
				String fid=request.getParameter("flavor");
				String oid=request.getParameter("occasion");
				
				List<CakeObject> cakes=new ArrayList<CakeObject>();
				
				if(fid==null && oid ==null)
				{
					cakes=s.getCakeDetails();
				}
				
				else
				{
					
			   		if(fid!=null && !fid.equals("all")){
					cakes=s.getCakeDetailsByFlavor(Integer.parseInt(fid));
					}
					else if(oid!=null && !oid.equals("all")){
					cakes=s.getCakeDetailsByOccasion(Integer.parseInt(oid));
					}
					else if((fid!=null && fid.equals("all")) || (oid!=null && oid.equals("all"))){
					cakes=s.getCakeDetails();
					}
				}

				if(cakes.isEmpty()){
					
				%>
					
					<h3> No cakes available in this category  </h3>
					
					
				<%  
				}
				else{
				%>
				<% 
				for(CakeObject c:cakes){
				%>

				<div class="card" style="float:left; width:350px; height:500px; margin-right:10px; margin-bottom:10px;">
					<div class="container text-center">
  						<img class="card-img-top" style="max-height: 200px;max-width:100%;width:auto" src="${pageContext.request.contextPath}<%= c.getImgPath() %>" alt="image" width="300px" height="200px">
  
  					</div>
  					<div class="card-body">
  
  						<h3 class="card-title"> <%= c.getName() %> </h3>
  					
  
  						<p class="card-text">Price:&nbsp$<%= c.getPrice() %></p>
  						
  				    	<% 
						List<SizeObject> size=new ArrayList<SizeObject>();
						size=s.getSizes();
						%>
						<label>Size:&nbsp</label>
						<Select id=<%= "size_"+c.getId() %> name="size">
							<% 
								for(SizeObject sz:size){
							%>
						<option value=<%= sz.getMeasure() %>><%= sz.getMeasure() %></option>
   
							<% 	
								}

								%>
							
						 </Select>
						 
						 <br><br>
						 <label>Quantity:&nbsp</label>
						 <Select id=<%= "qty_"+c.getId() %>>
						 <option value=1>1</option>
						 <option value=2>2</option>
						 <option value=3>3</option>
						 <option value=4>4</option>
						 <option value=5>5</option>
						 </Select>
  						
 				 	</div>
  					<div class="card-footer">
  					<div class="d-grid gap-2">
  						<button class="btn btn-secondary custom-bg text-black" onclick="add_to_cart(<%= c.getId() %>,'<%= c.getName() %>',<%= c.getPrice() %>)">Add to Cart</button>
 					 </div></div>
				</div>

				<% 	
				}}
				%>

			</div>
		</div>
	</div>
</div>

</div>

	

      <%@include file="Cart.jsp" %>

</body>
</html>