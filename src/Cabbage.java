import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-29.
 */
public class Cabbage {

    static int N,M,T;
    static int map[][];
    static boolean visit[][];
    static int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for(int tc = 0 ; tc<T;tc++)
        {
            M = sc.nextInt();
            N = sc.nextInt();
            int s = sc.nextInt();
            map = new int[N][M];
            visit = new boolean[N][M];

            for(int i =0;i<s;i++)
            {
                int c = sc.nextInt();
                int r = sc.nextInt();

                map[r][c] = 1;
            }
            int ans = 0;
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<M;j++)
                {
                    if(map[i][j]==1)
                    {
                        ans+=dfs(i,j);
                    }
                }
            }
            System.out.println(ans);
        }
    }
    public static int dfs(int row,int col)
    {
        if(visit[row][col])
            return 0;
        visit[row][col] = true;
        for(int i=0;i<4;i++)
        {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if(nr>=0 && nr < N && nc >=0 && nc<M && !visit[nr][nc] && map[nr][nc]==1)
            {
                dfs(nr,nc);
            }
        }

        return 1;
    }

}
