import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-03.
 */
public class BOJ14501 {

    static int N;
    static int arr[][];
    static int ans;
    public static void main(String []args)
    {
        Scanner sc =new Scanner(System.in);

        N = sc.nextInt();
        arr=new int[N+1][2];
        for(int i=1;i<=N;i++)
        {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        ans = 0;
        dfs(1,0);
        System.out.println(ans);
    }
    public static void dfs(int day , int sum)
    {
        if(day > N)
        {
            ans = Math.max(ans,sum);
            return;
        }
        if(day+arr[day][0] <=N+1)
            dfs(day+arr[day][0],sum+arr[day][1]);
        dfs(day+1,sum);


    }
}
