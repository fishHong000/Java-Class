public class Hello {
    public static void main(String[] argv) {
        // System.out.println("Hello World");
        // x 是 "容器"
        // java 的資料型態有
        byte, short, int, long, boolean, char, float, double
        // 再加上 "reference"
        int x; // declaration, 宣告
        x = 1;
        String s; // s is a "reference" to String object
    }
} 

import java.util.Scanner;
public class Hello {
    public static void main(String[] argv) {
        // 相同型態的資料才能一起做運算，結果也是相同型態
        System.out.println(2/4);
        System.out.println(2/4.0);
        // 1+2+...+n = n*(n+1)/2
        int n = 9;
        System.out.println(n/2*(n+1));
        /*
        Scanner input = new Scanner(System.in);
        int a, b, c;
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        int tmp;
        // a,b = b,a
        System.out.println(a+" "+b+" "+c); //String concatinate
        */
    }
} 

import java.util.Scanner;
public class Hello {
    public static void main(String[] argv) {
        // 相同型態的資料才能一起做運算，結果也是相同型態 
        int n = 18;
        if (n < 18) {
            System.out.println("child");
        } else if (n>=50) {
            System.out.println("old man");
        } else {        
            System.out.println("adult");
        }
    }
}
   