import java.util.Scanner;
// �A�L�X�L�{
    // �C�ӼƦrsort��A��X/�Ѥj��p/�B/�Ѥp��j/
    // �A�M
    // �A���۴�A�ó]�@���ܼƬ������G
    // �O�o�]�@���ܼơA�����p��X��
    // �ˬd�e�������G���S������
    // ������, �����I
// �A�L�X���榸�ơG
public class Subtraction {
    // �d�X���}���Ʀr(���H10���l��)
    public static int[] cut(int index, int datanum) {
        int[] num = new int[index];
        int number = datanum;
        for (int i = 0; i < index; i++) {
            num[i] = number % 10;
            number = number / 10;
        }
        return num;
    }
    // ��X�̤j��
    public static int findMax(int[] surenum, int index) {
        // �Ƨ�, �Ѥj��p
        for (int notLen = surenum.length; notLen > 1; notLen--) {
            for (int i = 0; i < notLen-1; i++) {
                if (surenum[i] < surenum[i+1]) {
                    int tmp = surenum[i];
                    surenum[i] = surenum[i+1];
                    surenum[i+1] = tmp;
                }
            }
        }
        // �g�X/�̤j��/���Ʀr
        int Max = 0;
        for (int i = 0; i < index; i++) {
            Max += surenum[i]*Math.pow(10, (index-i-1));
        }
        return Max;
    }
    // ��X�̤p��
    public static int findmin(int[] surenum, int index) {
        // �Ƨ�, �Ѥp��j
        for (int notLen = surenum.length; notLen > 1; notLen--) {
            for (int i = 0; i < notLen-1; i++) {
                if (surenum[i] > surenum[i+1]) {
                    int tmp = surenum[i];
                    surenum[i] = surenum[i+1];
                    surenum[i+1] = tmp;
                }
            }
        }
        // �g�X/�̤p��/���Ʀr
        int min = 0;
        for (int i = 0; i < index; i++) {
            min += surenum[i]*Math.pow(10, (index-i-1));
        }
        return min;
    }
    public static int process(int Max, int min) {
        // �]�@���ܼƬ������G
        int x;
        x = Max - min;
        return x;
    }
    // �p�⦳�X�ӼƦr�r��
    public static int countnum(int data) {
        int index = 0;
        int tmp = data;
        while (tmp >= 1) {
            tmp = tmp / 10;
            index = index + 1;
        }
        return index;
    }
    public static int[] record(int Max, int min) {
        // �p�G�۴�X�Ӫ��Ʀr�Ƨǧ����̤j����Max
        // ����
        int count = 0;
        int minus = 0;
        while (minus != Max) {
            minus = Max - min;
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        // ��J�Ʀr
        for (int i = 0; i < n; i++) {
            data[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.println("��l�Ʀr�G" + data[i]);
            // countnum(data[i]);
            int index = countnum(data[i]);
            cut(index, data[i]);
            // �]�@���ܼƸ�int[] num
            int[] surenum = cut(index, data[i]);
            // ��̤j��
            int Max = findMax(surenum, index);
            // ��̤p��
            int min = findmin(surenum, index);
            // /����/�۴�æL�X�L�{
            int x = Max - min;
            System.out.println(Max +"-"+ min + "=" +x);
            System.out.println("���榸�ơG");
        }
    }
}