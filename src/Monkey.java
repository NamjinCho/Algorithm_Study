import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-14.
 */
public class Monkey {
    static class Ele{
        int row;
        int col;
        int cost;
        int jump;
        Ele(int r, int c, int co,int j)
        {
            row =r;
            col = c;
            cost = co;
            jump = j;
        }
    }
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

        ans = bfs();
        System.out.println(ans);
    }

    public static int bfs()
    {
        boolean visit[][][] = new boolean[K+1][R][C];
        Queue<Ele> q = new LinkedList<>();
        q.offer(new Ele(0,0,0,0));
        visit[0][0][0] = true;
        while(!q.isEmpty())
        {
            Ele e = q.poll();

            for(int i=0;i<12;i++)
            {
                int nr = e.row+dir[i][0];
                int nc = e.col + dir[i][1];

                if(i>=4 && e.jump >=K)
                    continue;

                if(nr>=0 && nr < R && nc >=0 && nc<C)
                {
                    if(nr==R-1 && nc==C-1)
                    {
                        return e.cost+1;
                    }
                    if(map[nr][nc]==0) {
                        if (i < 4) {
                            if (!visit[e.jump][nr][nc]) {
                                visit[e.jump][nr][nc] = true;
                                q.offer(new Ele(nr, nc, e.cost + 1, e.jump));
                            }
                        } else {
                            if (!visit[e.jump + 1][nr][nc]) {
                                visit[e.jump + 1][nr][nc] = true;
                                q.offer(new Ele(nr, nc, e.cost + 1, e.jump + 1));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

}
