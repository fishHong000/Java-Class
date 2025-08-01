// 排列
public class AllDigit {
    public static void perm(String data, int n, String result){ //寫遞迴的第一件事情，寫終止條件!!
        if(n == 0){ //設常數n=9，每放一個數字n-1，當n=0代表數字放完(終止條件)
            int a = Integer.valueOf(result.substring(0,2));
            int b = Integer.valueOf(result.substring(2,3));
            int c = Integer.valueOf(result.substring(3,5));
            int d = Integer.valueOf(result.substring(5,7));
            int e = Integer.valueOf(result.substring(7,9));
            if (a*b == c && c + d == e){
                System.out.println(result);
                return;
            }
        }
        for(int i = 0; i < data.length(); i++){ //substring切割字串
            perm(data.substring(0,i) + data.substring(i+1,data.length()), n-1, result+data.charAt(i));
        }
    }
    public static void perm(String data,int n){
        perm(data, n, "");
    }
    public static void main(String[] argv){
        // 有 1~9 的數字
        perm("123456789", 9);
    }
}