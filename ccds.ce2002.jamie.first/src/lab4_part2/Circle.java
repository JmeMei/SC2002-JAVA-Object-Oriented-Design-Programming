package lab4_part2;

public class Circle {
	private double radius;
	
	public Circle() {
		this.radius = 0;
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double findArea() {
		return Math.PI * radius * radius;
	}
}
