import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-25.
 */
public class SangBumGame {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=0;tc<T;tc++)
        {
            int N = sc.nextInt();
            int [] arr = new int[N+1];

            for(int n=1;n<=N;n++)
            {
                for(int i=1;i*n<=N;i++)
                {
                    arr[i*n]++;
                }
            }
            int ans = 0;
            for(int i=1;i<=N;i++)
            {
                if(arr[i]%2!=0)
                    ans++;
            }
            System.out.println(ans);
        }
    }
}
