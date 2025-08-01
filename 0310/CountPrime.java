import java.util.Scanner;
public class CountPrime {
    // how many primes <= n
    public static int primes(int n) {
        // for each num between 2~n
        //    test if num is a prime
        //        true: counter + 1
        int counter = 0;
        for (int num = 2; num <= n; num++) {
            if (isPrime(num)) {
                counter++;
            }
        }
        return counter;    
    }
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
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in) ;
        int x = input.nextInt() ;
        System.out.println(primes(x)) ;
    }
}        