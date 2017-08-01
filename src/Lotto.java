import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-30.
 */
public class Lotto {

    static int N;
    static int arr[];
    static int ans[];
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        N = sc.nextInt();
        while(N!=0)
        {
            arr = new int[N];
            ans = new int[6];
            for(int i=0;i<N;i++)
            {
                arr[i]=sc.nextInt();
            }
            dfs(0,0);
            N=sc.nextInt();
            System.out.println();
        }
    }
    public static void dfs(int idx,int count)
    {
        if(count == 6)
        {
            for(int i=0;i<6;i++)
                System.out.print(ans[i] + " ");
            System.out.println();
            return;
        }
        if(N-idx + count < 6 || idx>=N)
        {
            return;
        }

        ans[count] = arr[idx];
        dfs(idx+1,count+1);
        dfs(idx+1,count);
    }
}
