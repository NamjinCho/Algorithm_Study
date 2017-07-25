import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-24.
 */
public class Tetronomino {

    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    static int board[][];
    static int block[]=new int[4];
    static int N,M;
    static int ans=0;
    static boolean visit[][];
    public static void main(String args [])
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        //visit = new boolean[N][M];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                board[i][j] = sc.nextInt();
            }
        }

        visit= new boolean[N][M];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                //bfs(i,j);
                check(i,j);
                visit[i][j]=true;
                dfs(i,j,1,board[i][j]);
                visit[i][j]=false;
            }
        }
        System.out.println(ans);
    }
    public static void dfs(int row,int col,int count,int sum)
    {
        if(count==4)
        {
            ans=Math.max(sum,ans);
            return;
        }

        for(int i=0;i<4;i++)
        {
            int nr = row+dir[i][0];
            int nc = col+dir[i][1];
            if(nr>=0 && nr<N && nc>=0 && nc<M)
            {
                if(visit[nr][nc])
                    continue;

                visit[nr][nc] = true;
                dfs(nr,nc,count+1,sum+board[nr][nc]);
                visit[nr][nc]=false;

            }
        }

    }
    public static void check(int row,int col)
    {

        int bd[][][]={
                {{0,-1},{-1,0},{0,1}},
                {{0,-1},{1,0},{0,1}},
                {{-1,-1},{0,-1},{1,-1}},
                {{1,1},{-1,1},{0,1}}};
        for(int c=0;c<4;c++)
        {
            int sum=board[row][col];

            for(int i=0;i<3;i++)
            {
                int nr = row+bd[c][i][0];
                int nc = col+bd[c][i][1];
                if(nr>=0 && nr<N && nc>=0 && nc<M)
                {
                    sum += board[nr][nc];
                }else
                    break;
            }
            ans=Math.max(sum,ans);
        }
    }
}

