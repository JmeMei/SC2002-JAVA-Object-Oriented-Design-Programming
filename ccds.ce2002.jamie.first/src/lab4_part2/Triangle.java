package lab4_part2;

public class Triangle implements Shape{
	private double base;
	private double height;
	
	public Triangle() {
		this.base = 0;
		this.height = 0;
	}
	
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	public double getBase() {
		return base;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double findArea() {
		return 0.5 * base * height;
	}
}
