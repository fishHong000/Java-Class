public class perm { // 排列問題
    public static void perm(String v, int n, String result) {
        if (n == 0) { // 都選好了
            System.out.println(result);
            return;
        }
        // 選擇v的某一個字元，再把剩下可選的，交給下一位同學(recursive call)處理 
        // 有多少種選法
        for (int i = 0; i < v.length(); i++) {
            // 選擇位置i的字元 // charAt = 字元at
            perm(v.substring(0,i)+v.substring(i+1,v.length()), n-1, result+v.charAt(i));
        }
    }
    // v字串任取n個字元的所有組合
    public static void perm(String v, int n) { // overloading
        perm(v, n, "");
    }
    public static void main(String[] argv) {
        perm("ABCDE", 2); // 印出"ABCDE"任取2個的所有組合
    }
}