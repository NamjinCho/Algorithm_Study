import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-04.
 */
public class WorkDistribution {


    static int percent[][];
    static BigDecimal ans;
    static int N;
    static BigDecimal dp[][];
    static int start;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            percent = new int[N + 1][N + 1];
            dp = new BigDecimal[N + 1][1 << N];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    percent[i][j] = sc.nextInt();
                }
            }
            ans = new BigDecimal("0");
            start = 1;
            ans = ans.max(getMax(start, 0));
            ans = ans.multiply(new BigDecimal(100));
            String result = ans.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
            System.out.println("#"+tc+" "+result);
            //System.out.println(result);
        }
    }

    public static BigDecimal getMax(int current, int visited) {
        BigDecimal result = new BigDecimal("0");
        if (current >N)
            return new BigDecimal("1");
        //System.out.println(visited);
        if (dp[current][visited] != null)
            return dp[current][visited];

        for(int i=1;i<=N;i++)
        {
            int next = i;

            if((visited & (1<<(next-1)))!=0)
                continue;

            BigDecimal tmp = new BigDecimal(percent[current][i]);
            tmp = tmp.divide(new BigDecimal("100"));

            BigDecimal ret = getMax(current+1, visited + (1<<(next-1)));
            ret=ret.multiply(tmp);
            result = ret.max(result);
        }
        dp[current][visited] = result;

        return result;

    }
}
