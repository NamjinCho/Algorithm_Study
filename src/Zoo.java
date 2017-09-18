import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-18.
 */
public class Zoo {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[][] = new int[N][3];
        arr[0][0] = 1;
        arr[0][1] = 1;
        arr[0][2] = 1;
        for(int i=1;i<N;i++)
        {

            for(int j=0;j<3;j++)
            {

                for(int k=0;k<3;k++)
                {
                    if(j==k)
                        continue;

                  arr[i][j] = arr[i][j]+arr[i-1][k];
                }
                arr[i][j] = arr[i][j]%9901;
            }
            arr[i][0] = arr[i][0] + arr[i-1][0];
            arr[i][0] = arr[i][0]%9901;
        }
        int total = 0;
        for(int i=0;i<3;i++)
            total=total + arr[N-1][i];
       // total = total.mod(new BigInteger("9901"));
        System.out.println(total%9901);
    }
}
