import java.util.Scanner;
// �`�@�� 0~2n-1 �ӼƦr, ��d�I
public class AddSquare {
    // �L����
    static int[] board;
    // �غc�l
    // public Board() {
        // this.board = new int[n*n]; // n*n��m���O0����l
    // }
    public static int[] pop(int[] result){
        int[] tmp = new int[result.length-1];
        for(int i = 0; i<result.length-1; i++){
            tmp[i] = result[i];
        }
        return tmp;
    }
    // row ��ܲĴX���� (d//n)
    // col ��ܲĴX��� (d%n)
    // �λ��j��X���Ǧ�m�ۥ[����rol[i]�Mcol[i]
    public static void findSol(int[] row, int[] col,int[] result, int d, int n, int pos, int[] board) {
        // �פ���� // ����������Ʀr������s��, �L�X
        if (row[d/n] == 0 && col[d%n] == 0) {
            for (int i = 0; i < result.length; i++){
                board[i] = 1;
                System.out.println();
                return;
            }
        }
        for(int i = pos; i < d; i++){
            //���md��iresult
            result = append(result, i);
            findsol(row[i/n]-((i/n)+1), col[i%n]-((i&n)+1),result, d, n, i+1, board);
            //�n��result�٭�
            result = pop(result);
        }
    }
    // ��X��N��m�W��0�אּ1
    // �L�X
    public static int[] append(int d, int i){
        //�Ыؤ@��array�Od+1�����ת��A+1�O�]���٭n�A�h��@��
        int[] newd = new int[d+1];
        //������e���ȶ�i�h
        for(int j = 0; j <= d; j++){
            newd[j] = j;
        }
        //�n�b�̫�@�Ӧ�m��Ʀr�A�̫�@�Ӧ�m��index�Odata.length-1
        newd[d] = i;
        return newd;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // ���n��ܤ�}�j�p
        int n = input.nextInt();
        // ��Jn�Ӿ�ƥN��̥k�䪺row�ؼ�(�Ϥ@�����r)
        int[] row = new int[n];
        int d = 2*n-1;
        for (int i = 0; i < n; i++) {
            row[i] = input.nextInt();
        }
        // �A��Jn�Ӿ�ƥN��̤U����column���ؼ�(�ϤG�����r)
        int[] col = new int[n];
        for (int j = 0; j < n; j++) {
            col[j] = input.nextInt();
        }
        // �񵪮ת�result
        int[] result = new int[0];
        //pos�O���F�O�s�W�@�h�j���쪺��m
        int pos = 0;
        board = new int[n*n];
        findsol(row, col, result, d, n, pos, board);
    }
}