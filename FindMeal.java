// �Ǹ��G108213010 �m�W�G�xޱ��
import java.util.Scanner;
class Restaurant {
    //�ݩ�
    String name;
    int min, Max;
    //�غc�l
    public Restaurant(String name, int min, int Max) {
        this.name = name;
        this.min = min;
        this.Max = Max;
    }
}
public class FindMeal {
    // ��1�a�\�U�ŦX����A�N��X���a�\�U�� "���W"
    // ��2�a�\�U�H�W�ŦX����A�п�X "����ܧx��"
    // �p�G�w��}�Ӱ��N��X "�w��X�Ӧh�F"
    // �p�G�w��}�ӧC�N��X "�w��X�Ӥ֤F"
    // �Ѿl���p�L�X "�R���F"
    public static void Search(int n, Restaurant[] information, int m, int[] budget) {
        // �ˬdm��, �]����m�ӹw��
        // �p�G�b�o�a�\�U
        for (int i = 0; i < m; i++) {
            // ���X�a�\�U�ŦX�w��
            int x = 0;
            // �����X�a�\�U
            String result = "";
            for (int j = 0; j < n; j++) {
                if (information[j].min <= budget[i] && budget[i] <= information[j].Max) {
                    // �W�r��i�hresult
                    result = information[j].name;
                    x = x + 1;
                }
            }
            if (x == 1) {
                System.out.println(result);
            }
            if (x > 1) {
                System.out.println("����ܧx��");
            }
            if (x < 1) {
                int Maxnum = 0;
                int minnum = 0;
                for (int p = 0; p < n; p++) {
                    if (budget[i] > information[p].Max) {
                        Maxnum = Maxnum + 1;
                        if (Maxnum == n) {
                            System.out.println("�w��X�Ӧh�F");
                        }
                    }
                    if (budget[i] < information[p].min) {
                        minnum = minnum + 1;
                        if (minnum == n) {
                            System.out.println("�w��X�Ӥ֤F");
                        }
                    }
                    
                }
                if (Maxnum<n && minnum<n) {
                    System.out.println("�R���F");
                }
            }
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // ��Jn
        int n = input.nextInt();
        // ��Jn�a�\�U��T
        // �C���\�U��T���O�����W,�̧C����,�̰�����
        Restaurant[] information = new Restaurant[n];
        for (int i = 0; i < n; i++) {
            information[i] = new Restaurant(input.next(), input.nextInt(), input.nextInt());
        }
        // ��Jm
        int m = input.nextInt();
        // ��Jm���n�j�M���w��
        int[] budget = new int[m];
        for (int i = 0; i < m; i++) {
            budget[i] = input.nextInt();
        }
        Search(n, information, m, budget);
    }
}