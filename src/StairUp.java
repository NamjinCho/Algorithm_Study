import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-08.
 */
public class StairUp {

    static int dp[];
    static int N;
    static int ans = 0;
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

         dp= new int[N];


        dp[0] = sc.nextInt();
        for(int i=1;i<N;i++)
        {
            dp[i] = sc.nextInt();
        }
        int dp2 [][] = new int[N][2];
        boolean con [] = new boolean[N];
        dp2[0][0] = dp[0];
        if(N>=2) {
            dp2[1][0] = dp[0] + dp[1];
            dp2[1][1] = dp[1];
            con[1] = true;
        }
        for(int i=2;i<N;i++)
        {
            if(con[i-1] == false)
            {
                int tmp = Math.max(dp2[i-1][0],dp2[i-1][1]);
                dp2[i][0] = tmp+dp[i];
                dp2[i][1] = Math.max(dp2[i-2][0],dp2[i-2][1]) + dp[i];
                con[i] = (dp2[i][0] > dp2[i][1]);
            }else{
                dp2[i][0] = dp2[i-1][1]+dp[i];
                dp2[i][1] = Math.max(dp2[i-2][0],dp2[i-2][1])+dp[i];
                con[i] = (dp2[i][0] > dp2[i][1]);
            }
        }
        ans = Math.max(dp2[N-1][0],dp2[N-1][1]);
        System.out.println(ans);
    }
}
