// �ƦC
public class AllDigit {
    public static void perm(String data, int n, String result){ //�g���j���Ĥ@��Ʊ��A�g�פ����!!
        if(n == 0){ //�]�`��n=9�A�C��@�ӼƦrn-1�A��n=0�N��Ʀr��(�פ����)
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
        for(int i = 0; i < data.length(); i++){ //substring���Φr��
            perm(data.substring(0,i) + data.substring(i+1,data.length()), n-1, result+data.charAt(i));
        }
    }
    public static void perm(String data,int n){
        perm(data, n, "");
    }
    public static void main(String[] argv){
        // �� 1~9 ���Ʀr
        perm("123456789", 9);
    }
}