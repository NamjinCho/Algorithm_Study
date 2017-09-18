import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-18.
 */
public class SumDivide {
    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        BigInteger arr[][] = new BigInteger[N+1][K+1];
        BigInteger one = new BigInteger("1");
        for(int i=0;i<=N;i++)
            for(int j=0;j<=K;j++)
                arr[i][j] = new BigInteger("0");
        for(int i=0;i<=K;i++)
            arr[0][i] = new BigInteger("1");


        for(int i=1;i<=N;i++)
        {
            arr[i][1] = arr[i][1].add(one);
            for(int j=i;j<=N;j++)
            {
                for(int g=j;g>=1;g--) {
                    for (int l = 2; l <= K; l++) {
                        arr[j][l] = arr[j][l].add(arr[j-g-i][l - 1]);
                    }
                }
            }
        }
        int ans = arr[N][K].mod(new BigInteger("1000000000")).intValue();
        System.out.println(ans);
    }

}
