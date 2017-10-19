import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-19.
 */
public class PuyoPuyo {

    static char map[][];
    static final int R = 12;
    static final int C = 6;
    static boolean visit[][];

    static class Block {
        int row;
        int col;

        Block(int r, int c) {
            row = r;
            col = c;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new char[R][C];

        for (int r = 0; r < R; r++) {
            String line = sc.nextLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
            }
        }
        int count = 0;
        while (true) {
            Queue<Queue<Block>> dq = new LinkedList<>();
            visit = new boolean[R][C];
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (map[r][c] != '.' && !visit[r][c]) {
                        Queue<Block> result;
                        result = bfs(r, c);
                        if (result.size() >= 4) {
                            dq.offer(result);
                        }
                    }
                }
            }

            if (dq.isEmpty()) {
                break;
            } else {
                //Delete Section
                while (!dq.isEmpty()) {
                    Queue<Block> tq = dq.poll();
                    while (!tq.isEmpty()) {
                        Block b = tq.poll();
                        map[b.row][b.col] = '.';
                    }
                }
            }
            //당기기
            for (int r = R - 2; r >= 0; r--) {
                for (int c = 0; c < C; c++) {
                    if (map[r][c] != '.') {
                        int dr = r;
                        for (int tr = r+1; tr < R; tr++) {
                            if (map[tr][c] != '.')
                                break;
                            else
                                dr = tr;
                        }
                        if(r!=dr)
                        {
                            map[dr][c] = map[r][c];
                            map[r][c]='.';
                        }
                    }
                }
            }
            count++;
        }
        System.out.println(count);
    }

    public static Queue<Block> bfs(int row, int col) {
        visit[row][col] = true;
        Queue<Block> result = new LinkedList<>();
        Queue<Block> q = new LinkedList<>();
        q.offer(new Block(row, col));
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!q.isEmpty()) {
            Block b = q.poll();
            result.offer(b);
            for (int i = 0; i < 4; i++) {
                int nr = b.row + dir[i][0];
                int nc = b.col + dir[i][1];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if (!visit[nr][nc] && map[nr][nc] == map[row][col]) {
                        q.offer(new Block(nr, nc));
                        visit[nr][nc] = true;
                    }
                }
            }
        }
        return result;
    }
}
