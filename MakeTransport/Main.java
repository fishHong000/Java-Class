// �Ǹ��G108213010 �m�W�G�xޱ��
import java.util.Scanner;
abstract class Transportation {
    String number;
    String trademark;
    String color;
    public abstract void move();
// �����O
}

// 3 �ب����l���O

class Ambulance extends Transportation {
    public void move() {
        System.out.println("I" + " drive" + " Ambulance " + this.number+" "+this.trademark+" "+this.color+"");
    }
    public Ambulance(String a ,String b ,String c){
        this.number = a;
        this.trademark = b;
        this.color = c;
    }        
}

class Motorcycle extends Transportation {
    public void move() {
        System.out.println("I" + " ride" + " Motorcycle " + this.number+" "+this.trademark+" "+this.color+"");
    }
    public Motorcycle(String a ,String b ,String c){
        this.number = a;
        this.trademark = b;
        this.color = c;
    }        
}

class Bike extends Transportation {
    public void move() {
        System.out.println("I" + " ride" + " Bike " + this.number+" "+this.trademark+" "+this.color+"");
    }
    public Bike(String a ,String b, String c){
        this.number = a;
        this.trademark = b;
        this.color = c;
    }        
}

public class Main {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        Ambulance good = new Ambulance(input.next(), input.next(), input.next());
        good.move();
        Motorcycle nice = new Motorcycle(input.next(), input.next(), input.next());
        nice.move();
        Bike great = new Bike(input.next(), input.next(), input.next());
        great.move();
// main function
    }
}