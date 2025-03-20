package lab4_part2;

public class Cube implements Shape{
private Square square; //not a subclass of square but it has a composition relationship
//cube has sides of square
	
	public Cube() {
		square = new Square();
	}
	
	public Cube(Square square) {
		this.square = square;
	}
	
	public Square getSquare() {
		return this.square;
	}
	
	public double findArea() {
		return 6 * this.square.findArea();
	}
}
