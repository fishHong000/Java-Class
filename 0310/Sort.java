import java.util.Scanner;
public class Sort {
    // test if in ascending order
    public static boolean sorted(int[] data) {
        // compare each pair
        for (int i = 0; i < data.length-1; i++) {
            if (data[i] > data[i+1]) {
                return false; // not in correct order
            }
        }
        return true;
    }
    // sort data to ascending order, how?
    // insertion sort
    public static void sort(int[] data) {
        // assume we have n sorted elements
        // then how to 'insert' a new element remains it sorted
        // 1 2 3 4 5 6 7 8, try to insert x
        // 1 2 3 4 5 6 6 8 x
        // (1) save 4 to a variable
        // 1 2 3 4 5 6 7 8 __
        // 1 2 3 4 5 6 7 __ 8
        // 1 2 3 4 5 6 __ 7 8 
        // 1 2 3 4 5 __ 6 7 8 
        // 1 2 3 4 __ 5 6 7 8
        // 1 2 3 4 4 5 6 7 8
        // let pos point to the last element
        // while pos>=0 and data[pos] with x not in order
        //     move data[pos] to data[pos+1]
        // put x in data[pos]
        for (int sortedLen = 1; sortedLen < data.length; sortedLen++) {
            int tmp = data[sortedLen]; // 要插入元素
            int pos = sortedLen - 1; // 要比較的位置
            while (pos >= 0 && data[pos] > tmp) {
                data[pos+1] = data[pos];
                pos = pos - 1;
            }
            data[pos+1] = tmp;
        }
    }
    // bubble sort, 氣泡排序法
    public static void bubble(int[] data) {
        // 4 5 2 3 1
        // 4 2 5 3 1
        // 4 2 3 5 1
        // 4 2 3 1 5
        for (int notLen = data.length; notLen > 1; notLen--) {
            // bubble by swap
            for (int i = 0; i < notLen-1; i++) {
                if (data[i] > data[i+1]) {
                    int tmp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = tmp;
                }
            }
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // how many number to test sort
        int n = input.nextInt();
        int[] data = new int[n];
        // generate testing data
        for (int i = 0; i < n; i++) {
            // how to generate integer i, such that a<=i<=b
            // how to generate integer i, such that i <= 100
            // 0 <= random()<1
            // 0 <= random()*i < i
            // 0 <= random()*(b-a+1) < b-a+1
            // a <= random()*(b-a+1)+a < b+1
            // a <= (int)(random()*(b-a+1)+a) <= b
            data[i] = (int)(Math.random()*1000000);
        }
        sort(data);
        if (sorted(data)) {
            System.out.println("correct");
        } else {
            System.out.println("error!");
        }
    }
}