import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-12.
 */
public class SumOf2DArr {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[][] = new int[N+1][M+1];

        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=M;j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        int dp[][][]= new int[N+1][M+1][3];
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=M;j++)
            {
                dp[i][j][0] = dp[i][j-1][0] + arr[i][j];
                dp[i][j][1] = dp[i-1][j][1] + arr[i][j];
                dp[i][j][2] = dp[i][j-1][2] + arr[i][j] + dp[i-1][j][1];
            }
        }
        int k = sc.nextInt();
        for(int t=0;t<k;t++) {
            int i, j, x, y;
            i = sc.nextInt();
            j = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            int ans = 0;
            if(i==x)
            {
                ans = dp[x][y][0] - dp[i][j-1][0];
            }else if(y==j)
            {
                ans = dp[x][y][1] - dp[i-1][j][1];
            }else
            {
                ans = dp[x][y][2] - dp[x][j-1][2] - (dp[i-1][y][2] - dp[i-1][j-1][2]);
            }
            System.out.println(ans);
        }
    }
}
