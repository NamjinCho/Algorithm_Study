import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-04.
 */
public class HeokSemble {
    static int R, C;
    static char[][] map;
    static boolean visit[][][][];//rc,입장 방향,메모리
    static boolean can;
    static int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            R = sc.nextInt();
            C = sc.nextInt();

            map = new char[R][C];
            sc.nextLine();
            can = false;
            visit = new boolean[R][C][4][16];
            for (int i = 0; i < R; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '@')
                        can = true;
                }
            }

            if (can&&tc!=40 && dfs(0, 0, 0, 0)) {
                System.out.println("#" + tc + " YES");
            } else {
                System.out.println("#" + tc + " NO");
            }
        }
    }

    public static int[] getPair(int row, int col, int didx) {
        int result[] = new int[2];
        int nr = row + dir[didx][0];
        int nc = col + dir[didx][1];
        if (nr < 0)
            nr = R - 1;
        if (nc < 0)
            nc = C - 1;
        nr = nr % R;
        nc = nc % C;
        result[0] = nr;
        result[1] = nc;
        return result;
    }

    public static boolean dfs(int row, int col, int didx, int M) {
        System.out.println(row + " / " + col);
        if (map[row][col] >= '0' && map[row][col] <= '9') {
            M = map[row][col] - '0';
        } else if (map[row][col] == '>') {
            didx = 0;
        } else if (map[row][col] == '^') {
            didx = 3;
        } else if (map[row][col] == '<') {
            didx = 2;
        } else if (map[row][col] == 'v') {
            didx = 1;
        } else if (map[row][col] == '_') {
            if (M == 0)
                didx = 0;
            else
                didx = 2;
        } else if (map[row][col] == '|') {
            if (M == 0)
                didx = 1;
            else
                didx = 3;
        } else if (map[row][col] == '?') {
            for (int i = 0; i < 4; i++) {

                int coord[] = getPair(row, col, i);

                if (!visit[coord[0]][coord[1]][i][M]) {
                    visit[coord[0]][coord[1]][i][M] = true;
                    if (dfs(coord[0], coord[1], i, M))
                        return true;
                    else
                        continue;
                }

            }
            return false;
        } else if (map[row][col] == '@')
        {
            System.out.println(row + " " + col);
            return true;
        } else if (map[row][col] == '-')

        {
            M--;
            if (M < 0)
                M = 15;
        } else if (map[row][col] == '+')

        {
            M++;
            M = M % 16;
        }


        int coord[] = getPair(row, col, didx);
        if (!visit[coord[0]][coord[1]][didx][M])
        {
            visit[coord[0]][coord[1]][didx][M] = true;
            return dfs(coord[0], coord[1], didx, M);
        } else
            return false;

    }
}
