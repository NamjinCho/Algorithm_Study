import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-08.
 */
public class Tiling1 {

    public static void main(String [] args)
    {
        Scanner sc=  new Scanner(System.in);
        int N = sc.nextInt();
        if(N <3)
            System.out.println(N);
        else
        {
            BigInteger [] arr = new BigInteger[N+1];
            arr[1] = new BigInteger("1");
            arr[2] = new BigInteger("2");
            for(int i=3;i<=N;i++)
            {
                arr[i] = arr[i-1].add(arr[i-2]);
            }
            BigInteger df = new BigInteger("10007");
            System.out.println(arr[N].mod(df));
        }

    }
}
