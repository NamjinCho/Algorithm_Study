import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-18.
 */
public class FishBread {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[] = new int[N+1];
        for(int i=1;i<=N;i++)
            arr[i] = sc.nextInt();
        int dp[] = new int[N+1];
        for(int i=1;i<=N;i++)
        {
            dp[i] = Math.max(dp[i],arr[i]);
            for(int j=i+1;j<=N;j++)
                dp[j] = Math.max(dp[j],dp[j-i]+arr[i]);
        }
        System.out.println(dp[N]);
    }
}
