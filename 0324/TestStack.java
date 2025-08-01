// 1 + 2 * 3
// 1 2 3 * +
// who to evaluate post fix expression?
// for each input token :
//     if token is number :
//         push(add) token to stack
//     otherwise :
//         pop(delete) two numbers from stack, do operation, then push result
public class TestStack {
    public static void main(String[] argv) {
        eval(new String[]{"1","2","3","*","+"});
    }
    public static void eval(String[] exp) {
        Stack s = new Stack();
        for (int i = 0; i < exp.length; i++) {
            if (exp[i].equals("+")) {
                s.add(s.delete()+s.delete());
            } else if (exp[i].equals("*")) {
                s.add(s.delete()*s.delete());
            } else { // numbers
                s.add(Integer.parseInt(exp[i]));
            }
        }
        System.out.println(s.delete());
    }
}
class Stack {
    private int[] data;
    private int top; // point to 'empty' slot
    public Stack() {
        data = new int[1000];
    }
    public void add(int x) {
        data[top++] = x;
    }
    public int delete() {
        return data[--top];
    }
    public boolean isEmpty() {
        return top == 0;
    }
}