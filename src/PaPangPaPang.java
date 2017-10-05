import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-05.
 */
public class PaPangPaPang {


    static char[][] map;
    static boolean visit[][];
    static int N;
    static int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            sc.nextLine();
            map = new char[N][N];
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '*')
                        visit[i][j] = true;
                }
            }
            int ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                      int co = bfs(i,j);

                      if(co==1)
                      {
                          visit[i][j]=false;
                          continue;
                      }

                      ans++;
                    }
                }
            }
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(!visit[i][j])
                        ans++;
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }

    public static int check(int row, int col) {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (map[nr][nc] == '*')
                    return 1;
            }
        }
        return result;
    }

    public static int bfs(int row, int col) {
        visit[row][col] = true;
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        rq.offer(row);
        cq.offer(col);
        int count =1;
        while (!rq.isEmpty()) {
            int r = rq.poll();
            int c = cq.poll();
            if (check(r, c) != 0) {
                continue;
            }
            count++;
            for (int i = 0; i < 8; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (!visit[nr][nc]) {
                        visit[nr][nc] = true;
                        rq.offer(nr);
                        cq.offer(nc);
                    }
                }
            }
        }
        return count;
    }
}
