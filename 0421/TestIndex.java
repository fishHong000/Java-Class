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
        // 定義在java.lang.*內的Exception, 可以不需要try catch
        try {
            print(x);
            int y = Integer.valueOf("14");
            troubleFunction();
        } catch(ArrayIndexOutOfBoundsException e1) {
            System.out.println("你傻蛋啦，陣列索引弄錯了");
        } catch(NumberFormatException e2) {
            System.out.println("你糊塗喔，想把不是整數的字串轉整數嗎");
            e2.printStackTrace();
        } catch(Exception e3) {
            System.out.println("你阿呆，怎死的都不知道");
            e3.printStackTrace();
        } finally {
            System.out.println("管你有沒有錯，我就是要念你一下");
        }
    }
}    