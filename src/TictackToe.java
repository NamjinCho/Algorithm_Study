import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-04.
 */
public class TictackToe {
    static char map[], check[];
    static int idx[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {2, 4, 6}, {0, 4, 8}};
    static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        while (!line.startsWith("end")) {
            map = new char[9];
            check = new char[9];
            int x=0,o=0;
            for (int i = 0; i < 9; i++) {
                check[i] = '.';
                map[i] = line.charAt(i);
                if(map[i]=='X')
                    x++;
                else if(map[i]=='O')
                    o++;
            }
            if(x==o+1 || x==o) {
                if (!dfs(0, 'X'))
                    System.out.println("invalid");
                else
                    System.out.println("valid");
            }else
                System.out.println("invalid");
            line = sc.nextLine();
        }

    }

    public static boolean ce() {
        boolean flag;
        for (int i = 0; i < 8; i++) {
            flag = true;

            char s = check[idx[i][0]];

            for (int j = 1; j < 3; j++) {
                if (s != check[idx[i][j]]) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                return true;
        }

        return false;
    }

    public static boolean ce2() {
        boolean f=true;
        for (int i = 0; i < 9; i++) {
            if (map[i] != check[i])
                f=false;
        }
        return f;

    }

    public static boolean dfs(int count, char sym) {
        if (count > 4) {
            if (ce()) {
                return ce2();
            }
        }
        if (count == 9) {
            return ce2();
        }
        boolean f;
        for (int i = 0; i < 9; i++) {
            if (check[i] == '.') {
                check[i] = sym;
                char tmp = sym;
                if (sym == 'X')
                    tmp = 'O';
                else
                    tmp = 'X';
                f = dfs(count + 1, tmp);
                if (f) {

                    return true;
                }
                check[i] = '.';
            }
        }
        return false;
    }

}
