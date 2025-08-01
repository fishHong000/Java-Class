class student(A,B) :
# python allow multi-inheritance

# but in Java, allow single inheritance
public class Round {
}
public class Round extends Object {
}
# 問題在於若允許多重繼承，又是virtual function下，會有這樣的問題發生
public class A{
    public void fun(){}
        System.out.println("A");
    }
}
public class B extends A{
    public void fun() {
        System.out.println("B");
    }
}
public class C extends A{
    public void fun() {    
        System.out.println("C");
    }
}
public class D extends B, C {
}
A x = new B(); // polymorphism
x.fun(); // call which?

A c = new C();
c.fun(); // call which?   

A x = new D();
x.fun(); // 出事了

interface A { // 可把interface當成 "沒有implementation" 的class
    double PI = 3.14; // 自動加上public final static修飾字
    void area(); // 自動加上public abstract修飾字
}    
A.PI = 0; //error, A.PI is final(不可改)
final class x { // class X can not be "extends"
}
class X {
    public final void fun() {} // fun can not be "overried"
}
class X {
    public static final v = 0; // v can not be "modified" except in declaration 
}    
public class Student {
    int 口袋裡的錢;
    static int 班上的錢;
}
Student x = new Student();
Student y = new Student();
x.口袋裡的錢 = 100;
y.口袋裡的錢 = 50;
Student.班上的錢 = 6000;
Student.口袋裡的錢 = 300; // complile error! 
// class and interface 怎麼用
public interface B{};
public interface C{};
public interface X extends B, C { // correct
}    
public class A extends Object implements B, C {
}
A x = new A();
System.out.println(x instanceof A);
System.out.println(x instanceof B);
System.out.println(x instanceof C);
System.out.println(x instanceof Object);

