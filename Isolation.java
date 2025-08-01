// 學號：108213010 姓名：洪瑄妤
import java.util.Scanner;
public class Isolation {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        List allStu = new List(input.nextInt(), input);
        allStu.print(); // 放進去print裡面
        allStu.filter().print(); // 先放進去filter裡面, 再放進print裡面
        allStu.find(input.next()).print();
    }
}
class Student {
    String name, id; // 名字, 學號
    float tem; // 溫度(小數點)
    int history; // 出國史
    public Student(String name, String id, float tem, int history) { // 建構子
        this.name = name;
        this.id = id;
        this.tem = tem;
        this.history = history;
    }
    // 先印出所有學生資料
    public void print() {
        System.out.println("- - - - 全部學生 - - - -");
        System.out.println("姓名	體溫	出國史");
        System.out.println();
        System.out.println(name+"\t"+tem+"\t"+history);
    }
}
class List {
    // 創一個叫data的學生名單
    Student[] data;
    // 幾個學生
    int len;
    // 為一個constructor
    // 用來將輸入傳入class中做初始化class使用
    public List(int max) {
        data = new Student[max];
        len = 0;
    }
    public List(int max, Scanner input) { // 建構子
        this(max); // call自己的constructor, 等同於List(max),但這邊只能用this
        for (int i = 0; i < max; i++) {
            addStu(new Student(input.next(),input.next(),input.nextFloat(),input.nextInt()));
        }
    }
    // allStu(Student s) -> 傳入型態為 Student 的物件,命名為 s
    public void addStu(Student s) {
        data[len++] = s;
    }
    public void print() {
        // 印出
        System.out.println("- - - - 隔離名單 - - - -");
        System.out.println("姓名	體溫	出國史");
        System.out.println();
        
        for (int i = 0; i < len; i++) {
            data[i].print();
        }
    }
    public List filter() {
        List result = new List(len);
        for (int i = 0; i < len; i++) {
            // 如果體溫超過37.4 或 有出國史
            if (data[i].tem > 37.4 || data[i].history >= 1){
                result.addStu(data[i]);
            }
        }
        return result;
    }
    public Student find(String id) {
        for (int i = 0; i < len; i++) {
            if (data[i].id.equals(id)) {
                return data[i];
            }
        }
        // 如果在確定輸入完全不會有空值的時候可以不用
        // 但當輸入有空值沒有return null的話就不會有回傳值
        return null;
    }
}