public class Comb { // �զX���D
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