import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-17.
 */
public class Tornermant {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = sc.nextInt();
        int b= sc.nextInt();
        int ans = 1;
        while(a!=b)
        {
            int t = a-b;
            t = Math.abs(t);
            if(t == 1){
                int max = Math.max(a,b);
                if(max%2 == 0)
                    break;
            }
            int w = 0;
            if(a%2 == 1)
                w = 1;
            a = a/2;
            a+=w;
            w = 0;
            if(b%2 == 1)
                w = 1;
            b = b/2 + w;
            ans++;
            w = 0;
            if(N%2 == 1)
                w = 1;
            N = N/2+w;
        }
        System.out.println(ans);

    }
}
