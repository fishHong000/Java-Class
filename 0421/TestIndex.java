class MyException extends Exception {
}
public class TestIndex {
    public static void print(int[] x) {
        for (int i = 0; i <= x.length; i++) {
            System.out.println(x[i]);
        }
    }
    public static void troubleFunction() throws MyException {
        int x = 0; // whatever
        throw new MyException(); // create a MyException and throw it
    }
    public static void main(String[] argv) {
        int[] x = new int[5];
        // �w�q�bjava.lang.*����Exception, �i�H���ݭntry catch
        try {
            print(x);
            int y = Integer.valueOf("14");
            troubleFunction();
        } catch(ArrayIndexOutOfBoundsException e1) {
            System.out.println("�A�̳J�աA�}�C���ާ˿��F");
        } catch(NumberFormatException e2) {
            System.out.println("�A�k���A�Q�⤣�O��ƪ��r�����ƶ�");
            e2.printStackTrace();
        } catch(Exception e3) {
            System.out.println("�A���b�A�禺���������D");
            e3.printStackTrace();
        } finally {
            System.out.println("�ާA���S�����A�ڴN�O�n���A�@�U");
        }
    }
}    