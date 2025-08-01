// 學號：108213010 姓名：洪瑄妤
import java.util.Scanner;
class Restaurant {
    //屬性
    String name;
    int min, Max;
    //建構子
    public Restaurant(String name, int min, int Max) {
        this.name = name;
        this.min = min;
        this.Max = Max;
    }
}
public class FindMeal {
    // 有1家餐廳符合條件，就輸出那家餐廳的 "店名"
    // 有2家餐廳以上符合條件，請輸出 "有選擇困難"
    // 如果預算開太高就輸出 "預算出太多了"
    // 如果預算開太低就輸出 "預算出太少了"
    // 剩餘情況印出 "買不了"
    public static void Search(int n, Restaurant[] information, int m, int[] budget) {
        // 檢查m次, 因為有m個預算
        // 如果在這家餐廳
        for (int i = 0; i < m; i++) {
            // 有幾家餐廳符合預算
            int x = 0;
            // 有哪幾家餐廳
            String result = "";
            for (int j = 0; j < n; j++) {
                if (information[j].min <= budget[i] && budget[i] <= information[j].Max) {
                    // 名字放進去result
                    result = information[j].name;
                    x = x + 1;
                }
            }
            if (x == 1) {
                System.out.println(result);
            }
            if (x > 1) {
                System.out.println("有選擇困難");
            }
            if (x < 1) {
                int Maxnum = 0;
                int minnum = 0;
                for (int p = 0; p < n; p++) {
                    if (budget[i] > information[p].Max) {
                        Maxnum = Maxnum + 1;
                        if (Maxnum == n) {
                            System.out.println("預算出太多了");
                        }
                    }
                    if (budget[i] < information[p].min) {
                        minnum = minnum + 1;
                        if (minnum == n) {
                            System.out.println("預算出太少了");
                        }
                    }
                    
                }
                if (Maxnum<n && minnum<n) {
                    System.out.println("買不了");
                }
            }
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // 輸入n
        int n = input.nextInt();
        // 輸入n家餐廳資訊
        // 每筆餐廳資訊分別有店名,最低價格,最高價格
        Restaurant[] information = new Restaurant[n];
        for (int i = 0; i < n; i++) {
            information[i] = new Restaurant(input.next(), input.nextInt(), input.nextInt());
        }
        // 輸入m
        int m = input.nextInt();
        // 輸入m次要搜尋的預算
        int[] budget = new int[m];
        for (int i = 0; i < m; i++) {
            budget[i] = input.nextInt();
        }
        Search(n, information, m, budget);
    }
}