import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-02.
 */
public class ClimbPath {

    static int N;
    static int K;
    static int ans;
    static int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int arr[][];
    static boolean visit[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();
            ans = 0;
            arr = new int[N][N];
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                    max = Math.max(arr[i][j], max);
                }
            }
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == max) {
                       visit[i][j] = true;
                        dfs(i, j, 1, false);
                        visit[i][j] = false;
                    }
                }
            }
            System.out.println("#" + tc + " " + ans);

        }
    }

    public static void dfs(int row, int col, int count, boolean check) {

        for (int i = 0; i < 4; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {

                if(visit[nr][nc]==true)
                    continue;

                if (arr[nr][nc] < arr[row][col]) {
                    // System.out.println("DE : " + count + " / " + "("+row+"/"+col+")" +" -> ("+nr+"/"+nc+")");
                    visit[nr][nc] = true;
                    dfs(nr, nc, count + 1, check);
                    visit[nr][nc] = false;

                } else {
                    if (check == false && (K >= arr[nr][nc] - arr[row][col] + 1)) {
                        int tmp = arr[nr][nc];
                        arr[nr][nc] = arr[row][col] - 1;
                        //System.out.println("DE : " + count + " / " + "(" + row + "/" + col + ")" + " -> (" + nr + "/" + nc + ")");
                        visit[nr][nc] = true;
                        dfs(nr, nc, count + 1, true);
                        visit[nr][nc] = false;
                        arr[nr][nc] = tmp;
                    }
                }
            }
        }
        ans = Math.max(ans, count);
    }

}
