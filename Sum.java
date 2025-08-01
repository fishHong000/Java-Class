import java.util.Scanner;
public class Sum {
    // n: ��}���h�j
    // row: �C�@��row���[�`�n�D
    // col: �C�@��col���[�`�n�D
    public static void �Ѯv��(int n, int[] row, int[] col) {
        // �˱i�ťժ����ר�,�оǥͥѲ�0�Ӧ�m�}�l��
        �ǥͰ�(n, row, col, 0, new boolean[n*n]);
    }
    public static void �L�X����(int n, boolean[] result) {
        for (int i=0; i < n; i++) { // print ith row
            for (int j=0; j < n; j++) { // print jth col
                System.out.print(result[i*n+j] ? '1' : '0');
            }
            System.out.println();
        }
        System.out.println();
    }
    // pos: �H�a�n�ڭt�d�諸��m
    // result: �e�����H�w�g��n�����ׯ�
    public static void �ǥͰ�(int n, int[] row, int[] col, int pos, boolean[] result) {
        if (pos == n*n) { // ���ר����g���F
            �L�X����(n, result);
            return;
        }
        int r = pos / n;
        int c = pos % n;
        // �u����إi���
        // ����A�⵪�ר��浹�t�@��P�ǰ��U�@�D
        if ((r!=n-1 && c!=n-1) ||
            (r!=n-1 && c==n-1 && row[r]==0) ||
            (r==n-1 && c!=n-1 && col[c]==0) ||
            (r==n-1 && c==n-1 && row[r]==0 && col[c]==0)) {
            �ǥͰ�(n, row, col, pos+1, result);
        }
        // �n��, �⵪�׼g�b���ׯȤW,�A�浹�t�@��P�ǰ��U�@�D
        if ((r!=n-1 && c!=n-1 && row[r]>=c+1 && col[c]>=r+1) ||
            (r!=n-1 && c==n-1 && row[r]==c+1 && col[c]>=r+1) ||
            (r==n-1 && c!=n-1 && row[r]>=c+1 && col[c]==r+1) ||
            (r==n-1 && c==n-1 && row[r]==c+1 && col[c]==r+1)) {
            result[pos] = true;
            row[r] -= c+1;
            col[c] -= r+1;
            �ǥͰ�(n, row, col, pos+1, result);
            // �⵪�ר��ٵ��H�a�ɡA�O�o���^��Ӫ����p
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
        �Ѯv��(n, row, col);
    }
}