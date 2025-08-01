/* 輸入兩整數 start end
   求出兩整數之間(含兩整數)質數的數量
   Ex:
   input : 2 10 
   output : 4 */
import java.util.Scanner;
public class marchthird2 {
    public static boolean isPrime(int i) {
        // 判斷質數
        if (i <= 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        if (i % 2 == 0) {
            return false;
        }
        int count = 3;
        while(count<i) {
            if (i%count==0) {
                return false;
            }
            count = count + 2;
        }
        return true;
    }
    public static void main(String[] agrv) {
        Scanner input = new Scanner(System.in);
        // 輸入數字
        int x = input.nextInt();
        int y = input.nextInt();
        // 呼叫判斷質數的函數
        int sum = 0;
        for (int i = x; i<=y; i++) {
            if (isPrime(i)) {
                sum = sum + 1;
            }
        }
        System.out.println(sum);
    }
}