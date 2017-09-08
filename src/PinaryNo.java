import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-07.
 */
public class PinaryNo {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        BigInteger arr[] = new BigInteger[N+1];
        if(N==1)
            System.out.println(2);
        else if(N==2)
            System.out.println(1);
        else if(N==3)
            System.out.println(2);
        else{
            arr[1]=new BigInteger("2");
            arr[2]=new BigInteger("1");
            arr[3]=new BigInteger("2");
            for(int i=4;i<=N;i++)
            {
                arr[i] = arr[i-1].add(arr[i-2]);
            }
            BigInteger two = new BigInteger("2");

            System.out.println(arr[N].toString());

        }
    }


}
