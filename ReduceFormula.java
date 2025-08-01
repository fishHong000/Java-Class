import java.util.Scanner;
class Stack {
    private int top;
    private int[] data = new int[1000];
    public void push(int v) { // 把物件壓入堆疊(stack)空間頂部，並傳回新的堆疊
        data[top++] = v;
    }
    public int pop() { // 移除堆疊(stack)空間頂部的物件
        return data[--top];
    }
    public boolean isEmpty() { // 測試堆疊(stack)空間是否為空的方法
        return top == 0;
    }
    public int peek() { // 取堆疊(stack)空間頂點物件
        return data[top-1];
    }
}
public class ReduceFormula {
    Stack s = new Stack();
    public static int eval(String e) {
        return eval(e.toCharArray()); // toCharArray, 將字符串對象中的字符串轉換為一個字符數組
    }
    private static int isp(int c) {
        if (c == '+' || c == '-')
            return 0;
        return 1;
    }
    private static int icp(int c) {
        if (c == '+' || c == '-')
            return 0;
        return 1;
    }
    private static Stack op = new Stack(), num = new Stack();
    private static void doOp() {
        int act = op.pop(); // pop, 並作為此函數的值返回該物件傳回新的堆疊
        if (act == '+') {
            num.push(num.pop()+num.pop());
        } else if (act == '-') {
            int tmp = num.pop();
            num.push(num.pop()-tmp);
        } else if (act == '*') {
            num.push(num.pop()*num.pop());
        } else if (act == '/') {
            int tmp = num.pop();
            num.push(num.pop()/tmp);
        }
    }
    public static int eval(char[] exp) { // char是字符, 名字exp
        for (int i = 0; i < exp.length; i++) {
            if (exp[i]=='+' || exp[i]=='-' || exp[i]=='*' || exp[i]=='/') {
                while (!op.isEmpty() && icp(exp[i]) <= isp(op.peek())) {
                    doOp();
                }
                op.push((int)exp[i]);
            } else {
                num.push(exp[i]-'0');
            }
        }
        while (!op.isEmpty()) {
            doOp();
        }
        return num.pop();
    }
    public static void findSol(String number, String answer, int n, String result, int count, String[] e) {
        // 終止條件, 全部找完後
        if (n == 1 && eral(result+number[n])==Integer.valueOf(number)) {
            System.out.println(result+number[n]);
            System.out.println();
            return;
        }
            System.out.println(result);
            return;
        }
        for (int i = 0; i < e.length(); i++) {
            if ()
            findSol(number, answer, n-1, number.substring[i,i+1]+result+e.charAt(i), count+1, e.substring(i+1,v.length());
        }
    }
    public static void main(String[] args) {
        System.out.println(eval("1+2*3*4/2-2")); // eval函數可以執行某一段字串（String）的運算
        Scanner input = new Scanner(System.in);
        Stack s = new Stack();
        // 有哪些數字
        String number = input.next();
        // 算出來的答案
        String answer = input.next();
        String result = new String();
        int n = number.length();
        String[] w = new String[]{"+", "-", "*", "/"};
        findSol(number, answer, n, result, 0, e);
    }
}