import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-14.
 */
public class DeRoad {

    static
    int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
    static int N,M;
    static int ans [][] ,map[][];
    static int count=0;
    static boolean visit[][];
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        ans = new int[N][M];

        ans[0][0] = 1;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                map[i][j] = sc.nextInt();
            }
        }
        visit = new boolean[N][M];
        visit[0][0] = true;
        dfs(N-1,M-1);
        System.out.println(ans[N-1][M-1]);
    }
    public static void dfs(int row,int col)
    {
        visit[row][col] = true;
        for(int i=0;i<4;i++)
        {
            int nr = row+dir[i][0];
            int nc = col+dir[i][1];
            if(nr>=0 && nr<N && nc>=0&&nc<M)
            {
                if(map[nr][nc] > map[row][col]) {
                    if (!visit[nr][nc]) {
                        dfs(nr,nc);
                        ans[row][col]+=ans[nr][nc];
                    }else
                    {
                        ans[row][col]+=ans[nr][nc];
                    }
                }
            }
        }
    }
}
