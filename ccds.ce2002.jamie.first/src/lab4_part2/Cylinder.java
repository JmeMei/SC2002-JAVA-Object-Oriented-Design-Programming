package lab4_part2;

public class Cylinder {
	private Circle circle;
	private Rectangle rectangle;
	
	public Cylinder() {
		circle = new Circle();
		rectangle = new Rectangle();
	}
	
	public Cylinder(Circle circle, Rectangle rectangle) {
		this.circle = circle;
		this.rectangle = rectangle;
	}
	
	public Circle getCircle() { //overriding??
		return circle;
	}
	
	public Rectangle getRectangle(){
		return rectangle;
	}
	
	public double findArea() {
		return 2*circle.findArea() + (2 * Math.PI * circle.getRadius() * rectangle.getLength());
	}
}
