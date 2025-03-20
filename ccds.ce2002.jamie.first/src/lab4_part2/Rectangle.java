package lab4_part2;

public class Rectangle implements Shape{
	private double length;
	private double breadth;
	
	public Rectangle() {
		this.length = 0;
		this.breadth = 0;
	}
	
	public Rectangle(double length, double breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getBreadth() {
		return breadth;
	}
	
	public double findArea() {
		return this.length * this.breadth;
	}
}
