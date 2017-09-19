import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-19.
 */
public class GirdPath {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int arr[][] = new int[N][M];
        int dp[][] = new int[N][M];
        dp[0][0] =1;
        if(K!=0)
        {
            //3 5 8
            // 8/5 = 1
            // 8%5 = 3
            int i = K/M;
            int j = K%M;
            if(j==0)
            {
                i--;
                j = M;
            }

            for(int r = 0;r<i;r++)
            {
                for(int c = j;c<M;c++)
                {
                    dp[r][c] = -1;
                }
            }

            for(int r = i+1;r<N;r++)
            {
                for(int c = 0;c<j-1;c++)
                {
                    dp[r][c] = -1;
                }
            }
        }
        int dir[][] = {{0,-1},{-1,0}};
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if((i==0 && j ==0 )|| dp[i][j] == -1)
                    continue;
                int t = 0;
                for(int k=0;k<2;k++)
                {
                    int nr = i+dir[k][0];
                    int nc = j+dir[k][1];
                    if(nr>=0 && nc >=0 && dp[nr][nc]!=-1)
                    {
                        t+=dp[nr][nc];
                    }
                }
                dp[i][j] = t;
            }
        }
        System.out.println(dp[N-1][M-1]);
    }
}
