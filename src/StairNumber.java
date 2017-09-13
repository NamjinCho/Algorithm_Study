import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-12.
 */
public class StairNumber {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        BigInteger arr[] = new BigInteger[N+1];
        arr[1] = new BigInteger("9");
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        for(int i=2;i<=N;i++)
        {
            arr[i] = arr[i-1].multiply(two);
            arr[i] = arr[i].subtract(one);
        }
        BigInteger x = new BigInteger("1000000000");
        arr[N] = arr[N].mod(x);
        System.out.println(arr[N]);
    }
}
