import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-08.
 */
public class Pado {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int basic[] = {0,1,1,1};
        for(int tc=0;tc<T;tc++)
        {
            int N = sc.nextInt();
            long arr[] = new long[N+1];
            if(N<=3)
                System.out.println(basic[N]);
            else
            {
                arr[1] = 1;
                arr[2] = 1;
                arr[3] = 1;
                for(int i=4;i<=N;i++)
                {
                    arr[i] = arr[i-2] + arr[i-3];
                }
                System.out.println(arr[N]);
            }
        }
    }
}
