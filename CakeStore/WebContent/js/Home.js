/**
 * 
 */
function add_to_cart(cid,cname,price){
	
	let size=document.getElementById("size_"+cid);
	var selectedValue_size = size.value;
	
	let qty=document.getElementById("qty_"+cid);
	var selectedValue_qty = Number(qty.value);
	let cart=localStorage.getItem("cart");
	if(cart==null){
		
		let products=[];
		let cake={cakeId:cid,cakeName:cname,cakeQty:selectedValue_qty,cakePrice:price,cakeSize:selectedValue_size,cakemsg:""};
		products.push(cake);
		localStorage.setItem("cart",JSON.stringify(products));
		toastFunction("Item added to cart");
	}
	else{
		
		let pcart=JSON.parse(cart);
		
		let cakeExists = pcart.find((item)=> item.cakeId == cid)
		
		if(cakeExists){
			
			cakeExists.cakeQty = selectedValue_qty;
			pcart.map((item) => {
				if(item.cakeId == cakeExists.cakeId)
				
				{
					item.cakeQty=cakeExists.cakeQty;
				}
			})
			localStorage.setItem("cart",JSON.stringify(pcart));
			toastFunction("product quantity increased");

		}
		else{
			
			let cake={cakeId:cid,cakeName:cname,cakeQty:selectedValue_qty,cakePrice:price,cakeSize:selectedValue_size,cakemsg:""};
			pcart.push(cake);
		    localStorage.setItem("cart",JSON.stringify(pcart));
			toastFunction("Item added to cart");
			
			
		}
		
	}
	
	
	
	updateCart()
	
	
}

function updateCart(){
	
	let cartString=localStorage.getItem("cart");
	let cart=JSON.parse(cartString);
	if(cart==null || cart.length==0){
		console.log("cart is empty");
		$(".cart-items").html("(0)");
		$(".cart-body").html("<h5>no items in your cart</h5>");
		$(".checkout-btn").attr('disabled',true);
		
	}
	else{
		console.log(cart);
		$(".cart-items").html(`(${cart.length})`);
		let table=`
		<table class='table'>
		<thead class='thread-light'>
		<tr>
		<th>Cake Name</th>
		<th>Quantity</th>
		<th>Size</th>
		<th>Price</th>
		<th>Total Price</th>
		</tr>
		
		</thead>
		
		`;
		
		let totalPrice=0;
		
		cart.map((item) =>{
			
	    	table += `
			
			<tr>
			<td> ${item.cakeName} </td>
			<td> <button onclick='IncreasQtyInCart(${item.cakeId})' class="btn btn-light btn-sm text-black">+</button>&nbsp${item.cakeQty}&nbsp 
			<button onclick='deleteItemFromCart(${item.cakeId})' class="btn btn-light btn-sm text-black">-</button></td>
			<td>${item.cakeSize} inches</td>
			<td>$ ${item.cakePrice}</td>
			<td>$ ${item.cakePrice * item.cakeQty}</td>
			<td>&nbsp&nbsp
			</tr>
			
			`;
			
			totalPrice += item.cakePrice * item.cakeQty;
			
		});
		
		table=table+`
		<tr><td colspan='5' style="text-align:right;">Total: $ ${totalPrice}</td></tr>
		
		</table>`
		$(".cart-body").html(table);
		
	}
	
	$(".checkout-btn").attr('disabled',false);
	
	
}


function deleteItemFromCart(cid){
	
	
	console.log("remove function");
	    let cart=localStorage.getItem("cart");
	
	    let pcart=JSON.parse(cart);
		
		let cakeExists = pcart.find((item)=> item.cakeId == cid)
		
		if(cakeExists.cakeQty>1){
			
			cakeExists.cakeQty = cakeExists.cakeQty - 1;
			pcart.map((item) => {
				if(item.cakeId == cakeExists.cakeId)
				
				{
					item.cakeQty=cakeExists.cakeQty;
				}
			})
			localStorage.setItem("cart",JSON.stringify(pcart));
		}
		else{
			
				let cart=JSON.parse(localStorage.getItem('cart'));
				let newCart=cart.filter((item)=> item.cakeId != cid)
				localStorage.setItem('cart',JSON.stringify(newCart));
				
		}
	
	updateCart();
}


