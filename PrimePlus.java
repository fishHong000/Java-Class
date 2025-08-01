import java.util.Scanner;
// 遞迴
// 找出小於等於n的所有質數
// 從中找出哪些數字加起來等於n
// 印出所有組合
public class PrimePlus {
    public static void main(String[] argv){
        // 輸入整數 n
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        // 有幾個質數(sum個)
        int sum = 0;
        for(int i = 0; i <= n; i++){
            if (isPrime(n)){
                sum = sum + 1;
            }
        }
    }
    public static void find(int sum, ){
        if (sum == 0){
            System.out.println(result);
            return;
        }
    }
    public static int[] append(int[] primes, int i){
        int[] tmp = new int[];
        for(int j = 0; j < primes.length; j++){
            tmp[j] = primes[j];
        }
        tmp[tmp.length-1] = i;
        return tmp;
    }
    public static boolean isPrime(int n) {
        // 判斷質數
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        int count = 3;
        while( count < n) {
            if (n % count == 0) {
                return false;
            }
            count = count + 2;
        }
        return true;
    }
}