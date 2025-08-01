import java.util.Scanner;
public class Seat {
    boolean[] checked;
    // 設一個印出來, 找到一個true, count+1
    // 設一個放座位
    public boolean put(int r, int total) {
        // 先選第一個, 放一個就改為true, 依照條件去放下一個位置
        // 
    }
    public static void main(String[] argv) {
        // 第一行為r代表有幾個rows
        int r = input.nextInt();
        // 接下來輸入r個數字代表該row有c個columns
        int[] column = new int[r];
        for (int i = 0; i < r; i++) {
            column[i] = input.nextInt();
        }
        int total = 0;
        for (int i = 0; i < r; i++) {
            total = total + column[i];
        }
        this.checked = new boolean[total];
    }
}