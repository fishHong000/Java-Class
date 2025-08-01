// �Ǹ��G108213010 �m�W�G�xޱ��
import java.util.Scanner;
public class Bingo {
    // �L����
    int[] board;
    boolean[] checked; // checked�Ψ��ˬd�O���O�w�g�Q���L
    public void printBoard() {
        System.out.println(); //����
        // �O�o�P�_ checked �O�����
        for (int i = 0; i < 25; i++){ //�L���� 
        // ��5�����ƴ���(��5�Ӧ�m���e����)
            if (checked[i] == false){ //�p�G�S��L
                System.out.print("**"+" ");
            } else {
                System.out.print(String.format("%02d", board[i])+" "); //��0
            }
            if (i % 5 == 4){ //�C���Ӵ���
                System.out.println();
            }
        }
        System.out.println();
    }
    // �ˬd�C���O�_����(�ˬd 5 ���s�u)
    public boolean game_over() {
        // �U�� for �j��
        // for()
            // ���ˬd���u
        int a = 0;
        int countLine =0;
        for (int i = 0; i < 5; i++){ //���� ex.�Ĥ��Ӧ�m�O(0,1)
            a = 0; // ���ˬd�U�@���u�A�����M��
            for (int j = 0; j < 5; j++){
                if (checked[i+5*j] == true){
                    a = a + 1;
                }
                if (a == 5){ // �F��@���u
                    countLine = countLine + 1;
                }
            }
        }
        
        // for()
            // �ˬd��u
        for (int i = 0; i < 5; i++){
            a = 0;
            for (int j = 0; j < 5; j++){
                if (checked[5*i+j]){
                    a = a + 1;
                }
                if (a == 5){
                    countLine = countLine + 1;
                }
            }
        }
        // for()
            // �ˬd���W�k�U
        a = 0;
        for (int i = 0; i < 5; i++){
            if (checked[i*6] == true){
                a = a + 1;
            }
            if (a == 5){
                countLine = countLine + 1;
            }
        }
        // for()
            // �ˬd���U�k�W
        a = 0;
        for (int i = 1; i < 6; i++){
            if (checked[i*4] == true){
                a = a + 1;
            }
            if (a == 5){
                countLine = countLine + 1;
            }
        }
        // �ˬd���S�� >=5 ���u
        if(countLine >= 5) {
            return true;
        } else {
            return false;
        }
    }
    // ���ŦX���
    public boolean illegal(int x) { //�P�_true,false��boolean
        // �D1~25�������Ʀr�B�Ʀr����
        if (x < 1 || x > 25) {
            System.out.println("wrong number");
            return true;
        }
        for (int i = 0; i < 25; i++){
            // board��i��m����q���Ʀr�A�ӥBchecked����m�w�g�Q��L�F(����)
            if (board[i] == x && checked[i] == true) { 
                System.out.println("guessed");
                return true;
            }
        }
        return false;
    }
    // ��
    public void play() {
        Scanner input = new Scanner(System.in);
        int count = 0;
        int guess;
        while(!game_over()) {
            // �ϥΪ̿�J
            do { //do while �������A�M�ᬰtrue�����~��(�A��J�@���Ʀr)
                guess = input.nextInt(); // ��J�q���Ʀr
            } while(illegal(guess)); 
            // �� checked ��������m�令 true
            for (int i = 0; i < 25; i++){
                if (board[i] == guess) {
                    checked[i] = true; // ��ܲq�L���Ʀr
                    count = count + 1; // �q���Ʀr�[�@
                }
            }
            this.printBoard(); // this.��ܧڡA�L�X�ڸ̭����F��
        }
        System.out.println("Bingo! you guessed " + count + " times."); //�L�X�q�X��
    }
    public void shuffle() {
        for (int i = 0; i < 1000; i++) { //�~�P1000��
            int x, y; // �ŧi
            x = (int)(Math.random()*25); //Math.random()�O0~1���p�ơA�[(int)�j����
            y = (int)(Math.random()*25); //����(0~24)���Ʀr,�H�����@�ӼƦr
            int tmp;
            tmp = board[x];
            board[x] = board[y];
            board[y] = tmp;
        }
    }
    // �غc�l �إ� Bingo �L
    public Bingo() {
        // ���� 1 ~ 25 �A�A���ä����i�h board �̭�
        // this �N�O play1
        // ���Ыؤ@�ӥ������O0��array
        this.board = new int[5*5]; //25�ӳ��O0��l(��m)
        this.checked = new boolean[5*5]; //25�ӳ��Ofalse����m
        // �A��J 1 ~ 25
        for (int i = 0; i < 25; i++){ //����0~24����m
            board[i] = i+1; //�̧Ƕ�J1~25���Ʀr
        }
        shuffle(); //����
    }
    public static void main(String[] argv) {
        Bingo play1 = new Bingo(); // �Ф@�ӥsplay1��Bingo
        play1.play();
    }
}