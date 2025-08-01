// TestShape.java
public class TestShape {
    public static void main(String[] argv) {
        // reference of type super class can point to sub class object
        // we call this concept 'polymorphism' ¦h§Î
        Shape[] all = new Shape[]{new Circle(3), new Triangle(3,4,5)};
        System.out.println(Shape.sum(all));
    }
}