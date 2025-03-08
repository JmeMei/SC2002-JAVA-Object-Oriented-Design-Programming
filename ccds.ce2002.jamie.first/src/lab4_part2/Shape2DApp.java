package lab4_part2;

import java.util.*;

public class Shape2DApp {
	public static void main(String[] args) {
		int numOfShapes = 0;
		int menuChoice;
		Scanner sc = new Scanner(System.in);
		Square square = new Square();
		Rectangle rectangle = new Rectangle();
		Triangle triangle = new Triangle();
		Circle circle = new Circle();
		
		System.out.println("<Shape 2D App>");
		
		do {
			printMenu();
			menuChoice = sc.nextInt();
			switch(menuChoice) {
			case 1:
				System.out.println("Enter the number of Shapes: ");
				numOfShapes = sc.nextInt();
				break;
			
			case 2: 
				for(int i = 0; i < numOfShapes; i++) {
					shapeMenu();
					int shapeChoice = sc.nextInt();
					
					switch(shapeChoice) {
					case 1:
						square = createSquare();
						break;
						
					case 2:
						rectangle = createRectangle();
						break;
						
					case 3:
						circle = createCircle();
						break;
						
					case 4:
						triangle = createTriangle();
						break;
					}
				}
				
			case 3: 
				double totalArea = 0;
				totalArea += square.findArea();
				totalArea += rectangle.findArea();
				totalArea += circle.findArea();
				totalArea += triangle.findArea();
				System.out.printf("The total area for this 2D figure is: %.2f\n\n", totalArea);
				break;
			}
		}while(menuChoice != 4);
		
	}
	
	public static void printMenu() {
		 System.out.println("-----------Menu-----------");
		 System.out.println("1. Enter the number of Shapes");
		 System.out.println("2. Choose Shapes");
		 System.out.println("3. Calculate Area");
		 System.out.println("4. Quit");
		 System.out.println("Enter your choice: ");
		 
	}
	
	public static void shapeMenu() {
		System.out.println("List of Shapes");
		System.out.println("1. Square");
		System.out.println("2. Rectangle");
        System.out.println("3. Circle");
        System.out.println("4. Triangle");
        System.out.println("Enter your choice: ");
	}
	
	public static Square createSquare() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the length of Square: ");
		double length = sc.nextDouble();
		return new Square(length); 
		//new keyword is used to create new objects from a class. This is required because 
		//objects in Java are dynamically allocated in memory at runtime.
	}
	
	public static Rectangle createRectangle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the length of Rectangle: ");
		double length = sc.nextDouble();
		System.out.print("Enter the breadth of Rectangle: ");
		double breadth = sc.nextDouble();
		return new Rectangle(length, breadth);
	}
	
	public static Circle createCircle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the radius of Circle: ");
		double radius = sc.nextDouble();
		return new Circle(radius);
	}
	
	public static Triangle createTriangle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the base of Triangle: ");
		double base = sc.nextDouble();
		System.out.print("Enter the height of Triangle: ");
		double height = sc.nextDouble();
		return new Triangle(base, height);
	}
}
