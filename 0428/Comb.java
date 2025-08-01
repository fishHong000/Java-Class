public class Comb { // 組合問題
    // 由data[start:end]複製出新的array，給組合問題用
    public static int[] slice(int[] data, int start, int end) {
        int[] result = new int[end-start];
        for (int i = start, at = 0, i < end; at++) {
            result[at] = data[i];
        }
        return result;
    }
    // 除了except都複製出來，給排列問題用
    public static int[] slice(int[] data, int except) {
        int[] result = new int[data.length-1];
        for (int  i = 0, at = 0; i < data.length; i++) {
            if (at != except) {
                result[at++] = data[i];
            }
        }
        return result;
    }
    public static void comb(int[] data, int n) {
        comb(data, n, new int[0]);
    }
    public static void comb(int[] data, int n, int[] result) {
        if(n == 0) {
            System.out.println(result); // 先隨便寫
            return;
        }
        for (int i = 0; i < data.length; i++) {
            comb(slice(data,i+1,data.length), n-1 , append(result, data[i]));
        }
    }
    public static void append(int[] data, int x) {  
        int[] result = new int[data.length+1];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i] ;
        }
        result[data.length] = x;
        return result;
    public static void comb(String v, int n, String result) {
        if (n == 0) { // 都選好了
            System.out.println(result);
            return;
        }
        // 選擇v的某一個字元，再把剩下可選的，交給下一位同學(recursive call)處理 
        // 有多少種選法
        for (int i = 0; i < v.length(); i++) {
            // 選擇位置i的字元
            comb(v.substring(i+1,v.length()), n-1, result+v.charAt(i));
        }
    }
    // v字串任取n個字元的所有組合
    public static void comb(String v, int n) { // overloading
        comb(v, n, "");
    }
    public static void main(String[] argv) {
        comb("ABCDE", 2); // 印出"ABCDE"任取2個的所有組合
    }
}