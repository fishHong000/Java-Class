import java.util.Scanner;
public class Sort20 {
    public static boolean sorted(int[] data) {
        for (int i = 0; i < data.length-1; i++) {
            if (data[i] > data[i+1]) {
                return false;
            }
        }
        return true;
    }
    public static void sort(int[] data) {
        for (int sortedLen = 1; sortedLen < data.length; sortedLen++) {
            int tmp = data[sortedLen]; // 要插入元素
            int pos = sortedLen - 1; // 要比較的位置
            while (pos >= 0 && data[pos] > tmp) {
                data[pos+1] = data[pos];
                pos = pos - 1;
            }
            data[pos+1] = tmp;
        }
    }
    public static void bubble(int[] data) {
        for (int notLen = data.length; notLen > 1; notLen--) {
            // bubble by swap
            for (int i = 0; i < notLen-1; i++) {
                if (data[i] > data[i+1]) {
                    int tmp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = tmp;
                }
            }
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = (int)(Math.random()*1000000);
        }
        sort(data);
        if (sorted(data)) {
            System.out.println("correct");
        } else {
            System.out.println("error!");
        }
    }
}