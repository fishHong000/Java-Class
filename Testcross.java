import java.util.Scanner ;
public class Testcross {
    public static void main(String[] argv) {
        // input of first line : row and column number, r and c
        // then r lines represents Matrix a
        // each line has c floats
        // then another r lines represents Matrix b
        // print out the result of Matrix a + Matrix b
        // input :    output :
        // 3 2 2 3      9 12 15
        // 1 2         19 26 33
        // 3 4         29 40 51
        // 5 6
        // 1 2 3
        // 4 5 6
        Scanner input = new Scanner(System.in);
        int r, c;
        r = input.nextInt();
        c = input.nextInt();
        Matrix a, b; 
        float[][] data = new float[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                data[i][j] = input.nextFloat();
            }
        }           
        a = new Matrix(data);
                
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                data[i][j] = input.nextFloat();
            }
        } 
        b = new Matrix(data);
        a.add(b).print();    
    }
}
class Matrix {
    private int r, c;
    private float[][] data;
    // define a "constructor" for creating Matrix object
    public Matrix(float[][] data) {
        // copy d to data
        r = d.length;
        c = d[0].length;
        this.data = new float[d.length][d[0].length];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                this.data[i][j] = data[i][j];
            }
        }            
    }
    // function name can be dafined more than once,
    // as long as they can be diatinguished by parameter number and
    // this concepts are called "overloading", 
    public Matrix(int row, int col) {
        data = new float[row][col];
        r = row;
        c = col;
    }
    public Matrix add(Matrix b) {
        Matrix d = new Matrix(r,c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int sum = 0;
                for (int k = 0; k < c; k++) {
                    sum += data[i][k] * b.data[k][j];
                }    
                d.data[i][j] = sum;
            }
        }        
        return d;
    }
    public Matrix mul(Matrix b){
       
    }        
    public void print() {
        System.out.println(r+" "+c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (j != 0) {
                    System.out.print(' ');
                }
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
    }        
}    