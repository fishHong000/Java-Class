// Shape.java
// abstract class is a kind of class that can't be new
// Shape is defined as a super class(parent class)
public abstract class Shape {
    // an abstract method, ask subclass to implement it
    public abstract double area();
    public static double sum(Shape[] list) {
        double sum = 0;
        for (int i = 0; i < list.length; i++) {
            // 請問此處的area()應該用誰的? super class? sub class?
            // 會有此問題是因為, list宣告的型態是Shape
            // 但java 允許 'polymorpism', 所以list會參考到Cirlc or Triangle
            // 若此語言呼叫sub class(實際物件的型態)的方法, 則稱為virtual function
            // 若此語言呼叫super class(需告變數的型態)的方法, 則稱為non virtual function
            // java只有virtual function
            // C++兩種都有,寫程式時programmer要告訴compiler用哪一種
            sum = sum + list[i].area();
        }
        return sum;
    }
}

// Circle.java
public class Circle extends Shape {
    private float radius;
    public Circle(float r) {
        this.radius = r;
    }
    // redefine area in Shape, this is called 'override'
    public double area() {
        System.out.println("using area in Circle");
        return 3.14149*radius*radius;
    }
}

// Triangle.java
public class Triangle extends Shape {
    private float a,b,c; // 三個邊長
    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    // override method area in Shape
    public double area() {
        System.out.println("using area in Triangle");
        float s = (a+b+c) / 2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}
