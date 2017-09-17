import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-15.
 */
public class Chains {
    public static void main(String [] args)
    {

        Scanner sc= new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int chains[] = new int[N];

        for(int i=0;i<N;i++)
            chains[i] = sc.nextInt();

        System.out.println(change(K,chains));


    }
    public static int change(int total, int[] coins) {
        int answer = 0;
        int length = coins.length;
        int dp[] = new int[10001];
        for(int i=0;i<length;i++)
        {
            if(coins[i] >10000)
                continue;
            dp[coins[i]]++;
            for(int j=coins[i]+1;j<=total;j++)
            {
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        answer = dp[total];
        return answer;
    }

}
