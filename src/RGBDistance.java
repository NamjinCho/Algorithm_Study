import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-12.
 */
public class RGBDistance{
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[][] = new int[N][3];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<3;j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        int dp[][] = new int[N][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for(int i=1;i<N;i++)
        {
            for(int j=0;j<3;j++)
            {
                int min = Integer.MAX_VALUE;
                for(int k=0;k<3;k++)
                {
                    if(k==j)
                        continue;
                    min  = Math.min(dp[i-1][k],min);
                }
                dp[i][j] = min + arr[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<3;i++)
            ans = Math.min(ans,dp[N-1][i]);
        System.out.println(ans);
    }
}
