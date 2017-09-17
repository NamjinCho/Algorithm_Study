import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-15.
 */
public class Coin2 {
    public static void main(String []args)
    {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int coins[] = new int[N];
        for(int i=0;i<N;i++)
            coins[i] = sc.nextInt();

        int dp[] = new int[K+1];
        for(int i=0;i<=K;i++)
            dp[i] = Integer.MAX_VALUE;

        for(int i=0;i<N;i++)
        {
            if(coins[i] > K)
                continue;
            dp[coins[i]] = 1;
            for(int j=coins[i]+1;j<=K;j++)
            {
                if(dp[j-coins[i]]==Integer.MAX_VALUE)
                    continue;

                dp[j] = Math.min((dp[coins[i]]+dp[j-coins[i]]),dp[j]);
            }
        }
        if(dp[K]==Integer.MAX_VALUE)
            dp[K] = -1;
        System.out.println(dp[K]);
    }
}
