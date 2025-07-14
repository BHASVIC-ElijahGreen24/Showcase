public class Shape {
	private StringToNumber strToNum = new StringToNumber();
	private String type; // for sanity
	private double perimeter;
	private double area;

	// circle int
	Shape(int radius) {
		this.type = "circle";
		this.perimeter = 2 * Math.PI * radius;
		this.area = Math.PI * Math.pow(radius, 2);
	}

	// rectangle int
	Shape(int side1, int side2) {
		this.type = "rectangle";
		this.perimeter = 2 * (side1 + side2);
		this.area = side1 * side2;
	}

	// triangle int
	Shape(int side1, int side2, int side3) {
		this.type = "triangle";
		this.perimeter = side1 + side2 + side3;
		this.area = Math.pow(this.perimeter/2 * (this.perimeter/2-side1) * (this.perimeter/2-side2) * (this.perimeter/2-side3), 0.5);
	}

	// circle string
	Shape(String s_radius) {
		this.type = "circle";
		int radius = strToNum.convert(s_radius);
		this.perimeter = 2 * Math.PI * radius;
		this.area = Math.PI * Math.pow(radius, 2);
	}

	// rectangle string
	Shape(String s_side1, String s_side2) {
		this.type = "rectangle";
		int side1 = strToNum.convert(s_side1);
		int side2 = strToNum.convert(s_side2);
		this.perimeter = 2 * (side1 + side2);
		this.area = side1 * side2;
	}

	// triangle string
	Shape(String s_side1, String s_side2, String s_side3) {
		this.type = "triangle";
		int side1 = strToNum.convert(s_side1);
		int side2 = strToNum.convert(s_side2);
		int side3 = strToNum.convert(s_side3);
		this.perimeter = side1 + side2 + side3;
		this.area = Math.pow(this.perimeter/2 * (this.perimeter/2-side1) * (this.perimeter/2-side2) * (this.perimeter/2-side3), 0.5);
	}

	public void perimeter() {
		System.out.println("This " + this.type + " has a perimeter of " + this.perimeter);
	}

	public void area() {
		System.out.println("This " + this.type + " has an area of " + this.area);
	}
}