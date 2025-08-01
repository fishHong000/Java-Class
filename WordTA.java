import java.util.Scanner;
public class WordTA {
    static String[][] data; // ��l���
    static int found; // �w���X��
    static String[] matchedWord; //��쪺��r
    static String[] dict; // �n�䪺��r
    static int row, col, words;
    public static void tryMatch(StringBuffer sb) {
        for (int i = 0; i < words; i++) { // check each word in dict
            if (sb.indexOf(dict[i])!=-1 || sb.reverse().indexOf(dict[i])!=-1) {
                // isert to matchedWord
                int pos = found - 1;
                while (pos >= 0 && matchedWord[pos].compareTo(dict[i]) > 0) {
                    matchedWord[pos+1] = matchedWord[pos];
                    pos--;
                }
                matchedWord[pos+1] = dict[i];
                found++;
                dict[i] = dict[--words]; // remove this from from dictionary
            }
        }
    }
    public static void printResult() {
        for (int i = 0; i < found; i++) {
            System.out.println(matchedWord[i]);
        }
    }
    public static void findSol() {
        // ��X�C��row���r��, row��x=0�}�l
        for (int line = 0; line < row; line++) {
            genLine(0, line, 1, 0);
        }
        // ��X�C��col���r��, col��y=0�}�l
        for (int line = 0; line < row; line++) {
            genLine(line, 0, 0, 1);
        }
        // ��X�C�ӥk�W�ת��r��, x+1,y-1, ��x=0,��y=row-1�}�l
        for (int line = 0; line < row; line++) {
            genLine(0, line, 1, -1);
        }
        for (int line = 1; line < col; line++) {
            genLine(line, row-1, 1, -1);
        }
        // ��X�C�ӥk�U�ת��r��, x+1,y+1, ��x=0,��y=0�}�l
        for (int line = 0; line < col; line++) {
            genLine(line, 0, 1, 1);
        }
        for (int line = 1; line < row; line++) {
            genLine(0, line, 1, 1);
        }
        printResult();
    }
    public static void genLine(int x, int y, int xoff, int yoff) {
        StringBuffer sb = new StringBuffer();
        while (x < col && x >= 0 && y < row && y >= 0) {
            sb.append(data[y][x]);
            x += xoff;
            y += yoff;
        }
        tryMatch(sb);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        col = input.nextInt();
        row = input.nextInt();
        words = input.nextInt();
        data = new String[row][col];
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                data[i][j] = input.next();
            }
        }
        dict = new String[words];
        matchedWord = new String[words];
        for (int i = 0; i < words; i++)
            dict[i] = input.next();
        findSol();
    }
}