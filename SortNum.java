import java.util.Scanner;
public class SortNum {
    // 抓出來一個一個數字
    public static int[] take(int n) {
        int index = 0;
        int[] num = new int[5];
        while (n >= 0) {
            num[index] = n%10;
            index += 1;
        }
        return num;
    }
    // 由大排到小，然後再變成整數 最大值
    public static int findMax(int[] num) {
        for (int notLen = num.length; notLen > 1; notLen--) {
            for (int i = 0; i < notLen-1; i++) {
                if (num[i] < num[i+1]) {
                    int tmp = num[i];
                    num[i] = num[i+1];
                    num[i+1] = tmp;
                }
            }
        }
        int i = 0;
        for (int i = 0; i < num.length; i++) {
            min += num[i] * Math.pow(10, i);
        }
        return Max;
    }
    // 由小排到大，然後再變成整數 最小值
    public static int findmin(int[] num) {
        for (int notLen = num.length; notLen > 1; notLen--) {
            for (int i = 0; i < notLen-1; i++) {
                if (num[i] > num[i+1]) {
                    int tmp = num[i];
                    num[i] = num[i+1];
                    num[i+1] = tmp;
                }
            }
        }
        int min = 0;
        for (int i = 0; i < num.length; i++) {
            min += num[i] * Math.pow(10, i);
        }
        return min;
    }
    // public static int[] subArray(int[] data, int start, int end) {
        // int[] newData = new int[end - start];
        // int index = 0;
        // for (int i = start; i < end; i++) {
            // newData[index] = data[i];
            // index += 1;
        // }
        // return newData;
    // }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // 輸入 int 1324
        int n = input.nextInt();
        int[] num = take(n);
        int min = findmin(num);
        int Max = findMax(num);
        System.out.println(Max);
        System.out.println(min);
    }
}