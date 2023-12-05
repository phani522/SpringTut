
public class Triangle {
	private String type;
	public String getType() {
		return type;
	}

	public int getLen() {
		return len;
	}

	private int len;
	public Triangle(String type, int len) {
		super();
		this.type = type;
		this.len = len;
	}
	
public void draw() {
	System.out.println(type+" traingle drawn with length "+len);
}
}
