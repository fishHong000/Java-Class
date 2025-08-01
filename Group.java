import java.util.Scanner;
public class Group {
    // 設一個找朋友的
    public static void findfriends(int n, int[] data) {
        // 有0到n-1的位置
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0) { // 如果已經選過了
                continue; // 跳過繼續
            }
            // 如果資料本身的數字跟位置數字一樣(邊緣人), 印出
            if (i == data[i]) {
                System.out.println(data[i]);
                count = count + 1;
            }
            if (i != data[i]) {
                int friend = data[i];
                System.out.print(i+" ");
                while (friend != i) { // 如果資料本身的數字跟位置數字"不"一樣
                    int next = data[friend]; // 找到朋友
                    System.out.print(friend+" ");
                    data[friend] = -1;
                    friend = next;
                }
                count = count + 1;
                System.out.println();
            }
        }
        System.out.println("小團體數:"+count);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // 輸入n表示班上的人數
        int n = input.nextInt();
        // 輸入n筆資料
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = input.nextInt();
        }
        findfriends(n, data);
    }
}