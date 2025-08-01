import java.util.Scanner;
public class Num {
    private static String[] dict = new String[1000];
    private static int dictLen;
    public static String sort(String data) {
        return sort(data, false);
    }
    public static String sort(String num, boolean reverse) {
        // insorting sort
        char[] data = num.toCharArray();
        for (int len = 1; len < data.length; len++) {
            char v = data[len];
            int pos = len - 1;
            if (reverse) {
                while (pos >= 0 && data[pos] > v) {
                    data[pos+1] = data[pos];
                    pos--;
                }
            } else {
                while (pos >= 0 && data[pos] < v) {
                    data[pos+1] = data[pos];
                    pos--;
                }
            }
            data[pos+1] = v;
        }
        return new String(data);
    }
    public static boolean repeat(String num) {
        // check if num appear previously
        for (int i = 0; i < dictLen; i++) {
            if (dict[i].equals(num))
                return true;
        }
        dict[dictLen++] = num;
        return false;
    }
    public static void findSol(String num) {
        dictLen = 0;
        System.out.println("\n原始數字 : "+(num=Long.toString(Long.valueOf(num))));
        int count = 0;
        do {
            String max = Long.toString(Long.valueOf(sort(num)));
            String min = Long.toString(Long.valueOf(sort(num, true)));
            num = Long.toString(Long.valueOf(max) - Long.valueOf(min));
            System.out.println(max+" - "+min+" = "+num);
            count++;
        } while (!repeat(num));
        System.out.println("執行次數 : "+count);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++)
            findSol(input.next());
    }
}