function IncreasQtyInCart(cid){
	
	
	console.log("add function");
	    let cart=localStorage.getItem("cart");
	
	    let pcart=JSON.parse(cart);
		
		let cakeExists = pcart.find((item)=> item.cakeId == cid)
		
		if(cakeExists.cakeQty>0 && cakeExists.cakeQty<5){
			
			cakeExists.cakeQty = cakeExists.cakeQty + 1;
			pcart.map((item) => {
				if(item.cakeId == cakeExists.cakeId)
				
				{
					item.cakeQty=cakeExists.cakeQty;
				}
			})
			localStorage.setItem("cart",JSON.stringify(pcart));
		}
		else{
			
				alert('Maximum Quantity is 5');
				
		}
	
	updateCart();
}


function gotoCheckout(){
	
	window.location="Checkout.jsp"
		
	
}
	
function placeOrder(){
	
	let email = document.getElementById("email").value;
	let name = document.getElementById("name").value;
	let phone = document.getElementById("phone").value;
	let date = document.getElementById("date").value;
	let address = document.getElementById("address").value;
	let order={email:email,name:name,phone:phone,d_date:date,address:address};
	localStorage.setItem("order",JSON.stringify(order));
 	
	
	$.ajax({
  method: "POST",
  url: "HomeServlet",
  data: { cart: localStorage.getItem("cart") , order: localStorage.getItem("order") }
})
  .done(function( msg ) {
	toastFunction('Order Placed');
	localStorage.clear();
  });

}



$(document).ready(function(){
	
	updateCart()
	
})




function func1(){
	
	let cartString=localStorage.getItem("cart");
	let cart=JSON.parse(cartString);
	
	let table=`
		<table class='table'>
		<thead class='thread-light'>
		<tr>
		<th>Cake Name</th>
		<th>Quantity</th>
		<th>Size</th>
		<th>Message</th>
		<th>Price</th>
		<th>Total Price</th>
		</tr>
		
		</thead>
		
		`;
		
		let totalPrice=0;
		
		cart.map((item) =>{
			
	    	table += `
			
			<tr>
			<td> ${item.cakeName} </td>
			<td> ${item.cakeQty}</td>
			<td>${item.cakeSize} inches</td>
			<td><input type="text" name="message" id="msg_${item.cakeId}"><button onclick="saveMsg(${item.cakeId})">save</button></td>
			<td>$ ${item.cakePrice}</td>
			<td>$ ${item.cakePrice * item.cakeQty}</td>
			<td>&nbsp&nbsp
			</tr>
			
			`;
			
			totalPrice += item.cakePrice * item.cakeQty;
			
		});
		
		table=table+`
		<tr><td colspan='6' style="text-align:right;">Total: $ ${totalPrice}</td></tr>
		
		</table>`
		$(".checkout-cart-body").html(table);
		
	}
	
	
function saveMsg(id){
	
	 let cart=localStorage.getItem("cart");
	
	    let pcart=JSON.parse(cart);
		console.log(id);
		
		let cakeExists = pcart.find((item)=> item.cakeId == id)
		
		
		if(cakeExists){
			console.log(cakeExists);
			
			cakeExists.cakemsg = document.getElementById("msg_"+id).value;
			pcart.map((item) => {
				if(item.cakeId == cakeExists.cakeId)
				
				{
					item.cakemsg=cakeExists.cakemsg;
				}
			})
			localStorage.setItem("cart",JSON.stringify(pcart));
		}
		console.log(cart);
	
}


function toastFunction(content) {
	
	
	 var x = document.getElementById("toast");
  	x.className = "show";
	x.innerHTML = content;
  setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);


}
