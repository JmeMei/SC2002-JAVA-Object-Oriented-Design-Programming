package lab4_part2;

import java.util.Scanner;

public class Shape3DApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numOfShapes = 0;
		int menuChoice;
		Scanner sc = new Scanner(System.in);
		Cube cube = new Cube();
		Cuboid cuboid = new Cuboid();
		Sphere sphere = new Sphere();
		Pyramid pyramid = new Pyramid();
		Cone cone = new Cone();
		Cylinder cylinder = new Cylinder();
		
		
		System.out.println("<Shape 3D App>");
		do {
			printMenu();
			menuChoice = sc.nextInt();
			switch(menuChoice) {
			case 1:
				System.out.println("Enter the number of Shapes: ");
				numOfShapes = sc.nextInt();
				break;
				
			case 2: 
				for(int i=0; i<numOfShapes; i++) {
					shapeMenu();
					int shapeChoice = sc.nextInt();
					
					switch(shapeChoice) {
					case 1:
						Square square = createSquare();
						cube = new Cube(square);
						break;
						
					case 2:
						Rectangle rectangle = createRectangle();
						cuboid = new Cuboid(rectangle);
						break;
						
					case 3:
						Circle circle = createCircle();
						sphere = new Sphere(circle);
						break;
						
					case 4:
						Triangle triangle = createTriangle();
						pyramid = new Pyramid(triangle);
						break;
					
					case 5:
						Circle circle2 = createCircle();
						Triangle triangle2 = createTriangle();
						cone = new Cone(circle2, triangle2);
						break;
						
					case 6:
						Circle circle3 = createCircle();
						Rectangle rectangle2 = createRectangle();
						cylinder = new Cylinder(circle3, rectangle2);
						break;
					}
				}
				break;
				
			case 3: 
				double totalArea = 0;
				totalArea += cube.findArea();
				totalArea += cuboid.findArea();
				totalArea += sphere.findArea();
				totalArea += pyramid.findArea();
				totalArea += cone.findArea();
				totalArea += cylinder.findArea();
				
				//remove double counting of the square base when stacked together
				if (pyramid.findArea() != 0 && cuboid.findArea() != 0)
                    totalArea -= cuboid.getRectangle().getBreadth() * cuboid.getRectangle().getBreadth();
				//remove double counting of circle base when stacked together
                if (cone.findArea() != 0 && cylinder.findArea() != 0)
                    totalArea -= cone.getCircle().findArea();
                
				System.out.printf("The total area for this 3D figure is: %.2f\n\n", totalArea);
				break;
			}
				
			}while(menuChoice !=4);
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
		System.out.println("1. Cube (Square)");
		System.out.println("2. Cuboid (Rectangle)");
        System.out.println("3. Sphere (Circle)");
        System.out.println("4. Pyramid (Triangle)");
        System.out.println("5. Cone (Circle + Triangle)");
        System.out.println("6. Cylinder (Circle + Rectangle)");
        System.out.println("Enter your choice: ");
	}
	
	public static Square createSquare() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the length of Square: ");
		double length = sc.nextDouble();
		return new Square(length);
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
