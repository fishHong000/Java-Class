import java.util.Scanner;
class Flights {
    String name, beginning, ending;
    int price;
    public Flights(String name, String beginning, String ending, int price) {
        this.name = name;
        this.beginning = beginning;
        this.ending = ending;
        this.price = price;
    }
}
public class Plane {
    // n�Z��Z, �̪�_�I, �̲��I, ��i�H�f����Z, ��Z��T, �`�@�n��h�ֿ�, ��F�X�ӯ�Z
    public static void findSol(int n, String begin, String end, String[] result, Flights[] data, int money, int num) {
        // �פ����, ���@�ոѦL�X
        // �p�G�U�@�ӯ�Z���_�I ���� �̲��I -> ��F�I
        if (begin.equals(end)) {
            for (int i = 0; i < num; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
            System.out.println(money);
            return;
        }
        if (num >= 4) {
            return;
        }
        String tmp;
        for (int i = 0; i < n; i++) {
            // �p�G�U�@�Z��Z���_�I ���� �W�@�Z�����I
            if (data[i].beginning.equals(begin)) {
                result[num] = data[i].name;
                begin = data[i].ending;
                findSol(n, begin, end, result, data, money+data[i].price, num+1);
                begin = data[i].beginning;
            }
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // �`��Z��
        int n = input.nextInt();
        // �_�I
        String begin = input.next();
        // ���I
        String end = input.next();
        // ��Z�W�� �_�I ���I �Z������
        Flights[] data = new Flights[n]; // ������
        for (int i = 0; i < n; i++) {
            data[i] = new Flights(input.next(), input.next(), input.next(), input.nextInt());
        }
        String[] result = new String[n];
        findSol(n, begin, end, result, data, 0, 0);
    }
}