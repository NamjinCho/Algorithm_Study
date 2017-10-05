import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-04.
 */
public class HighTower {
    public static int ans;
    public static int N, B,arr[];
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1;tc<=T;tc++)
        {
            N = sc.nextInt();
            B = sc.nextInt();
            ans = 0;
            arr  = new int[N];
            for(int i=0;i<N;i++)
            {
                arr[i] = sc.nextInt();
                ans+=arr[i];
            }
            recursive(0,0);

            System.out.println("#"+tc+" "+(ans - B));
        }


    }
    public static void recursive(int cur , int Sum)
    {
        if(Sum >= ans)
            return;
        if(Sum >=B)
        {
            ans = Math.min(Sum,ans);
        }
        if(cur <N)
        {
            recursive(cur+1,Sum+arr[cur]);
            recursive(cur+1,Sum);
        }
    }
}
