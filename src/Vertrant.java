import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-17.
 */
public class Vertrant {
    public static void main(String []args)
    {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        while (N!=0)
        {
            boolean arr[] = new boolean[2*N+1];


            for(int i=2;i<=2*N;i++)
            {
                if(arr[i])
                    continue;

                for(int j=2;j*i<=2*N;j++)
                {
                    if(arr[i*j])
                        continue;
                    arr[i*j] = true;
                }
            }
            int ans = 0;
            for(int i=N+1;i<=2*N;i++)
            {
                if(!arr[i])
                    ans++;
            }
            System.out.println(ans);
            N = sc.nextInt();
        }
    }
}
