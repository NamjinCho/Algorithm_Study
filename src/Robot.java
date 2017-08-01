import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-31.
 */
public class Robot {


    static int N, M, board[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int cr, cc, dr, dc, cd, dd;
        cr = sc.nextInt();
        cc = sc.nextInt();
        cd = changeDir(sc.nextInt());
        dr = sc.nextInt();
        dc = sc.nextInt();
        dd = changeDir(sc.nextInt());
        System.out.println(bfs(cr, cc, dr, dc, cd, dd));
    }

    public static int bfs(int row, int col, int dr, int dc, int cd, int dd) {
         if (row == dr && dc == col && dr == cd)
            return 0;
        boolean visit[][][] = new boolean[4][N + 1][M + 1];
        visit[cd][row][col] = true;
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int ch[] = {1, -1};
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(row, col, 0, cd));
        while (!que.isEmpty()) {
            Node n = que.poll();
           for (int i = 0; i < 2; i++) {
                int ndir = n.dir + ch[i];

                if (ndir == 4)
                    ndir = 0;
                if (ndir == -1)
                    ndir = 3;

                if (!visit[ndir][n.row][n.col]) {
                    if (ndir == dd && n.row == dr && n.col == dc)
                        return n.cost + 1;
                    visit[ndir][n.row][n.col] = true;
                    que.offer(new Node(n.row, n.col, n.cost + 1, ndir));
                }
            }
            for (int i = 1; i <= 3; i++) {
                int nr = n.row + (dir[n.dir][0] * i);
                int nc = n.col + (dir[n.dir][1] * i);
                if (nr >= 1 && nr <= N && nc >= 1 && nc <= M) {
                    boolean f = true;

                    for (int j = 1; j < i; j++) {
                        if (board[n.row + (dir[n.dir][0] * j)][n.col + (dir[n.dir][1] * j)] == 1) {
                            f = false;
                            break;
                        }
                    }

                    if (!visit[n.dir][nr][nc] && f && board[nr][nc] == 0) {
                        if (n.dir == dd && nr == dr && nc == dc)
                            return n.cost + 1;

                        visit[n.dir][nr][nc] = true;
                        que.offer(new Node(nr, nc, n.cost + 1, n.dir));
                    }
                }
            }
        }
        return 0;
    }

    public static int changeDir(int dir) {
        if (dir == 1)
            return 0;
        else if (dir == 2)
            return 2;
        else if (dir == 3)
            return 1;
        else
            return 3;
    }

    static class Node {
        int row;
        int col;
        int cost;
        int dir;

        Node(int r, int c, int cc, int d) {
            row = r;
            col = c;
            cost = cc;
            dir = d;
        }
    }
}
