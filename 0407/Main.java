abstract class animal {
    int foot;
    int ear;
    int eye;
    String color;
    public abstract void move();
}

class Dog extends animal {
    protected String name = "lucky";
    public void move() {
        System.out.println(this.name + " run with " + this.foot + "feet");
    }    
    public Dog(int i) {
        this.foot = i;
        this.ear = 2;
        this.eye = 2;
        this.color = "Blue";
    }    
    public Dog() {
        this.foot = 4;
        this.ear = 2;
        this.eye = 2;
        this.color = "Blue";    
    }
}

class FlyDog extends Dog {
    // override
    // super ©I¥s¤÷Ãþ§O
    public void move() {
        // super.move();
        System.out.println(this.name + " run with " + this.foot + "feet, then amazingly fly");
    }    
    public FlyDog() {
        super(9); 
    }
}
class Flycow extends animal {
    // override
    public void move() {
        System.out.println("run with " + this.foot + "feet, then fly");
    }    
    public Flycow() {
        this.foot = 4;
        this.ear = 2;
        this.eye = 2;
        this.color = "Green";
    }
}

public class Main {
    public static void main(String[] argv) {
        Dog lucky = new Dog();
        lucky.move();
        Flycow farm = new Flycow();
        farm.move();
        FlyDog goofy = new FlyDog();
        goofy.move();
    }
}    