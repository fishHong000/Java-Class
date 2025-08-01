public class Comb { // �զX���D
    // ��data[start:end]�ƻs�X�s��array�A���զX���D��
    public static int[] slice(int[] data, int start, int end) {
        int[] result = new int[end-start];
        for (int i = start, at = 0, i < end; at++) {
            result[at] = data[i];
        }
        return result;
    }
    // ���Fexcept���ƻs�X�ӡA���ƦC���D��
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
            System.out.println(result); // ���H�K�g
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
        if (n == 0) { // ����n�F
            System.out.println(result);
            return;
        }
        // ���v���Y�@�Ӧr���A�A��ѤU�i�諸�A�浹�U�@��P��(recursive call)�B�z 
        // ���h�ֺؿ�k
        for (int i = 0; i < v.length(); i++) {
            // ��ܦ�mi���r��
            comb(v.substring(i+1,v.length()), n-1, result+v.charAt(i));
        }
    }
    // v�r�����n�Ӧr�����Ҧ��զX
    public static void comb(String v, int n) { // overloading
        comb(v, n, "");
    }
    public static void main(String[] argv) {
        comb("ABCDE", 2); // �L�X"ABCDE"����2�Ӫ��Ҧ��զX
    }
}