public class TestValue {
    public static void fun(int x) {
        x = 0;
        y[0] = 100;
        return y;
    }
    
    // 
    // 
    public static void main(String[] argv) {
        // variable in java, a "container" stores value
        int x = 100;
        int[] y = {1};
        // parameters are "passed by value"
        // in the following case, fun(x), the x is "NOT" a value, the x is "expression"
        // the result of expression "x" is 100
        fun(x); // same as fun(100)
        System.out.println(x);
    }
}