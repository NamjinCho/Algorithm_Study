import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-26.
 */
public class SWTestA {
    static int N;
    static int M;
    static int board[][];
    static int dir[][] = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};// ru rd ld lu
    static int sRow, sCol;
    static int []list = new int[160];
    static int ans = 0;
    static int lineCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sRow = i;
                sCol = j;
                lineCount = 1;
                list = new int[160];
                list[0]=board[i][j];
                dfs(i, j, 0, 1);

            }
        }
        System.out.println(ans);
    }

    public static void dfs(int row, int col, int pd, int count) {
        if (count != 1 && row == sRow && col == sCol && lineCount == 4) {
            ans = Math.max(ans, count);
            for(int i=0;i<count;i++)
            {
                System.out.print(list[i]+" ");
            }
            System.out.println();
            return;
        }
        if(lineCount > 4)
            return;
       // System.out.println(row + "/"+col);
        for (int i = 0; i < 4; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
     //       System.out.println(i);
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (!isContain(board[nr][nc],count)) {
                    list[count] = board[nr][nc];
                    if (count != 1 && i != pd) {
                        lineCount++;
                        dfs(nr, nc, i, count + 1);
                        lineCount--;
                    } else {
                        dfs(nr, nc, i, count + 1);
                    }
                    list[count]=0;
                }else if(sRow == nr && nc==sCol)
                {
                    if(lineCount==3 && i!=pd) {
                        lineCount++;
                        dfs(nr, nc, i, count);
                        lineCount--;
                    }
                }

            }
        }
    }
    public static boolean isContain(int key,int count){
        for(int i=0;i<count;i++)
            if(list[i]==key)
                return true;
        return false;
    }
}
