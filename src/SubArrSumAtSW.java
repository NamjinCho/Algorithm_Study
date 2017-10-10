import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-09.
 */
public class SubArrSumAtSW {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++)
        {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int dp[][] = new int[N][K+1];
            int arr[] = new int[N];

            for(int i=0;i<N;i++)
                arr[i] = sc.nextInt();
            Arrays.sort(arr);

            if(arr[0] < K)
            {
                dp[0][arr[0]] = 1;
            }
            for(int i=1;i<N;i++)
            {
                for(int j=1;j<arr[i] && j<=K;j++)
                    dp[i][j] = dp[i-1][j];
                for(int j=arr[i];j<=K;j++)
                {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i]];
                }
                if(K >= arr[i])
                    dp[i][arr[i]]++;
            }
            System.out.println("#"+tc+" "+dp[N-1][K]);
        }

    }


}
