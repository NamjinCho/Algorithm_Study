import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-17.
 */
public class FindPrime {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean [] prime = new boolean[N+1];

        prime[1] = true;
        int ans = 0;
        int print = 0;
        while(ans<K)
        {
            for(int i=2;i<=N;i++)
            {
                if(prime[i]==true)
                    continue;

                for(int j=1;j*i <=N;j++)
                {
                    if(prime[i*j]==true)
                        continue;

                    prime[i*j] = true;

                    ans++;
                    if(ans==K)
                        print = i*j;
                }
            }
        }
        System.out.println(print);
    }

}
