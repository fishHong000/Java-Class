import java.util.Scanner;
public class PrimeAdd{
    public static int[] pop(int[] result){
        int[] tmp = new int[result.length-1];
        for(int i = 0; i<result.length-1; i++){
            tmp[i] = result[i];
        }
        return tmp;
    }
    public static void findsol(int [] data, int n, int[] result, int pos){
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
    public static boolean isPrime(int x){
        //return ture:是質數
        //return false:非質數
        if (x==1){
            return false;
        }
        if (x==2){
            return true;
        }
        if(x % 2 == 0){
            return false;
        }
        int num = 3;
        while(num*num<=x){
            if(x % num ==0){
                return false;
            }
            num = num +2;
        }
        return true;
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        //放答案的result
        int[] result = new int[0];
        //pos是為了保存上一層迴圈算到的位置
        int pos = 0;
        //n是我們的目標
        int n = input.nextInt();
        //創一個array放"<n的質數"
        int [] data = new int[]{2, 3};
        for(int i = 5; i<n; i++){
            if(isPrime(i) == true){
                data = append(data, i);
            }
        }
        findsol(data, n, result, pos);
    }
}