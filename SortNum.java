import java.util.Scanner;
public class SortNum {
    // ��X�Ӥ@�Ӥ@�ӼƦr
    public static int[] take(int n) {
        int index = 0;
        int[] num = new int[5];
        while (n >= 0) {
            num[index] = n%10;
            index += 1;
        }
        return num;
    }
    // �Ѥj�ƨ�p�A�M��A�ܦ���� �̤j��
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
    // �Ѥp�ƨ�j�A�M��A�ܦ���� �̤p��
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
        // ��J int 1324
        int n = input.nextInt();
        int[] num = take(n);
        int min = findmin(num);
        int Max = findMax(num);
        System.out.println(Max);
        System.out.println(min);
    }
}