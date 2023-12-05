import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Circle {
	private int radius;
	private List<Integer> center;
	@Autowired
	private Triangle tr;
	public Triangle getTr() {
		return tr;
	}
	
	public void setTr(Triangle tr) {
		this.tr = tr;
	}
	public List<Integer> getCenter() {
		return center;
	}
	public void setCenter(List<Integer> center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public void draw() {
		System.out.print("drawn circle with radius "+radius+" with center ");
		for(int l:center)
		System.out.print(l+" ");
		System.out.println();
		System.out.println(tr.getType()+" Triangle drawn in circle with lenght "+tr.getLen());
	}

}
