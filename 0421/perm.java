public class perm { // �ƦC���D
    public static void perm(String v, int n, String result) {
        if (n == 0) { // ����n�F
            System.out.println(result);
            return;
        }
        // ���v���Y�@�Ӧr���A�A��ѤU�i�諸�A�浹�U�@��P��(recursive call)�B�z 
        // ���h�ֺؿ�k
        for (int i = 0; i < v.length(); i++) {
            // ��ܦ�mi���r�� // charAt = �r��at
            perm(v.substring(0,i)+v.substring(i+1,v.length()), n-1, result+v.charAt(i));
        }
    }
    // v�r�����n�Ӧr�����Ҧ��զX
    public static void perm(String v, int n) { // overloading
        perm(v, n, "");
    }
    public static void main(String[] argv) {
        perm("ABCDE", 2); // �L�X"ABCDE"����2�Ӫ��Ҧ��զX
    }
}