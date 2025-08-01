// 請解n皇后問題
// 直，橫，右上斜都不可以有其他皇后
// 直橫各有n條，編號給 0 ~ n-1
// 右上斜，右下斜各有 2n-1 條，編號給 0 ~ 2n-2
// board[r][c]，代表盤面(r,c)位置，r是row，c是column，都是 0 ~ n-1
// 那這個位置是屬於哪條直，橫，右上斜，右下斜線？
// 直：r
// 橫：c
// 右上斜：r+c
// 右下斜：r-c+n-1
import java.util.Scanner;
public class Queen {
    // n : 目標
    // row : 現在要放哪個row
    // 直 : 每條直線被占用的狀況，false表示沒人被占住
    // 右上斜 : 每條右上斜線被占用的狀況，false表示沒人被占住
    // 右下斜 : 每條右下斜線被占用的狀況，false表示沒人被占住
    public static int queen(int n, int row, boolean[] 直, boolean[] 右上斜, boolean[] 右下斜){
        if (n == r) { // 都擺上去了
            return 1; // 找到一組解
        }
        int sol = 0;
        // row r上的每個column c都試試看能不能擺上去
        for (int c = 0; c < n; c++) {
            // 如果三種線都沒被占住
            if (!(直[c] || 右上斜[r+c] || 右下斜[r-c+n-1])) {
                // 擺上去，所以這三種線就被占住了，使用塗改法
                直[c] = 右上斜[r+c] = 右下斜[r-c+n-1] = true;
                sol += queen(n, r+1, 直, 右上斜, 右下斜);
                // 記得要塗掉剛剛做的記號
                直[c] = 右上斜[r+c] = 右下斜[r-c+n-1] = false;
            }
        }
        return sol;
    }        
    // how many solutions for n queen problem
    public static int queen(n) {
        // construct arrays for line 直，右上斜，右下斜
        return queen(n, 0, new boolean[n], new boolean[2*n-1], new boolean[2*n-1]);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(queen(n));
    }
}    