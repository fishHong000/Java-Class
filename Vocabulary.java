import java.util.Arrays; //排序所需
import java.util.Scanner;
// 判斷位置與字母相符, true
// 全部找完，印出
public class Vocabulary {
    // 設一個array ans
    int[] ans;
    public static void ending(int n, int m, int k, boolean[] 直, boolean[] 右上斜, boolean[] 右下斜, int[][] board){
        // 當找完k個英文字母(終止條件)
        if (k == 0){
            Arrays.sort(ans); // 排序 ans
            // 印出
            System.out.println("以下是包含在字母堆中的單字");
            System.out.println(ans);
        }
    }
    public boolean find(){
        // 如果符合，加入ans
        // 找直行
        for(int i = 0; i < n, i++){ // 第幾行
            a = 0; // 刪除紀錄
            for(int j = 0; j < n; j++){ // 第幾個數字
                
            }
        }
        // 找橫行
        for(int j = 0; j < n; j++){
            a = 0;
            for(int j = 0; j < m; j++){
                
            }
        }
        // 找右上斜
        for(){
            
        }
        // 找右下斜
        for(){
            
        }
        return;
    }
    public 
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        // 輸入n, m, k // n代表n列，m代表m行，k代表有k個英文單字
        int n, m, k = input.nextInt();
        // 接下來輸入 n*m 個英文字母
        String english = input.nextLine();
        while (english != null && !english.equals("")) {
            english = input.nextLine();
        }
        // 接下來輸入 k 個英文單字
        String vocabulary = input.nextLine();
        while (vocabulary != null && !vocabulary.equals("")) {
            vocabulary = input.nextLine();
        }
    }
}