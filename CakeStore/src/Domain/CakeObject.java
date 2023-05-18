package Domain;

public class CakeObject {

	private int id;
	private String name;
	private String imgpath;
	private int flavor_id;
	private int occasion_id;
	private int price;
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setImgPath(String imgpath) {
		this.imgpath=imgpath;
	}
	
	public void setFlavorId(int flavor_id) {
		this.flavor_id=flavor_id;
	}
	
	public void setOccasionId(int occasion_id) {
		this.occasion_id=occasion_id;
	}
	
	public void setPrice(int price) {
		this.price=price;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getImgPath() {
		return this.imgpath;
	}
	
	public int getFlavorId() {
		return this.flavor_id;
	}
	
	public int getOccasionId() {
		return this.occasion_id;
	}
	
	public int getPrice() {
		return this.price;
	}
	
}
