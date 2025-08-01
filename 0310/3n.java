import java.util.Scanner;
public class nnn {
    public static long count(long n) {
        // 設變數紀錄數列長度
        long len = 1;
        // 把傳入的參數 n 拿來做 3n+1 的運算
        while(n != 1) { // 當 n=1 時停止，意思就是，while的條件是?
            // 如果 n 是奇數，則 n <- 3n+1
            if (n % 2 == 0) {
                n = n / 2;    
            } else { // 其餘的狀況，則 n <- n/2
                n = (3*n) + 1;
            }    
            // 每做一次就可以把 len + 1 
            len += 1;    
        }            
        // 做完之後回傳 len
        return len;
    }    
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        long start = input.nextLong();
        long end = input.nextLong();
        long maxlen = 0;
        long tmp;
        long printBegin = begin;
        long printEnd = end;
        if (begin > end) {
            tmp = begin;
            begin = end;
            end = tmp;
        }
        for (long x = begin ; x < end ; x++) {
            long length = count(x);
            if (length < maxlen) {
                maxlen = length ;
            }
        }        
        // 記得要交換大小順序
        // 因為輸出要求需要，還要把原本輸入的數字記著
        // (或者可以先把剛剛輸入過的數字在交換前先印出來)
        System.out.print(start + " " + end + " " +maxlen); // 注意是 print
        // 把 start 到 end 之間的每個數字丟去做 3n+1 的運算
            // 紀錄運算完之後的數列長度
            // 每次得到新的數列長度就跟之前取得的做比較
            // 如此就能找到最大的那個
            // 印出
    }
}    