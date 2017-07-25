import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-21.
 */
public class Consulting {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int time[] = new int[N];
        int pay[] = new int[N];
        int dp [][] = new int[N+1][2];

        for(int i=0;i<N;i++)
        {
            time[i]=sc.nextInt();
            pay[i] = sc.nextInt();
        }
        dp[0][0] = pay[0];

        for(int i=1;i<N;i++)
        {
            if(time[i]+i>N) {
                continue;
            }
            int Max = pay[i];
            for(int j=i;j>=0;j--)
            {
                if(time[j]+j <= i)
                {
                    int m2 = Math.max(dp[j][0],dp[j][1]);
                    dp[i][1]=Math.max(dp[i][1],m2);
                    Max=Math.max(Max,m2+pay[i]);
                }
            }
            dp[i][1]=Max;

            //dp[i+time[i]] = Math.max(dp[i]+pay[i],dp[time[i]+i]);
        }
        int max=0;
        for(int i=0;i<N;i++) {
            int m2 = Math.max(dp[i][0],dp[i][1]);
            max = Math.max(m2, max);
        }
        System.out.println(max);
    }
}
