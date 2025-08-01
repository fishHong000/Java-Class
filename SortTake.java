import java.util.Scanner;
public class SortTake {
    // public static boolean sorted(int[] data) {
        // for (int i = 0; i < data.length-1; i++) {
            // if (data[i] > data[i+1]) {
                // return false;
            // }
        // }
        // return true;
    // }
    // public static void sort(int[] data) {
        // for (int sortedLen = 1; sortedLen < data.length; sortedLen++) {
            // int tmp = data[sortedLen];
            // int pos = sortedLen - 1;
            // while (pos >= 0 && data[pos] < tmp) {
                // data[pos+1] = data[pos];
                // pos = pos - 1;
            // }
            // data[pos+1] = tmp;
        // }
    // }
    public static void bubble(int[] data) {
        for (int notLen = data.length; notLen > 1; notLen--) {
            for (int i = 0; i < notLen-1; i++) {
                if (data[i] < data[i+1]) {
                    int tmp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = tmp;
                }
            }
        }
    }
    public static int[] subArray(int[] data, int start, int end) {
        int[] newData = new int[end - start];
        int index = 0;
        for (int i = start; i < end; i++) {
            newData[index] = data[i];
            index += 1;
        }
        return newData;
    }
    public static int[] extend(int[] first, int[] second) {
        int[] plus = new int[first.length+second.length];
        int index = 0;
        for (int i = 0; i < first.length; i++) {
            plus[index] = first[i];
            index += 1;
        }
        for (int i = 0; i < second.length; i++) {
            plus[index] = second[i];
            index += 1;
        }
        return plus;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = input.nextInt();
        }
        int[] result;
        for (int i = 0; i < n; i++) {
            result = extend(subArray(data, 0, i), subArray(data, i+1, n));
            // result[i] :type int
            // trying return type: int[]
            bubble(result);
            result = extend(result, new int[]{data[i]});
            for (int j: result) {
                System.out.print(j);
            }
            System.out.println();
        }
        return;
    }
}