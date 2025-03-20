package lab4_part2;

public class Square implements Shape{
	private double length;
	
	public Square() {
		this.length = 0;
	}
	
	public Square(double length) {
		this.length = length;
	}
	
	public double getLength() {
		return length;
	}
	
	public double findArea() {
		return length * length;
	}
}
