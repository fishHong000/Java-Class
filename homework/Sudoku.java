// �Ǹ��G108213010 �m�W�G�xޱ��
import java.util.Scanner;
public class Sudoku {
    public static void findSol(int[] board) {
        // �P�_���ƻ�Ʀr
        boolean[][] rowNum = new boolean[9][9];
        boolean[][] colNum = new boolean[9][9];
        boolean[][] blockNum = new boolean[9][9];
        // ���Τw�g�T�w���Ʀr��z�C�ӦC����i�񪺼Ʀr
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
        // �p�G81�ӼƦr����F�A�פ�j
        if (x == 81) {
            for (int i = 1; i <= 81; i++) {
                System.out.print(board[i-1] + " ");
                if (i % 9 == 0) {
                    System.out.println();
                }
            }
            return;
        }
        // �p�G�o�榳��L�A�s�U�@��
        if (board[x] != 0) {
            fill(board, rowNum, colNum, blockNum, x+1);
            return;
        }
        // �p�G�S����L�A1~9���ոլ�
        if (board[x] == 0) {
            for (int c = 0; c < 9; c++) {
                // �i�H�񪺮�l
                if (rowNum[x/9][c] == false && colNum[x%9][c] == false && blockNum[x/9/3*3 + x%9/3][c] == false) {
                    rowNum[x/9][c] = true;
                    colNum[x%9][c] = true;
                    blockNum[x/9/3*3 + x%9/3][c] = true;
                    board[x] = c+1;
                    fill(board, rowNum, colNum, blockNum, x+1);
                    // �M������ pop
                    rowNum[x/9][c] = false;
                    colNum[x%9][c] = false;
                    blockNum[x/9/3*3 + x%9/3][c] = false;
                    board[x] = 0;
                }
            }
        }
    }
    public static void main(String[] argv) {
        // �ŧi��J
        Scanner input = new Scanner(System.in);
        // �ŧi�@�ӥi�H�s81�ӼƦr��board
        int[] board = new int[81];
        // ��ȶ�Jboard
        for (int c = 0; c < 81; c++) {           
            board[c] = input.nextInt();
        }
        findSol(board);
    }
}