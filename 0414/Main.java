class student(A,B) :
# python allow multi-inheritance

# but in Java, allow single inheritance
public class Round {
}
public class Round extends Object {
}
# ���D�b��Y���\�h���~�ӡA�S�Ovirtual function�U�A�|���o�˪����D�o��
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
x.fun(); // �X�ƤF

interface A { // �i��interface�� "�S��implementation" ��class
    double PI = 3.14; // �۰ʥ[�Wpublic final static�׹��r
    void area(); // �۰ʥ[�Wpublic abstract�׹��r
}    
A.PI = 0; //error, A.PI is final(���i��)
final class x { // class X can not be "extends"
}
class X {
    public final void fun() {} // fun can not be "overried"
}
class X {
    public static final v = 0; // v can not be "modified" except in declaration 
}    
public class Student {
    int �f�U�̪���;
    static int �Z�W����;
}
Student x = new Student();
Student y = new Student();
x.�f�U�̪��� = 100;
y.�f�U�̪��� = 50;
Student.�Z�W���� = 6000;
Student.�f�U�̪��� = 300; // complile error! 
// class and interface ����
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

