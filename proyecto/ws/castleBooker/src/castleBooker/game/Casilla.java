package castleBooker.game;

public class Casilla {

	 private String type;
	 private String img;
	 
	 
	 
	 public Casilla(String type,String img) {
		 setType(type);
		 setImg(img);
	 }
	 
	 
	public String getType() {
		return type;
	}
	public String getImg() {
		return img;
	}
	private void setType(String type) {
		this.type = type;
	}
	private void setImg(String img) {
		this.img = img+".png";
	}
	 
	@Override
	public String toString() {
		return getType();
	}
	 
	
	
}
