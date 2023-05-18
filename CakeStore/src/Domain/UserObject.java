package Domain;

public class UserObject {
	
	private String name;
	private String email;
	private String address;
	private String phone;
	private String password;
	
	public UserObject(){
						
		
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public void setEmail(String email) {
		this.email=email;

	}
	public void setAddress(String address) {
		this.address=address;

	}
	public void setPhone(String phone) {
		this.phone=phone;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	
	
	
	public String getName() {
		return this.name;
		
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getPassword() {
		return this.password;
	}

}
