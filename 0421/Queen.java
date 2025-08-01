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
    public static int queen(int n, int row, boolean[] ��, boolean[] �k�W��, boolean[] �k�U��){
        if (n == r) { // ���\�W�h�F
            return 1; // ���@�ո�
        }
        int sol = 0;
        // row r�W���C��column c���ոլݯण���\�W�h
        for (int c = 0; c < n; c++) {
            // �p�G�T�ؽu���S�Q�e��
            if (!(��[c] || �k�W��[r+c] || �k�U��[r-c+n-1])) {
                // �\�W�h�A�ҥH�o�T�ؽu�N�Q�e��F�A�ϥζ��k
                ��[c] = �k�W��[r+c] = �k�U��[r-c+n-1] = true;
                sol += queen(n, r+1, ��, �k�W��, �k�U��);
                // �O�o�n���谵���O��
                ��[c] = �k�W��[r+c] = �k�U��[r-c+n-1] = false;
            }
        }
        return sol;
    }        
    // how many solutions for n queen problem
    public static int queen(n) {
        // construct arrays for line ���A�k�W�סA�k�U��
        return queen(n, 0, new boolean[n], new boolean[2*n-1], new boolean[2*n-1]);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(queen(n));
    }
}    