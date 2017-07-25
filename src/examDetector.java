import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-23.
 */
public class examDetector {

    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int room [] = new int[N];
        for(int i=0;i<N;i++)
        {
            room[i]=sc.nextInt();
        }
        int B = sc.nextInt();
        int C = sc.nextInt();
        BigInteger total = new BigInteger("0") ;
        BigInteger one = new BigInteger("1");
        for(int i=0;i<N;i++)
        {
            total = total.add(one);

            if(room[i]<=B)
                continue;

            room[i]=room[i]-B;
            BigInteger b = new BigInteger((room[i]/C)+"");
            total = total.add(b);
            if(room[i]%C!=0)
                total = total.add(one);

        }
        System.out.println(total.toString());
    }
}
