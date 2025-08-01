import java.util.Scanner;
public class Triangle {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int a, b, c;
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        int tmp;
        if (a > b) {
            tmp = b;
            b = a;
            a = tmp;
        }        
        if (a > c) {
            tmp = c;
            c = a;
            a = tmp;
        }   
        if (b > c) {
            tmp = c;
            c = b;
            b = tmp;
        }        
     
        System.out.println(a+" "+b+" "+c);
        if ( a*a + b*b == c*c ) {
            System.out.println("Right");
        } else if (a*a + b*b > c*c ) {
            System.out.println("Acute");
        } else if (a*a + b*b < c*c) {
            System.out.println("Obtuse");
        } else {
            System.out.println("No");
        }
    }
}