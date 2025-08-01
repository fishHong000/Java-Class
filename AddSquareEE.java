import java.util.Scanner;
public class AddSquareEE {
    public static int[] pop(int[] result){
        int[] tmp = new int[result.length-1];
        for(int i = 0; i<result.length-1; i++){
            tmp[i] = result[i];
        }
        return tmp;
    }

    public static void findsol(int[] row, int[] col,int[] result, int d, int n, int pos, int[] board){
        //終止條件
        if (n <= 0){
            if(n == 0){
                for(int i = 0; i<result.length; i++){
                    System.out.print(result[i]+" ");
                }
                System.out.println();
            }
            return;
        }
        //先讓n去減data裡面的質數
        for(int i = pos; i<data.length; i++){
            //把質數放進result
            result = append(result, data[i]);
            findsol(data, n-data[i], result, i+1);
            //要把result還原
            result = pop(result);
        }
    }

    public static int[] append(int [] data, int i){
        //創建一個array是data.length+1的長度的，+1是因為還要再多塞一個
        int[] newprimes = new int[data.length+1];
        //先把先前的值填進去
        for(int j = 0; j < data.length; j++){
            newprimes[j] = data[j];
        }
        //要在最後一個位置塞數字，最後一個位置的index是data.length-1
        newprimes[data.length] = i;
        return newprimes;
    }

    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // 整數n表示方陣大小
        int n = input.nextInt();
        // 輸入n個整數代表最右邊的row目標(圖一的紅字)
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            row[i] = input.nextInt();
        }
        // 再輸入n個整數代表最下面的column的目標(圖二的紅字)
        int[] col = new int[n];
        for (int j = 0; j < n; j++) {
            col[j] = input.nextInt();
        }
        // 放答案的result
        int[] result = new int[0];
        //pos是為了保存上一層迴圈算到的位置
        int pos = 0;
        // 全部有d點
        int d = 2*n-1;
        this.board = new int[n*n];
        findsol(row, col, result, d, n, pos, board);
    }
}