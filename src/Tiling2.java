import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-08.
 */
public class Tiling2 {

    public static void main(String [] args)
    {
        Scanner sc=  new Scanner(System.in);
        int N = sc.nextInt();
        if(N <2)
            System.out.println(N);
        else
        {
            BigInteger [] arr = new BigInteger[N+1];
            arr[1] = new BigInteger("1");
            boolean f = true;
            BigInteger two = new BigInteger("2");
            for(int i=2;i<=N;i++)
            {
                arr[i] = arr[i-1].multiply(two);
                if(f)
                {
                    arr[i]=arr[i].add(arr[1]);
                }else
                {
                    arr[i]=arr[i].subtract(arr[1]);
                }
                f=!f;
            }
            BigInteger df = new BigInteger("10007");
            System.out.println(arr[N].mod(df));
        }

    }
}
