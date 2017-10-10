import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-07.
 */
public class Dalant {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);


        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++)
        {
            int s = sc.nextInt();
            int g = sc.nextInt();


            BigInteger ss = new BigInteger(""+s);
            BigInteger gg = new BigInteger(""+g);
            BigInteger tmp = ss.divide(gg);
            BigInteger mod = ss.mod(gg);
            BigInteger ans = tmp.pow(gg.subtract(mod).intValue());
            ans = ans.multiply(tmp.add(new BigInteger("1")).pow(mod.intValue()));
            System.out.println(ans);
        }
    }
}
