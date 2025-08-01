// �Ǹ��G108213010 �m�W�G�xޱ��
import java.util.Scanner;
public class Fruits {
    public static void print(int[] result, int[] data) {
        System.out.print(data[0] + "���� " + result[0] + " ��");
        for(int i = 1; i < data.length; i++) {
            System.out.print("�B" + data[i] + "���� " + result[i] + " ��");
        }
        System.out.println();
    }
    //money �O�ѤU�h��$$
    //n �O�Ѧh�������G�n�R
    //species �O���X�����G
    //data �O���G������
    //result �O�ʪ��x
    //pos �O�R��ĴX�����G
    public static void findSol(int money, int n, int species, int[] data, int[] result , int pos) {
        // �פ����
        if(n == 0 && money >= 0) { // ���G�R��&&�٦���
            // print result
            print(result, data);
            return;
        }
        if(money < 0 || pos >= species) { // �᧹���άO�S����species+1�ؤ��G
            return;
        }
        for(int i = n; i >= 0; i--) { // �o�Ӱj��N�� ��U�o�ӤH�i�H�R0~n�ؤ��G
            result[pos] = i;
            findSol(money - data[pos]*i, n - i, species, data, result, pos + 1);
            // ���U�ӥᵹ�U�@�ӤH
            // �U�@�ӤH�i�H�Rn-i�Ӥ��G
            result[pos] = 0;
        }
    }   
    public static int findmin(int[] data) {
        // ��X�̤p��
        // ���]�@���ܼơA�ΨӦs�̤p���Ʀr
        int min = data[0];
        for(int i = 1; i < data.length; i++) {
            if(data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }
    public static void findSol(int money, int n, int species, int[] data, int pos, int[] result) {
        // �פ����
        if(money < 0) {
            return;
        }
        if(n == 0) {
            // print result
            print(result, data);
            return;
        }
        for(int i = pos; i < data.length; i++) {
            for (int j = 0; j <= money / data[i] ; j++){
                result[i] = j; 
                findSol(money - (data[pos] * j), n-j, species, data, pos+1, result);
                result[i] = 0;
            }
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // ��� money ��ܶR���G�����B�W��
        int money = input.nextInt();
        // ��� n ����`�@�n�R�����G�ƶq
        int n = input.nextInt();
        // ��� species ��ܤ��G������
        int species = input.nextInt();
        // species �ؤ��G������
        int[] data = new int[species];
        for(int i = 0; i < data.length; i++) {
            data[i] = input.nextInt();
        }
        // �p�G��...�M�ᨺ�̫K�y�����G...�A�ҥH�N...
        int min = findmin(data);
        if (min*n > money) {
            System.out.println("�L�k�R��");
        } else {
            // �I�s���j��ƥh�a�|�Ҧ����G
            findSol(money, n, species, data, new int[species] , 0);
        }
    }
}