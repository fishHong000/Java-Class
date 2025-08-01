// �ƿW
// �� �� �� �ۦP���Ʀr�u��X�{�@��
// �� �� �� : �U�� 9��,���s��0~8
// �� : 0 1 2
//      3 4 5
//      6 7 8
// �p�G��81�ӼƦr�s��0~ 80
// �h�s��n�b����row r, col c, block b?
// r = n / 9
// c = n % 9
// b = r/3*3+c/3
import java.util.Scanner;
public class NumUnique {
    // 0 ����٨S��J
    // 1~9��ܸӦ�m�w�g�T�w�F
    private int[] data;
    private boolean[][] ��, ��, ��;
    // �bn��m�W, ��J�Ʀrnum
    private void fill(int n, int num) {
        int r = n / 9;
        int c = n % 9;
        int b = r/3*3+c/3;
        ��[c][num-1] = ��[r][num-1] = ��[b][num-1] = true;
    }
    private void unFill(int n, int num) {
        int r = n / 9;
        int c = n % 9;
        int b = r/3*3+c/3;
        ��[c][num-1] = ��[r][num-1] = ��[b][num-1] = false;
    }
    private boolean canFill(int n, int num) {
        int r = n / 9;
        int c = n % 9;
        int b = r/3*3+c/3;
        // �D (�� �� �� �� �� �w��)
        return !(��[c][num-1] || ��[r][num-1] || ��[b][num-1]);
    }
    public NumUnique(int[] data) {
        this.data = data;
        �� = new boolean[9][9]; // �C�@�Ӫ���(����1)���ǼƦr(����2)�w�g�Q�e��F
        �� = new boolean[9][9]; // �C�@�Ӿ�樺�ǼƦr�w�g�Q�e��F
        �� = new boolean[9][9]; // �C�@�Ӷ����ǼƦr�w�g�Q�e��F
        for (int i = 0; i < 81; i++) {
            if (data[i] != 0) {
                fill(i, data[i]);
            }
        }
    }
    // �յۦb��mn��J�i�઺�Ʀr
    private void findSol(int n) {
        if (n == 81) { // found
            for (int i = 0; i < 9 ; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(data[i*9+j]+" ");
                }
                System.out.println();
            }
            return;
        }
        if (data[n] == 0) { // ����m�٨S�T�w
            // ���ǼƦr�O�i�H��?
            for (int i = 1; i <= 9 ; i++) { // �Ʀri
                if (canFill(n, i)) {
                    fill(n, i);
                    data[n] = i;
                    findSol(n+1);
                    data[n] = 0;
                    unFill(n, i);
                }
            }
        } else { // �w�T�w,��U�@�Ӧ�m�N�n
            findSol(n+1);
        }
    }
    public void printSol() {
        findSol(0);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int[] data = new int[81];
        for (int i = 0; i < 81; i++) {
            data[i] = input.nextInt();
        }
        NumUnique nu = new NumUnique(data);
        nu.printSol();
    }
}