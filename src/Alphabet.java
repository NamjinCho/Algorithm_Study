import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-07.
 */
public class Alphabet{
    static int N,M,ans;
    static char[][] board;
    static int A = 'A';
    static boolean[] visit;
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visit = new boolean[26];
        sc.nextLine();
        board = new char[N][M];
        ans = 0;
        for(int i=0;i<N;i++)
        {
            String line = sc.nextLine();
            for(int j=0;j<M;j++)
            {
                board[i][j]=line.charAt(j);
            }
        }
        dfs(0,0,0);
        System.out.println(ans);
    }
    public static void dfs(int row , int col, int count)
    {
        int t = board[row][col] - A;
        if(visit[t]) {
            ans = Math.max(ans,count);
            return;
        }
        visit[t] = true;
        for(int i=0;i<4;i++)
        {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if(nr >=0 && nr < N && nc >=0 && nc <M)
            {
                dfs(nr,nc,count+1);
            }
        }
        visit[t] = false;
    }


}
