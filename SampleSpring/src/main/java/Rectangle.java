import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class Rectangle implements InitializingBean,DisposableBean {
private int len;
private int width;
private Circle cir;
private Triangle tr;
public Triangle getTr() {
	return tr;
}
@Autowired
public void setTr(Triangle tr) {
	this.tr = tr;
}
public Circle getCir() {
	return cir;
}
public void setCir(Circle cir) {
	this.cir = cir;
}
public int getLen() {
	return len;
}
public void setLen(int len) {
	this.len = len;
}
public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public void draw() {
	System.out.println("drawn rectangle with width "+this.width+" and length "+this.len);
	//System.out.println("circle with radius "+c.);
	cir.draw();
	tr.draw();
}
@Override
public void destroy() throws Exception {
	// TODO Auto-generated method stub
	System.out.println("Destroy method-Rectangle interface ");
	
}
@Override
public void afterPropertiesSet() throws Exception {
	// TODO Auto-generated method stub
	System.out.println("Init method-Rectangle interface");
	
}
public void myInit() {
	System.out.println("init method-rect");
}
public void myDest() {
	System.out.println("dest method-rect");
}
}
