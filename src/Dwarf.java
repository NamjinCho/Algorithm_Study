import java.math.BigInteger;
import java.util.*;
public class Dwarf {
    static BigInteger fact[] = new BigInteger[31];
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc=0;tc<t;tc++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            getFact(N);
            getFact(M);
            if(N!=M) {
                BigInteger result = fact[M];
                BigInteger result2 = fact[N].multiply(getFact(M-N));
                result = result.divide(result2);
                System.out.println(result.toString());
            }else
                System.out.println(1);
        }
    }
    static BigInteger getFact(int N)
    {
        if(fact[N]!=null)
        {
            return fact[N];
        }
        if(N==1)
        {
            fact[1] = new BigInteger("1");
            return fact[1];
        }
        fact[N] = new BigInteger(N+"").multiply(getFact(N-1));
        return fact[N];
    }
}