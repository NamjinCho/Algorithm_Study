import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-18.
 */
public class CombinationP {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        BigInteger arr[] = new BigInteger[N+1];
        arr[0] = new BigInteger("1");
        for(int i=1;i<=N;i++)
            arr[i] = arr[i-1].multiply(new BigInteger(i+""));
        BigInteger tmp = arr[N].divide(arr[K].multiply(arr[N-K]));
        int ans = (tmp.mod(new BigInteger("10007"))).intValue();

        System.out.println(ans);
    }
}
