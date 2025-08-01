import java.util.Scanner;
/* 還記的回文嗎?
   1234321
   如果某數x不是迴文, 則計算x + x反轉數, 直到找到迴文為止
   給數x, 請問要做幾次加法?*/
public class marchthird {
    // 12345 ==> 54321 how?
    // x: 12345 1234 123 12 1
    // y: 0     5    54  543 54321
    public static long reverse(long x) {
        long y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y;
    }
    public static int countAdd(long x) {
        int count = 0; // 記錄加了幾次
        while (x != reverse(x)) {
            x = x + reverse(x);
            count = count + 1;
        }
        return count;
    }
    public static double[] cal(int[] data, int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + data[i];
        }
        double avg = sum / n;
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + (data[i]-avg)*(data[i]-avg);
        }
        double stddev = Math.sqrt(sum/n);
        return new double[]{avg,stddev};
    }
    public static void main(String[] agrv) {
        Scanner input = new Scanner(System.in);
        int[] data; // data is a reference to array of int
        int n = input.nextInt();
        data = new int[n]; // create an array object
        for (int i = 0; i < n; i++) {
            data[i] = input.nextInt();
        }
        double[] rel = cal(data, n);
        System.out.println("avg="+rel[0]+",stddev="+rel[1]);
    }
}
// x = float(input()) // py
// Scanner input = new Scanner(System.in);
// float x = input.nextFloat();