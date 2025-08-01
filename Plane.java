import java.util.Scanner;
class Flights {
    String name, beginning, ending;
    int price;
    public Flights(String name, String beginning, String ending, int price) {
        this.name = name;
        this.beginning = beginning;
        this.ending = ending;
        this.price = price;
    }
}
public class Plane {
    // n班航班, 最初起點, 最終點, 放可以搭的航班, 航班資訊, 總共要花多少錢, 放了幾個航班
    public static void findSol(int n, String begin, String end, String[] result, Flights[] data, int money, int num) {
        // 終止條件, 找到一組解印出
        // 如果下一個航班的起點 等於 最終點 -> 抵達！
        if (begin.equals(end)) {
            for (int i = 0; i < num; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
            System.out.println(money);
            return;
        }
        if (num >= 4) {
            return;
        }
        String tmp;
        for (int i = 0; i < n; i++) {
            // 如果下一班航班的起點 等於 上一班的終點
            if (data[i].beginning.equals(begin)) {
                result[num] = data[i].name;
                begin = data[i].ending;
                findSol(n, begin, end, result, data, money+data[i].price, num+1);
                begin = data[i].beginning;
            }
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // 總航班數
        int n = input.nextInt();
        // 起點
        String begin = input.next();
        // 終點
        String end = input.next();
        // 航班名稱 起點 終點 班機價錢
        Flights[] data = new Flights[n]; // 給長度
        for (int i = 0; i < n; i++) {
            data[i] = new Flights(input.next(), input.next(), input.next(), input.nextInt());
        }
        String[] result = new String[n];
        findSol(n, begin, end, result, data, 0, 0);
    }
}