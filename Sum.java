import java.util.Scanner;
public class Sum {
    // n: 方陣有多大
    // row: 每一個row的加總要求
    // col: 每一個col的加總要求
    public static void 老師做(int n, int[] row, int[] col) {
        // 弄張空白的答案卷,請學生由第0個位置開始填答
        學生做(n, row, col, 0, new boolean[n*n]);
    }
    public static void 印出答案(int n, boolean[] result) {
        for (int i=0; i < n; i++) { // print ith row
            for (int j=0; j < n; j++) { // print jth col
                System.out.print(result[i*n+j] ? '1' : '0');
            }
            System.out.println();
        }
        System.out.println();
    }
    // pos: 人家要我負責選的位置
    // result: 前面的人已經填好的答案紙
    public static void 學生做(int n, int[] row, int[] col, int pos, boolean[] result) {
        if (pos == n*n) { // 答案卷都寫完了
            印出答案(n, result);
            return;
        }
        int r = pos / n;
        int c = pos % n;
        // 只有兩種可能啊
        // 不選，把答案卷交給另一位同學做下一題
        if ((r!=n-1 && c!=n-1) ||
            (r!=n-1 && c==n-1 && row[r]==0) ||
            (r==n-1 && c!=n-1 && col[c]==0) ||
            (r==n-1 && c==n-1 && row[r]==0 && col[c]==0)) {
            學生做(n, row, col, pos+1, result);
        }
        // 要選, 把答案寫在答案紙上,再交給另一位同學做下一題
        if ((r!=n-1 && c!=n-1 && row[r]>=c+1 && col[c]>=r+1) ||
            (r!=n-1 && c==n-1 && row[r]==c+1 && col[c]>=r+1) ||
            (r==n-1 && c!=n-1 && row[r]>=c+1 && col[c]==r+1) ||
            (r==n-1 && c==n-1 && row[r]==c+1 && col[c]==r+1)) {
            result[pos] = true;
            row[r] -= c+1;
            col[c] -= r+1;
            學生做(n, row, col, pos+1, result);
            // 把答案卷還給人家時，記得塗改回原來的狀況
            result[pos] = false;
            row[r] += c+1;
            col[c] += r+1;
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] row = new int[n], col = new int[n];
        for (int i = 0; i < n; i++) {
            row[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            col[i] = input.nextInt();
        }
        老師做(n, row, col);
    }
}