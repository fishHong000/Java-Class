import java.util.Scanner;
public class WordOldfish {
    static String[][] data; // 原始資料
    static int found; // 已找到幾個
    static String[] matchedWord; //找到的單字
    static String[] dict; // 要找的單字
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
        // 找出每個row的字串, row由x=0開始
        for (int line = 0; line < row; line++) {
            int x = 0;
            int y = line;
            StringBuffer sb = new StringBuffer();
            while (x < col)
                sb.append(data[y][x++]);
            tryMatch(sb);
            System.out.println(sb);
        }
        // 找出每個col的字串, col由y=0開始
        for (int line = 0; line < row; line++) {
            int x = line;
            int y = 0;
            StringBuffer sb = new StringBuffer();
            while (y < row)
                sb.append(data[y++][x]);
            tryMatch(sb);
            System.out.println(sb);
        }
        // 找出每個右上斜的字串, x+1,y-1, 由x=0,或y=row-1開始
        for (int line = 0; line < row+col-1; line++) {
            int x = 0;
            int y = line;
            if (y >= row) { // 跑到下面了啦
                y = row-1;
                x = line - row + 1;
            }
            StringBuffer sb = new StringBuffer();
            while (x<col && y >= 0)
                sb.append(data[y--][x++]);
            System.out.println(sb);
            tryMatch(sb);
        }
        // 找出每個右下斜的字串, x+1,y+1, 由x=0,或y=0開始
        printResult();
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