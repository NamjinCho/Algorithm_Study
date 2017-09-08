import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-07.
 */
public class Wine {
    public static void main(String [] args)
    {
        Scanner sc =new Scanner(System.in);

        int N = sc.nextInt();

        int arr[]= new int [N];

        for(int i=0;i<N;i++)
        {
            arr[i] = sc.nextInt();
        }

        int dp[][] = new int[N][3];
        dp[0][1] = arr[0];
        int ans = arr[0];
        for(int i=1;i<N;i++)
        {
            int max=0;
            for(int j=0;j<3;j++)
            {
                max= Math.max(dp[i-1][j],max);
            }
            dp[i][0] = max;
            dp[i][1] = dp[i-1][0]+arr[i];
            dp[i][2] = dp[i-1][1]+arr[i];
            for(int j=0;j<3;j++)
            {
                ans = Math.max(dp[i][j],ans);
            }
        }

        System.out.println(ans);
    }
}
