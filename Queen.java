// �Ǹ��G108213010 �m�W�G�xޱ��
// �и�n�ӦZ���D
// ���A��A�k�W�׳����i�H����L�ӦZ
// ����U��n���A�s���� 0 ~ n-1
// �k�W�סA�k�U�צU�� 2n-1 ���A�s���� 0 ~ 2n-2
// board[r][c]�A�N��L��(r,c)��m�Ar�Orow�Ac�Ocolumn�A���O 0 ~ n-1
// ���o�Ӧ�m�O�ݩ�������A��A�k�W�סA�k�U�׽u�H
// ���Gr
// ��Gc
// �k�W�סGr+c
// �k�U�סGr-c+n-1
import java.util.Scanner;
public class Queen {
    // n : �ؼ�
    // row : �{�b�n�����row
    // �� : �C�����u�Q�e�Ϊ����p�Afalse��ܨS�H�Q�e��
    // �k�W�� : �C���k�W�׽u�Q�e�Ϊ����p�Afalse��ܨS�H�Q�e��
    // �k�U�� : �C���k�U�׽u�Q�e�Ϊ����p�Afalse��ܨS�H�Q�e��
    static int = 1;
    public static int queen(int n, int r, boolean[] ��, boolean[] �k�W��, boolean[] �k�U��, int[][] board){
        if (n == r) { // ���\�W�h�F
        // ����
        System.out.println("�� "+sol+" �� �G");
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    System.out.print(board[i][j]+"  ");
                }
                System.out.println();
            }
            System.out.println("---------------");
            sol = sol + 1;
            return sol; // ���@�ո�
        }
        int sol = 0;
        // row r�W���C��column c���ոլݯण���\�W�h
        // c:�ĴX��
        for (int c = 0; c < n; c++) {
            // �p�G�T�ؽu���S�Q�e��
            // !:not(���޿�)
            if (!(��[c] || �k�W��[r+c] || �k�U��[r-c+n-1])) {
                // �\�W�h�A�ҥH�o�T�ؽu�N�Q�e��F�A�ϥζ��k
                // true:�Q�e��F
                ��[c] = �k�W��[r+c] = �k�U��[r-c+n-1] = true;
                board[r][c] = 1;
                queen(n, r+1, ��, �k�W��, �k�U��, board);
                // �O�o�n���谵���O��
                ��[c] = �k�W��[r+c] = �k�U��[r-c+n-1] = false;
                board[r][c] = 0;
            }
        }
        return sol;
    }
    // how many solutions for n queen problem
    public static void queen(int n) {
        // construct arrays for line ���A�k�W�סA�k�U��
        // �ѽL
        int[][] board = new int[n][n];
        // [[0,0,0,0][1,1,1][2,2,2]]
        // �C�Ӧ�m��s
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
            System.out.print("�䤣���");
        }
    }
}