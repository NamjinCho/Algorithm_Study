import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-04.
 */
public class WorkDistribution {


    static boolean visit[];
    static int percent[][];
    static BigDecimal ans;
    static int N;
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++)
        {
            N = sc.nextInt();
            percent = new int[N][N];
            visit = new boolean[N];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    percent[i][j] = sc.nextInt();
                }
            }
            ans = new BigDecimal(0);
            dfs(0,new BigDecimal(1));
            String result = ans.setScale(7,BigDecimal.ROUND_HALF_UP).toString();
            System.out.println(result.substring(0,result.length()-1));
        }
    }
    public static void dfs(int depth , BigDecimal sum)
    {
        if(sum.compareTo(ans)==-1)
            return;

        if(depth == N)
        {
            sum = sum.multiply(new BigDecimal(100.0));
            if(sum.compareTo(ans) == 1)
                ans = sum;

            return;
        }

        for(int i=0;i<N;i++)
        {
            if(!visit[i])
            {
                visit[i] = true;
                double tmp = (double) percent[depth][i] / 100;
                dfs(depth+1,sum.multiply(new BigDecimal(tmp)));
            }
        }
    }
}
