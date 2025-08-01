// ????G108213010 ?m?W?G?x???
// 1+2*3
// ???m?????m??,???k?p?U
// ?????w?q??? "?u??????"
// icp : incoming priority, ???????|???i?J???|????u???v
// isp : in stack priority, ???????w?b???|??????u???v
// ?C??B?????????W?z????u???v. ?t??k :
// ?p?G??J?O??r, ?h????X
// ?p?G?O?B???? :
//     ?? ???|?????? ?B ??J??icp < ???|??W????isp ?? :
//         delete stack and output
//     add ??J???B?????? stack
// ????????F, ?h?M??stack and output
// how to define icp and isp?
// ?u???v????, ??r?]?j??
// ?????X?????, icp and isp?]?@??j
// ?k???X?????, icp = isp+1, ?]?N?Oicp????j(?]??????????j)
// ?S??W?h, "(" ??icp??j, ??isp??p
// ?S??W?h, ???")" ,?h????delete stack, ????o?{"("????
// +-*/???]icp and isp?O?
//       ( + - * / **
// icp : 5 1 1 2 2 4
// isp : 0 1 1 2 2 3
// (1+2)*3 - 5**6
//stack:
//output: 1 2 + 3 * 5 6 ** -
import java.util.Scanner;
public class TestStack {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        toPost(input.next());
        // 1 2 + 3 * 5 6 ** - // ?q??W????(????)?}?l??A???e????r???B??
        // 6**5-3*(2+1)
    }
    public static boolean isOp(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("**") || s.equals("(");
    }
    public static int isp(String s) {
        String[] ops = new String[]{"(","+","-","*","/","**"};
        int[] pri = new int[]{0,1,1,2,2,3};
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals(s)) { // .equals(s) -> ?P?_?e????"?r??"?O?_????s?o??r
                return pri[i];
            }
        }
        return -1; // ?h???a
    }
    public static int icp(String s) {
        String[] ops = new String[]{"(","+","-","*","/","**"};
        int[] pri = new int[]{5,1,1,2,2,4};
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals(s)) {
                return pri[i];
            }
        }
        return -1; // ?h???a
    }
    // ?H??m????X
    public static void toPost(String expression) {
        Stack s = new Stack();
        Token t = new Token(expression);
        String exp;
        while ((exp = t.next()) != null) {
            if (exp.equals(")")) {
                String op;
                // ?@?????X??,??????'('
                while (!s.isEmpty() && !(op=s.delete()).equals("(")) {
                    System.out.print(op+" ");
                }
            } else if (isOp(exp)) { // ?Y???B????
                // ???X???isp >= icp???B????
                while (!s.isEmpty() && isp(s.peek()) >= icp(exp)) {
                    System.out.print(s.delete()+" ");
                }
                // ?????v?[?Jstack
                s.add(exp);
            } else { // ?O??r
                System.out.print(exp+" ");
            }
        }
        // empty stack
        while (!s.isEmpty()) {
            System.out.print(s.delete()+" ");
        }
    }
}

class Token {
    String data; //??J???B???r??
    int pos;//?????m
    public Token(String s) {
        data = s;
    }
    // null if no more
    public String next() {
        // skip all space and tab and new line
        while (pos < data.length() && (data.charAt(pos)==' ' || data.charAt(pos)=='\t')) {
            pos++;
        }
        if (pos == data.length()) {
            return null;
        }
        // ?P?_?}?Y?O????F??
        if (data.charAt(pos) == '+') {
            pos++;
            return "+";
        } else if (data.charAt(pos) == '-') {
            pos++;
            return "-";
        } else if (data.charAt(pos) == '*') {
            pos++;
            if (pos < data.length() && data.charAt(pos)=='*') {
                pos++;
                return "**";
            } else {
                return "*";
            }
        } else if (data.charAt(pos) == '/') {
            pos++;
            return "/";
        } else if (data.charAt(pos) == '(') {
            pos++;
            return "(";
        } else if (data.charAt(pos) == ')') {
            pos++;
            return ")";
        } else { // ??r
            int start = pos;
            while (pos < data.length() && data.charAt(pos)>='0' && data.charAt(pos)<='9') {
                pos++;
            }
            return data.substring(start, pos);
        }
    }
}
class Stack {
    // attribute
    private String[] data;
    private int top; // point to 'empty' slot
    // constructor
    public Stack() {
        data = new String[1000];
    }
    // method
    public void add(String x) {
        data[top++] = x;
    }
    public String delete() {
        return data[--top];
    }
    public String peek() {
        return data[top-1];
    }
    public boolean isEmpty() {
        return top == 0;
    }
}