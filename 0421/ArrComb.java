public class ArrComb {
    public static void print(int[] data) {
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
        }
        System.out.println();
    }
    public static void comb(int[] data, int n, int pos, int got, int[] result) {
        // 終止條件，選完了 n 個，因此終止條件就是 n == 0
        if (n == 0) {
            print(result);
            return;
        }
        for(int i = pos; i < data.length; i++) {
            result[got] = data[i] ;
            comb(data, n - 1, i + 1, got + 1, result);
        }
    }
    public static void comb(int[] data, int n) {
        comb(data, n, 0, 0, new int[n]);
    }
    public static void main(String[] argv) {
        int[] data = new int[]{1, 2, 3, 4, 5};
        comb(data, 2);
    }
}