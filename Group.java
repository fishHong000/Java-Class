import java.util.Scanner;
public class Group {
    // �]�@�ӧ�B�ͪ�
    public static void findfriends(int n, int[] data) {
        // ��0��n-1����m
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0) { // �p�G�w�g��L�F
                continue; // ���L�~��
            }
            // �p�G��ƥ������Ʀr���m�Ʀr�@��(��t�H), �L�X
            if (i == data[i]) {
                System.out.println(data[i]);
                count = count + 1;
            }
            if (i != data[i]) {
                int friend = data[i];
                System.out.print(i+" ");
                while (friend != i) { // �p�G��ƥ������Ʀr���m�Ʀr"��"�@��
                    int next = data[friend]; // ���B��
                    System.out.print(friend+" ");
                    data[friend] = -1;
                    friend = next;
                }
                count = count + 1;
                System.out.println();
            }
        }
        System.out.println("�p�����:"+count);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // ��Jn��ܯZ�W���H��
        int n = input.nextInt();
        // ��Jn�����
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = input.nextInt();
        }
        findfriends(n, data);
    }
}