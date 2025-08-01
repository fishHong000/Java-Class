import java.util.Scanner;
// 總共有 0~2n-1 個數字, 為d點
public class AddSquare {
    // 印版面
    static int[] board;
    // 建構子
    // public Board() {
        // this.board = new int[n*n]; // n*n位置都是0的格子
    // }
    public static int[] pop(int[] result){
        int[] tmp = new int[result.length-1];
        for(int i = 0; i<result.length-1; i++){
            tmp[i] = result[i];
        }
        return tmp;
    }
    // row 表示第幾直行 (d//n)
    // col 表示第幾橫行 (d%n)
    // 用遞迴算出哪些位置相加等於rol[i]和col[i]
    public static void findSol(int[] row, int[] col,int[] result, int d, int n, int pos, int[] board) {
        // 終止條件 // 當扣完直的橫的數字都等於零時, 印出
        if (row[d/n] == 0 && col[d%n] == 0) {
            for (int i = 0; i < result.length; i++){
                board[i] = 1;
                System.out.println();
                return;
            }
        }
        for(int i = pos; i < d; i++){
            //把位置d放進result
            result = append(result, i);
            findsol(row[i/n]-((i/n)+1), col[i%n]-((i&n)+1),result, d, n, i+1, board);
            //要把result還原
            result = pop(result);
        }
    }
    // 算出後將位置上的0改為1
    // 印出
    public static int[] append(int d, int i){
        //創建一個array是d+1的長度的，+1是因為還要再多塞一個
        int[] newd = new int[d+1];
        //先把先前的值填進去
        for(int j = 0; j <= d; j++){
            newd[j] = j;
        }
        //要在最後一個位置塞數字，最後一個位置的index是data.length-1
        newd[d] = i;
        return newd;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // 整數n表示方陣大小
        int n = input.nextInt();
        // 輸入n個整數代表最右邊的row目標(圖一的紅字)
        int[] row = new int[n];
        int d = 2*n-1;
        for (int i = 0; i < n; i++) {
            row[i] = input.nextInt();
        }
        // 再輸入n個整數代表最下面的column的目標(圖二的紅字)
        int[] col = new int[n];
        for (int j = 0; j < n; j++) {
            col[j] = input.nextInt();
        }
        // 放答案的result
        int[] result = new int[0];
        //pos是為了保存上一層迴圈算到的位置
        int pos = 0;
        board = new int[n*n];
        findsol(row, col, result, d, n, pos, board);
    }
}