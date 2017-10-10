import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-25.
 */
public class Fire {

    static int N, M;
    static char board[][];
    static int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int cost[][];
    static int ans = Integer.MAX_VALUE;

    static class Pair {
        int row;
        int col;
        boolean isFire;

        Pair(int r, int c, boolean f) {
            row = r;
            col = c;
            isFire = f;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;
        try {
            line = br.readLine();

        N = Integer.parseInt(line.split(" ")[0]);
        M = Integer.parseInt(line.split(" ")[1]);
        board = new char[N][M];
        int row = 0;
        int col = 0;
        Queue<Pair> fq = new LinkedList<>();
        ans = Integer.MAX_VALUE;
        Pair h = new Pair(-1, -1, false);
        for (int r = 0; r < N; r++) {
            line = br.readLine();
            for (int c = 0; c < M; c++) {
                board[r][c] = line.charAt(c);
                if (board[r][c] == 'F') {
                    Pair f = new Pair(r, c, true);
                    fq.offer(f);
                } else if (board[r][c] == 'J') {
                    row = r;
                    col = c;
                    h = new Pair(r, c, false);
                }
            }
        }
        if (h.row == -1 && h.col == -1) {
            bw.write("IMPOSSIBLE\n");
            return;
        }

        fq.offer(h);
        ans = bfs(fq);
        if (row == 0 || row == N - 1 || col == 0 || col == M - 1)
            bw.write("1\n");
        else if (ans == -1)
            bw.write("IMPOSSIBLE\n");
        else
            bw.write((ans + 1)+"\n");


        bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int bfs(Queue<Pair> q) {

        cost = new int[N][M];

        while (!q.isEmpty()) {
            Pair f = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = f.row + dir[i][0];
                int nc = f.col + dir[i][1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {

                    if (f.isFire) {
                        if (board[nr][nc] == '#' || board[nr][nc] == 'F')
                            continue;
                        Pair np = new Pair(nr, nc, true);
                        q.offer(np);
                        board[nr][nc] = 'F';
                    } else {
                        if (board[nr][nc] == 'J' || board[nr][nc] == '#' || board[nr][nc] == 'F') {
                            continue;
                        } else {
                            Pair np = new Pair(nr, nc, false);
                            q.offer(np);
                            cost[nr][nc] = cost[f.row][f.col] + 1;
                            board[nr][nc] = 'J';
                            if (nr == 0 || nr == N - 1 || nc == 0 || nc == M - 1) {
                                return cost[nr][nc];
                            }
                        }
                    }
                }

            }
        }
        return -1;
    }
}
