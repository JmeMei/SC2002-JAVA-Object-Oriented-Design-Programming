package lab4_part2;

public class Pyramid implements Shape{
	private Triangle triangle;
	
	public Pyramid() {
		triangle = new Triangle();
	}
	
	public Pyramid(Triangle triangle) {
		this.triangle = triangle;
	}
	
	public Triangle getTriangle() {
		return triangle;
	}
	
	public double findArea() {
		return triangle.findArea() + triangle.getBase() * triangle.getBase();
	}
}
