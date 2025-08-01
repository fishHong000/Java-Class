import java.util.Scanner;
public class loopC {
    public static boolean isPrime(int x) {
        if(x <= 1) {
            return false;
        }
        if(x == 2) {
            return true;
        }
        if(x % 2 == 0) {
            return false;
        }
        int times = 3 ;
        while (time < x) {
            if (x % times == 0) {
                return false ;
            }
            times = times + 2 ;
        }
        return true ;
    }
    public static int countPrime(int begin , int end) {
        int x = begin ;
        int count = 0 ;
        while (x <= end) {
            if (isPrime(x)) {
                count = count + 1 ;
            }
            x = x + 1 ;
        }
        return count ;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in) ;
        int[] data ;
        int begin = input.nextInt() ;
        int end = input.nextInt() ;
        System.out.println(countPrime(begin , end)) ;
    }
}        