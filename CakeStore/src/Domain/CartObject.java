package Domain;

public class CartObject {

	private int cakeId;
	private String cakeName;
	private int cakeQty;
	private String cakeSize;
	private int cakePrice;
	private String cakemsg;
	
	public void setName(String name) {
		this.cakeName=name;
	}
	
	public String getName() {
		return this.cakeName;
	}
	
	public void setId(int id) {
		this.cakeId=id;
	}
	
	public int getId() {
		return this.cakeId;
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
}
