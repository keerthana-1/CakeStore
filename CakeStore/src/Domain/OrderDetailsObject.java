package Domain;

public class OrderDetailsObject {
	
	private String email;
	private String d_date;
	private String address;
	private String phone;
	private int order_id;
	private String cakeName;
	private int cakeQty;
	private String cakeSize;
	private int cakePrice;
	private String cakemsg;
	
	public void setOrderId(int order_id) {
		this.order_id=order_id;
	}
	
	public void setEmail(String email) {
		
		this.email=email;
	}

	public void setPhone(String phone) {
	this.phone = phone;
	}

	public void setDate(String date) {
	this.d_date=date;
	}

public void setAddress(String address) {
	this.address=address;
}

public void setName(String name) {
	this.cakeName=name;
}

public String getName() {
	return this.cakeName;
}

public void setQty(int qty) {
	this.cakeQty=qty;
}

public int getQty() {
	return this.cakeQty;
}

public void setPrice(int price) {
	this.cakePrice=price;
}

public int getPrice() {
	return this.cakePrice;
}

public void setSize(String size) {
	this.cakeSize=size;
}

public String getSize() {
	return this.cakeSize;
}

public void setMsg(String msg) {
	this.cakemsg=msg;
}

public String getMsg() {
	return this.cakemsg;
}

public int getOrderId() {
	return this.order_id;
}

public String getEmail() {
	return this.email;
}

public String getPhone() {
	return this.phone;
}

public String getDate() {
	return this.d_date;
}

public String getAddress() {
	return this.address;
}

	

}
