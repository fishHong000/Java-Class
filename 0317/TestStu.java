public class TestStu {
    public static void main(String[] argv) {
        Student a = new Student("©n©n");
        Student b = new Student("¬R´@");
        a.sayHello();
        System.out.println(b.whoAreYou());
        System.out.println(Student.bornStu+"students have been created");  
        a.name = "¦n©n©n";    
    }
}  
// in java, there are 4 kinds of scope modify (for class)
// that is, "public" "protected" "package" and "private"         
class Student {
    private String name;
    public static int bornStu = 0;
    // define a constructor, the syntax has no return value
    // and function name must be the same with class name
    public Student(String name) {
        this.name = name;
        bornStu++;
    }
    public void sayHello(){
        System.out.println("hello,I am" + name);
    }
    public String whoAreYou(){
        return name;
    }
}    