import java.util.Scanner;
class Stack {
    private int top;
    private int[] data = new int[1000];
    public void push(int v) { // �⪫�����J���|(stack)�Ŷ������A�öǦ^�s�����|
        data[top++] = v;
    }
    public int pop() { // �������|(stack)�Ŷ�����������
        return data[--top];
    }
    public boolean isEmpty() { // ���հ��|(stack)�Ŷ��O�_���Ū���k
        return top == 0;
    }
    public int peek() { // �����|(stack)�Ŷ����I����
        return data[top-1];
    }
}
public class ReduceFormula {
    Stack s = new Stack();
    public static int eval(String e) {
        return eval(e.toCharArray()); // toCharArray, �N�r�Ŧ��H�����r�Ŧ��ഫ���@�Ӧr�żƲ�
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
        int act = op.pop(); // pop, �ç@������ƪ��Ȫ�^�Ӫ���Ǧ^�s�����|
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
    public static int eval(char[] exp) { // char�O�r��, �W�rexp
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
        // �פ����, �����䧹��
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
        System.out.println(eval("1+2*3*4/2-2")); // eval��ƥi�H����Y�@�q�r��]String�^���B��
        Scanner input = new Scanner(System.in);
        Stack s = new Stack();
        // �����ǼƦr
        String number = input.next();
        // ��X�Ӫ�����
        String answer = input.next();
        String result = new String();
        int n = number.length();
        String[] w = new String[]{"+", "-", "*", "/"};
        findSol(number, answer, n, result, 0, e);
    }
}