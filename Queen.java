// 學號：108213010 姓名：洪瑄妤
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
    static int = 1;
    public static int queen(int n, int r, boolean[] 直, boolean[] 右上斜, boolean[] 右下斜, int[][] board){
        if (n == r) { // 都擺上去了
        // 換行
        System.out.println("第 "+sol+" 解 ：");
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    System.out.print(board[i][j]+"  ");
                }
                System.out.println();
            }
            System.out.println("---------------");
            sol = sol + 1;
            return sol; // 找到一組解
        }
        int sol = 0;
        // row r上的每個column c都試試看能不能擺上去
        // c:第幾行
        for (int c = 0; c < n; c++) {
            // 如果三種線都沒被占住
            // !:not(反邏輯)
            if (!(直[c] || 右上斜[r+c] || 右下斜[r-c+n-1])) {
                // 擺上去，所以這三種線就被占住了，使用塗改法
                // true:被占住了
                直[c] = 右上斜[r+c] = 右下斜[r-c+n-1] = true;
                board[r][c] = 1;
                queen(n, r+1, 直, 右上斜, 右下斜, board);
                // 記得要塗掉剛剛做的記號
                直[c] = 右上斜[r+c] = 右下斜[r-c+n-1] = false;
                board[r][c] = 0;
            }
        }
        return sol;
    }
    // how many solutions for n queen problem
    public static void queen(int n) {
        // construct arrays for line 直，右上斜，右下斜
        // 棋盤
        int[][] board = new int[n][n];
        // [[0,0,0,0][1,1,1][2,2,2]]
        // 每個位置填零
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        queen(n, 0, new boolean[n], new boolean[2*n-1], new boolean[2*n-1], board);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        queen(n);
        if (sol == 1){
            System.out.print("找不到解");
        }
    }
}