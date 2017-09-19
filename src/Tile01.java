import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-19.
 */
public class Tile01 {
    public static void main(String [] args)
    {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        long s = System.currentTimeMillis();
        if(N==1)
            System.out.println(1);
        else if(N==2)
            System.out.println(2);
        else{
            int cur = 0;
            int pp = 1;
            int p = 2;
            for(int i=3;i<=N;i++)
            {
                cur = p+pp;
                cur = cur%15746;
                pp = p;
                p = cur;

            }
            System.out.println(cur);
        }

    }

}
