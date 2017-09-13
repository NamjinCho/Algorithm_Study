import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-12.
 */
public class BOJSticker {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        int T =sc.nextInt();
        for(int tc =0; tc<T;tc++)
        {
            int N = sc.nextInt();
            int arr[][] = new int [N][2];

            for(int i=0;i<2;i++)
            {
                for(int j=0;j<N;j++)
                {
                    arr[j][i] = sc.nextInt();
                }
            }
            int dp[][] = new int[N][3];
            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];
            dp[0][2] = 0;
            for(int i=1;i<N;i++)
            {
                for(int j=0;j<3;j++)
                {
                    int max = 0;
                    for(int k=0;k<3;k++)
                    {
                        if(j==k)
                            continue;
                        max = Math.max(max,dp[i-1][k]);
                    }
                    if(j<2) {
                        dp[i][j] = max + arr[i][j];
                    }else
                        dp[i][j] = max;
                }
            }
            int ans = 0;
            ans = Math.max(dp[N-1][1],dp[N-1][0]);
            ans = Math.max(dp[N-1][2],ans);
            System.out.println(ans);
        }
    }
}
