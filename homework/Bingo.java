// 學號：108213010 姓名：洪瑄妤
import java.util.Scanner;
public class Bingo {
    // 印版面
    int[] board;
    boolean[] checked; // checked用來檢查是不是已經被劃過
    public void printBoard() {
        System.out.println(); //換行
        // 記得判斷 checked 是什麼值
        for (int i = 0; i < 25; i++){ //印全部 
        // 第5的倍數換行(第5個位置之前換行)
            if (checked[i] == false){ //如果沒填過
                System.out.print("**"+" ");
            } else {
                System.out.print(String.format("%02d", board[i])+" "); //補0
            }
            if (i % 5 == 4){ //每五個換行
                System.out.println();
            }
        }
        System.out.println();
    }
    // 檢查遊戲是否結束(檢查 5 條連線)
    public boolean game_over() {
        // 各種 for 迴圈
        // for()
            // 先檢查直線
        int a = 0;
        int countLine =0;
        for (int i = 0; i < 5; i++){ //直的 ex.第五個位置是(0,1)
            a = 0; // 換檢查下一條線，紀錄清除
            for (int j = 0; j < 5; j++){
                if (checked[i+5*j] == true){
                    a = a + 1;
                }
                if (a == 5){ // 達到一條線
                    countLine = countLine + 1;
                }
            }
        }
        
        // for()
            // 檢查橫線
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
            // 檢查左上右下
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
            // 檢查左下右上
        a = 0;
        for (int i = 1; i < 6; i++){
            if (checked[i*4] == true){
                a = a + 1;
            }
            if (a == 5){
                countLine = countLine + 1;
            }
        }
        // 檢查有沒有 >=5 條線
        if(countLine >= 5) {
            return true;
        } else {
            return false;
        }
    }
    // 不符合資格
    public boolean illegal(int x) { //判斷true,false用boolean
        // 非1~25之間的數字、數字重複
        if (x < 1 || x > 25) {
            System.out.println("wrong number");
            return true;
        }
        for (int i = 0; i < 25; i++){
            // board的i位置等於猜的數字，而且checked的位置已經被填過了(重複)
            if (board[i] == x && checked[i] == true) { 
                System.out.println("guessed");
                return true;
            }
        }
        return false;
    }
    // 玩
    public void play() {
        Scanner input = new Scanner(System.in);
        int count = 0;
        int guess;
        while(!game_over()) {
            // 使用者輸入
            do { //do while 直接做，然後為true的話繼續做(再輸入一次數字)
                guess = input.nextInt(); // 輸入猜的數字
            } while(illegal(guess)); 
            // 把 checked 的對應位置改成 true
            for (int i = 0; i < 25; i++){
                if (board[i] == guess) {
                    checked[i] = true; // 表示猜過的數字
                    count = count + 1; // 猜的數字加一
                }
            }
            this.printBoard(); // this.表示我，印出我裡面的東西
        }
        System.out.println("Bingo! you guessed " + count + " times."); //印出猜幾次
    }
    public void shuffle() {
        for (int i = 0; i < 1000; i++) { //洗牌1000次
            int x, y; // 宣告
            x = (int)(Math.random()*25); //Math.random()是0~1的小數，加(int)強制整數
            y = (int)(Math.random()*25); //產生(0~24)的數字,隨機取一個數字
            int tmp;
            tmp = board[x];
            board[x] = board[y];
            board[y] = tmp;
        }
    }
    // 建構子 建立 Bingo 盤
    public Bingo() {
        // 產生 1 ~ 25 ，再打亂之後放進去 board 裡面
        // this 就是 play1
        // 先創建一個全部都是0的array
        this.board = new int[5*5]; //25個都是0格子(位置)
        this.checked = new boolean[5*5]; //25個都是false的位置
        // 再塞入 1 ~ 25
        for (int i = 0; i < 25; i++){ //產生0~24的位置
            board[i] = i+1; //依序填入1~25的數字
        }
        shuffle(); //打亂
    }
    public static void main(String[] argv) {
        Bingo play1 = new Bingo(); // 創一個叫play1的Bingo
        play1.play();
    }
}