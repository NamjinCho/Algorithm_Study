import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-14.
 */
public class Monkey {
    static int K;
    static int R, C;
    static int[][] map;
    static boolean[][] visit;
    static int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        C = sc.nextInt();
        R = sc.nextInt();
        map = new int[R][C];
        visit = new boolean[R][C];
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0, 0, 0);
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }


    public static void dfs(int row, int col, int k, int count) {
        if (row == R - 1 && col == C - 1) {
            ans = Math.min(count, ans);
        }
        for (int i = 0; i < 12; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0) {
                if (!visit[nr][nc]) {
                    if (i < 4) {
                        visit[nr][nc] = true;
                        dfs(nr, nc, k, count + 1);
                        visit[nr][nc] = false;
                    } else {
                        if (k < K) {
                            visit[nr][nc] = true;
                            dfs(nr, nc, k+1, count + 1);
                            visit[nr][nc] = false;
                        }
                    }
                }
            }
        }

    }
}
