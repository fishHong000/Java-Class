import java.util.Scanner;
// 再印出過程
    // 每個數字sort後，找出/由大到小/、/由小到大/
    // 再和
    // 再做相減，並設一個變數紀錄結果
    // 記得設一個變數，紀錄計算幾次
    // 檢查前面的結果有沒有重複
    // 有的話, 結束！
// 再印出執行次數：
public class Subtraction {
    // 搞出分開的數字(除以10的餘數)
    public static int[] cut(int index, int datanum) {
        int[] num = new int[index];
        int number = datanum;
        for (int i = 0; i < index; i++) {
            num[i] = number % 10;
            number = number / 10;
        }
        return num;
    }
    // 找出最大值
    public static int findMax(int[] surenum, int index) {
        // 排序, 由大到小
        for (int notLen = surenum.length; notLen > 1; notLen--) {
            for (int i = 0; i < notLen-1; i++) {
                if (surenum[i] < surenum[i+1]) {
                    int tmp = surenum[i];
                    surenum[i] = surenum[i+1];
                    surenum[i+1] = tmp;
                }
            }
        }
        // 寫出/最大值/的數字
        int Max = 0;
        for (int i = 0; i < index; i++) {
            Max += surenum[i]*Math.pow(10, (index-i-1));
        }
        return Max;
    }
    // 找出最小值
    public static int findmin(int[] surenum, int index) {
        // 排序, 由小到大
        for (int notLen = surenum.length; notLen > 1; notLen--) {
            for (int i = 0; i < notLen-1; i++) {
                if (surenum[i] > surenum[i+1]) {
                    int tmp = surenum[i];
                    surenum[i] = surenum[i+1];
                    surenum[i+1] = tmp;
                }
            }
        }
        // 寫出/最小值/的數字
        int min = 0;
        for (int i = 0; i < index; i++) {
            min += surenum[i]*Math.pow(10, (index-i-1));
        }
        return min;
    }
    public static int process(int Max, int min) {
        // 設一個變數紀錄結果
        int x;
        x = Max - min;
        return x;
    }
    // 計算有幾個數字字符
    public static int countnum(int data) {
        int index = 0;
        int tmp = data;
        while (tmp >= 1) {
            tmp = tmp / 10;
            index = index + 1;
        }
        return index;
    }
    public static int[] record(int Max, int min) {
        // 如果相減出來的數字排序完的最大等於Max
        // 停止
        int count = 0;
        int minus = 0;
        while (minus != Max) {
            minus = Max - min;
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        // 輸入數字
        for (int i = 0; i < n; i++) {
            data[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.println("原始數字：" + data[i]);
            // countnum(data[i]);
            int index = countnum(data[i]);
            cut(index, data[i]);
            // 設一個變數裝int[] num
            int[] surenum = cut(index, data[i]);
            // 找最大值
            int Max = findMax(surenum, index);
            // 找最小值
            int min = findmin(surenum, index);
            // /紀錄/相減並印出過程
            int x = Max - min;
            System.out.println(Max +"-"+ min + "=" +x);
            System.out.println("執行次數：");
        }
    }
}