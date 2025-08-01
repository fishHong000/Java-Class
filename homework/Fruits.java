// 學號：108213010 姓名：洪瑄妤
import java.util.Scanner;
public class Fruits {
    public static void print(int[] result, int[] data) {
        System.out.print(data[0] + "元的 " + result[0] + " 個");
        for(int i = 1; i < data.length; i++) {
            System.out.print("、" + data[i] + "元的 " + result[i] + " 個");
        }
        System.out.println();
    }
    //money 是剩下多少$$
    //n 是剩多少顆水果要買
    //species 是有幾中水果
    //data 是水果的價錢
    //result 是購物籃
    //pos 是買到第幾顆水果
    public static void findSol(int money, int n, int species, int[] data, int[] result , int pos) {
        // 終止條件
        if(n == 0 && money >= 0) { // 水果買完&&還有錢
            // print result
            print(result, data);
            return;
        }
        if(money < 0 || pos >= species) { // 花完錢或是沒有第species+1種水果
            return;
        }
        for(int i = n; i >= 0; i--) { // 這個迴圈代表 當下這個人可以買0~n種水果
            result[pos] = i;
            findSol(money - data[pos]*i, n - i, species, data, result, pos + 1);
            // 接下來丟給下一個人
            // 下一個人可以買n-i個水果
            result[pos] = 0;
        }
    }   
    public static int findmin(int[] data) {
        // 找出最小值
        // 先設一個變數，用來存最小的數字
        int min = data[0];
        for(int i = 1; i < data.length; i++) {
            if(data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }
    public static void findSol(int money, int n, int species, int[] data, int pos, int[] result) {
        // 終止條件
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
        // 整數 money 表示買水果的金額上限
        int money = input.nextInt();
        // 整數 n 表示總共要買的水果數量
        int n = input.nextInt();
        // 整數 species 表示水果的種類
        int species = input.nextInt();
        // species 種水果的價錢
        int[] data = new int[species];
        for(int i = 0; i < data.length; i++) {
            data[i] = input.nextInt();
        }
        // 如果錢...然後那最便宜的水果...，所以就...
        int min = findmin(data);
        if (min*n > money) {
            System.out.println("無法買滿");
        } else {
            // 呼叫遞迴函數去窮舉所有結果
            findSol(money, n, species, data, new int[species] , 0);
        }
    }
}