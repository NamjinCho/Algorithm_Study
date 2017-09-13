import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-13.
 */
public class Panda {
    static int N;
    static int arr[][];
    static int visit[][];
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        visit = new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(visit[i][j]==0)
                {
                    ans = Math.max(dfs(i,j),ans);
                }else{
                    ans = Math.max(visit[i][j],ans);
                }
            }
        }

        System.out.println(ans);
    }
    public static int dfs(int row,int col)
    {
        for(int i=0;i<4;i++)
        {
            int nr = row +dir[i][0];
            int nc = col+ dir[i][1];
            if(nr>=0 && nr <N && nc>=0 && nc<N)
            {
                if(arr[nr][nc]>arr[row][col]){

                    if(visit[nr][nc]==0)
                    {
                        int t = dfs(nr,nc);
                        visit[row][col] = Math.max(t+1,visit[row][col]);

                    }else
                    {
                        visit[row][col] = Math.max(visit[nr][nc]+1,visit[row][col]);
                    }
                }

            }
        }
        if(visit[row][col] == 0)
            visit[row][col] = 1;

        return visit[row][col];
    }
}
