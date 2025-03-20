package lab4_part2;

public class Cone implements Shape{
	private Circle circle;
	private Triangle triangle;
	
	public Cone() {
		circle = new Circle();
		triangle = new Triangle();
	}
	
	public Cone(Circle circle, Triangle triangle) {
		this.circle = circle;
		this.triangle = triangle;
	}
	
	public Circle getCircle() {
		return circle;
	}
	
	public Triangle getTriangle() {
		return triangle;
	}
	
	public double findArea() {
		double slantHeight = Math.sqrt(triangle.getHeight() * triangle.getHeight() + circle.getRadius() * circle.getRadius());
		return Math.PI * circle.getRadius() * (circle.getRadius() + slantHeight);
	}
}
