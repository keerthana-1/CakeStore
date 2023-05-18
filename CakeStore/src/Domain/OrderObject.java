package Domain;

import java.sql.Date;

public class OrderObject {

	private String email;
	private String name;
	private String phone;
	private String d_date;
	private String address;
	private int order_id;
	private int cart_id;
	
	
	public void setOrderId(int order_id) {
		this.order_id=order_id;
	}
	
	
	
	public void setCartId(int cart_id) {
		this.cart_id=cart_id;
	}
	
	
	
	public void setEmail(String email) {
		
		this.email=email;
	}
	
	public void setName(String name) {
		this.name=name;
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
	
	
	public int getOrderId() {
		return this.order_id;
	}
	
	
	
	public int getCartId() {
		return this.cart_id;
	}
	
	
	
	public String getEmail() {
		return this.email;
	}
	
	public String getName() {
		return this.name;
		
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
