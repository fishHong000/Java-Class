 public class ArrPerm {
    public static void print(int[] data) {
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
        }
        System.out.println();
    }
    public static void perm(int[] data, int n, int pos, int got, int[] result) {
        if (n == 0) {
            print(result);
            return;
        }
        for(int i = 0; i < data.length && i != pos; i++) {
            result[got] = data[i] ;
            perm(data, n - 1, pos + 1, got + 1, result);
        }
    }
    public static void perm(int[] data, int n) {
        perm(data, n, 0, 0, new int[n]);
    }    
    public static void main(String[] argv) {
        int[] data = new int[]{1, 2, 3, 4, 5};
        perm(data, 2);
    }
}