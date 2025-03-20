package lab4_part2;

public class Sphere implements Shape{
	private Circle circle;
	
	public Sphere() {
		circle = new Circle();
	}
	
	public Sphere(Circle circle) {
		this.circle = circle;
	}
	
	public Circle getCircle() {
		return circle;
	}
	
	public double findArea() {
		return 4 * this.circle.findArea();
	}
}
