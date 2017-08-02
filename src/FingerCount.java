import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-02.
 */
public class FingerCount {

    public static void main(String [] args)
    {
        int [] count = {0,5 , 10 , 10 ,10 ,5};
        boolean plmi[] = {true, false , true , false , false , true , false , true};
        int start[] = {1,4,3,2,5,2,3,4};
        int subCount [][] = {{0,1,1,1,1,1},{0,1,2,1,1,0},{0,0,0,2,2,1},{0,1,2,1,1,0},{0,1,1,1,1,1},{0,0,1,1,2,1},{0,1,2,2,0,0},{0,0,1,1,2,1}};
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextLong();
        if( N == 1 && M == 0)
        {
            System.out.println(0);
            return;
        }
        BigInteger ft = new BigInteger("40");
        BigInteger five = new BigInteger("5");
        BigInteger one = new BigInteger("1");
        BigInteger Max = new BigInteger((M/count[N])+"");
        Max = Max.multiply(ft);
        long mod = M-(M/count[N] * count[N]);
        int idx = 0;
        for(int i=0;i<8;i++)
        {

            mod = mod-subCount[i][N];
            if(mod<0) {
                idx=i;
                break;
            }
            Max=Max.add(five);
        }
        boolean flag = plmi[idx];
        int sNum = start[idx];
        mod=subCount[idx][N]+mod;
        while (true)
        {
            if(mod==0 && sNum == N)
                break;
            if(sNum == N)
                mod--;
            if(flag)
            {
                sNum++;
            }else
            {
                sNum--;
            }
            Max = Max.add(one);
            if(sNum==5 || sNum==1)
                flag=!flag;
        }
        System.out.println(Max.toString());

    }
}
