import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-25.
 */
public class SwimingPool {

    static int N, M;
    static int[][] map;
    static boolean visit[][];
    static int ans;

    static class Node {
        int row;
        int col;

        Node(int r, int c) {
            row = r;
            col = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            char zero = '0';
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - zero;
            }
        }
        ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    public static void bfs(int row, int col) {
        Node n = new Node(row, col);

        int total = 0;
        visit[row][col] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(n);
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean f = true;
        Queue<Node> q2 = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node t = q.poll();
            q2.offer(t);
            visit[t.row][t.col]=true;
            int count =0;
            for (int i = 0; i < 4; i++) {
                int nr = t.row + dir[i][0];
                int nc = t.col + dir[i][1];
                // System.out.println(nr + " / " + nc);
                if (!(nr >= 0 && nr < N && nc >= 0 && nc < M)) {
                    return;
                } else {
                    if (map[t.row][t.col] <= map[nr][nc]) {
                        min = Math.min(map[nr][nc], min);
                        count++;
                    }
                }
            }

            if(count==4)
                break;
            //System.out.println(row + " - " + col);
            for (int i = 0; i < 4; i++) {
                int nr = t.row + dir[i][0];
                int nc = t.col + dir[i][1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (!visit[nr][nc] && map[t.row][t.col] >= map[nr][nc]) {
                        q.offer(new Node(nr, nc));
                        //visit[nr][nc] = true;
                    }
                }
            }
        }
        //System.out.println(min);

        if(f==false || min==Integer.MAX_VALUE)
            return;
        //System.out.println(row + " " + col);
        while (!q2.isEmpty()) {
            Node t = q2.poll();
            int r = min - map[t.row][t.col];
            if (r < 0) {
                continue;
            }
            System.out.println(t.row + " " + t.col + " " + min + " : " + r);
            total += r;
        }

        ans += total;
    }//3 1 2 3 1 =
}
