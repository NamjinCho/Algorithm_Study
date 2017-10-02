import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-26.
 */
public class SWTestA {
    static int N;
    static int board[][];
    static int dir[][] = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};// ru rd ld lu
    static int sRow, sCol;
    static int []list = new int[160];
    static int ans = 0;
    static int lineCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++) {
            N = sc.nextInt();
            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            list = new int[160];
            ans = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sRow = i;
                    sCol = j;
                    lineCount = 1;
                    list[board[i][j]] = 1;
                    dfs(i, j, 0, 1);
                    list[board[i][j]]=0;
                }
            }
            System.out.println("#"+tc+" "+ans);
        }
    }

    public static void dfs(int row, int col, int pd, int count) {

        if(lineCount > 4)
            return;

        if (count != 1 && row == sRow && col == sCol && lineCount == 4) {
            ans = Math.max(ans, count);
            return;
        }
        // System.out.println(row + "/"+col);
        for (int i = 0; i < 4; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            //       System.out.println(i);
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (!isContain(board[nr][nc])) {
                    list[board[nr][nc]] = 1;

                    if (count != 1 && i != pd) {
                        lineCount++;
                        dfs(nr, nc, i, count + 1);
                        lineCount--;
                    } else {
                        dfs(nr, nc, i, count + 1);
                    }

                    list[board[nr][nc]]=0;
                }else if(sRow == nr && nc==sCol)
                {
                    if(lineCount==3 && i!=pd) {
                        lineCount++;
                        dfs(nr, nc, i, count);
                        lineCount--;
                        return;
                    }
                }

            }
        }
    }
    public static boolean isContain(int key){
        if(list[key]!=0)
            return true;

        return false;
    }
}
