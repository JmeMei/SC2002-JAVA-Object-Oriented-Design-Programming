package lab4_part2;

public class Cuboid {
	private Rectangle rectangle;
	
	public Cuboid() {
		rectangle = new Rectangle();
	}
	
	public Cuboid(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public double findArea() {
		return 4 * rectangle.findArea() + 2 * rectangle.getBreadth() * rectangle.getBreadth();
	}
}
