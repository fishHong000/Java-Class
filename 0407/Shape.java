// Shape.java
// abstract class is a kind of class that can't be new
// Shape is defined as a super class(parent class)
public abstract class Shape {
    // an abstract method, ask subclass to implement it
    public abstract double area();
    public static double sum(Shape[] list) {
        double sum = 0;
        for (int i = 0; i < list.length; i++) {
            // �аݦ��B��area()���ӥν֪�? super class? sub class?
            // �|�������D�O�]��, list�ŧi�����A�OShape
            // ��java ���\ 'polymorpism', �ҥHlist�|�ѦҨ�Cirlc or Triangle
            // �Y���y���I�ssub class(��ڪ��󪺫��A)����k, �h�٬�virtual function
            // �Y���y���I�ssuper class(�ݧi�ܼƪ����A)����k, �h�٬�non virtual function
            // java�u��virtual function
            // C++��س���,�g�{����programmer�n�i�Dcompiler�έ��@��
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
    private float a,b,c; // �T�����
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
