import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-29.
 */
public class Jump {

    static int N;
    static int map[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        long r = bfs();
        System.out.println(r);
    }
    public static long bfs() {
        long result = 0;
        boolean[][] visit = new boolean[N][N];
        visit[0][0] = true;
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        rq.offer(0);
        cq.offer(0);
        int dir[][] = {{0, 1}, {1, 0}};
        while (!rq.isEmpty()) {
            int rr = rq.poll();
            int cc = cq.poll();
            for (int i = 0; i < 2; i++) {
                int nr = rr + (map[rr][cc] * dir[i][0]);
                int nc = cc + (map[rr][cc] * dir[i][1]);
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if ((nr == N - 1 && nc == N - 1)) {
                        result++;
                        continue;
                    }
                    rq.offer(nr);
                    cq.offer(nc);
                }
            }
        }
        return result;
    }
}
