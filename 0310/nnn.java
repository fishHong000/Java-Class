// 108213010 �xޱ��
import java.util.Scanner;
public class nnn {
    public static long count(long n) {
        // �]�ܼƬ����ƦC����
        long len = 1;
        // ��ǤJ���Ѽ� n ���Ӱ�3n+1���B��
        // ��n=1�ɰ���A�N��N�O�Awhile������O?
        while(n != 1) {
            // �p�G n �O���ơA�h n<-n/2
            if (n % 2 == 0) {
                n = n / 2;
            // ��l�����p�A�h (3*n)+1
            } else {
                n = (3*n) + 1;
            }
            // �C���@���N�i�H�� len + 1 
            len += 1;
        }
        // ��������^�� len
        return len;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        long start = input.nextLong();
        long end = input.nextLong();
        long maxlen = 0;
        long tmp;
        long printBegin = start;
        long printEnd = end;
        if (start > end) {
            tmp = start;
            start = end;
            end = tmp;
        }
        for (long i = start ; i <= end ; i++) {
            long length = count(i);
            if (length > maxlen) {
                maxlen = length ;
            }
        }
        // �O�o�n�洫�j�p����
        // �]����X�n�D�ݭn�A�٭n��쥻��J���Ʀr�O��
        // (�Ϊ̥i�H�������J�L���Ʀr�b�洫�e���L�X��)
        System.out.print(printBegin + " " + printEnd + " " +maxlen); // �`�N�O print
        // �� start �� end �������C�ӼƦr��h�� 3n+1 ���B��
            // �����B�⧹���᪺�ƦC����
            // �C���o��s���ƦC���״N�򤧫e���o�������
            // �p���N����̤j������
            // �L�X
    }
}