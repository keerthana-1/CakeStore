package Domain;

public class FlavorObject {
	
	private int id;
	
	private String name;
	
	public FlavorObject() {
		
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setFlavor(String name) {
		this.name=name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getFlavor() {
		return this.name;
	}

}
