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

            //String result = ans.setScale(7, BigDecimal.ROUND_HALF_UP).toString();
            //System.out.println("#" + tc + " " + result.substring(0, result.length() - 1));
            //System.out.println(result.substring(0,result.length()-1));
            System.out.println(ans);
        }
    }

    public static BigDecimal getMax(int current, int visited) {
        BigDecimal result = new BigDecimal("0");
        if (visited == (1 << N) - 1)
            return new BigDecimal("1");

        if (dp[current][visited] != null)
            return dp[current][visited];

        for (int i = 1; i <= N; i++) {
            int next = i;
            if ((visited & (1 << (next - 1))) != 0) {
                continue;
            }

            for (int j = 1; j <= N; j++) {
                next = j;
                if ((visited & (1 << (next - 1))) != 0) {
                    continue;
                }
                if (percent[i][j] == 0)
                    continue;
                System.out.println(i + " - >" + next);
                double mul = (double) percent[current][next] / 100.0;
                BigDecimal ret = getMax(next, visited + (1 << (next - 1))).multiply(new BigDecimal(mul));
                System.out.println(ret);
                result = result.max(ret);
            }
        }
        return result;
    }
}
