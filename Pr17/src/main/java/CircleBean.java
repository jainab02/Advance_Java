import javax.faces.bean.ManagedBean;

@ManagedBean
public class CircleBean {
	private double radius;
	private double area;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return area;
	}

	public void calculateArea() {
		area = Math.PI * radius * radius;
	}
}
