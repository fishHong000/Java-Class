// 學號：108213010 姓名：洪瑄妤
import java.util.Scanner;
public class Sudoku {
    public static void findSol(int[] board) {
        // 判斷能填甚麼數字
        boolean[][] rowNum = new boolean[9][9];
        boolean[][] colNum = new boolean[9][9];
        boolean[][] blockNum = new boolean[9][9];
        // 先用已經確定的數字整理每個列行塊可填的數字
        for (int c = 0; c < 81; c++) {
            if (board[c] != 0) {
                rowNum[c/9][board[c]-1] = true;
                colNum[c%9][board[c]-1] = true;
                blockNum[c/9/3*3 + c%9/3][board[c]-1] = true;
            }
        }
        fill(board, rowNum, colNum, blockNum, 0);
    }
    public static void fill(int[] board,boolean[][] rowNum,boolean[][] colNum,boolean[][] blockNum,int x) {
        // 如果81個數字都填了，終止遞迴
        if (x == 81) {
            for (int i = 1; i <= 81; i++) {
                System.out.print(board[i-1] + " ");
                if (i % 9 == 0) {
                    System.out.println();
                }
            }
            return;
        }
        // 如果這格有填過，叫下一個
        if (board[x] != 0) {
            fill(board, rowNum, colNum, blockNum, x+1);
            return;
        }
        // 如果沒有填過，1~9都試試看
        if (board[x] == 0) {
            for (int c = 0; c < 9; c++) {
                // 可以填的格子
                if (rowNum[x/9][c] == false && colNum[x%9][c] == false && blockNum[x/9/3*3 + x%9/3][c] == false) {
                    rowNum[x/9][c] = true;
                    colNum[x%9][c] = true;
                    blockNum[x/9/3*3 + x%9/3][c] = true;
                    board[x] = c+1;
                    fill(board, rowNum, colNum, blockNum, x+1);
                    // 清掉紀錄 pop
                    rowNum[x/9][c] = false;
                    colNum[x%9][c] = false;
                    blockNum[x/9/3*3 + x%9/3][c] = false;
                    board[x] = 0;
                }
            }
        }
    }
    public static void main(String[] argv) {
        // 宣告輸入
        Scanner input = new Scanner(System.in);
        // 宣告一個可以存81個數字的board
        int[] board = new int[81];
        // 把值填入board
        for (int c = 0; c < 81; c++) {           
            board[c] = input.nextInt();
        }
        findSol(board);
    }
}