import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-13.
 */
public class OrmakNo {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BigInteger [][] arr = new BigInteger[11][N];
        BigInteger one = new BigInteger("1");
        arr[0][0] = new BigInteger("1");
        BigInteger total = new BigInteger("1");
        for(int i=1;i<10;i++)
        {
            arr[i][0] = new BigInteger("1");
            total = total.add(arr[i][0]);
        }
        arr[10][0] = total.add(new BigInteger("0"));
        //1111111111 10
        //
        for(int i=1;i<N;i++)
        {
            total = arr[10][i-1].add(new BigInteger("0"));
            BigInteger total2 = new BigInteger("0");
            for(int j=0;j<10;j++)
            {
                arr[j][i] = total.add(new BigInteger("0"));
                total = total.subtract(arr[j][i-1]);
                total2 = total2.add(arr[j][i]);
            }
            arr[10][i] = total2;
        }
        BigInteger x = new BigInteger("10007");
        BigInteger ans = arr[10][N-1].mod(x);
        System.out.println(ans.toString());
    }
}
