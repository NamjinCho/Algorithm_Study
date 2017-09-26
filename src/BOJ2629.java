import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-22.
 */
public class BOJ2629 {
    //TODO: 이거다시 풀어보기
    //TODO:구술조합 구술은 하나씩만 사용가능

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int T = sc.nextInt();
        int w[] = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            w[i] = sc.nextInt();
            max = Math.max(w[i], max);
        }
        int dp[] = new int[max + 1];

        for (int i = 0; i < max + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < N; i++) {
            if(arr[i]<=max)
                dp[arr[i]] = 1;
            for (int j = arr[i] + 1; j <= max; j++)
            {
                if(dp[j-arr[i]]!=Integer.MAX_VALUE)
                {
                    dp[j] = Integer.min(dp[j],dp[j-arr[i]]+dp[arr[i]]);
                }
            }
        }
        for(int i=0;i<T;i++)
        {
            System.out.println(dp[i]);
            if(dp[i]!=Integer.MAX_VALUE)
                System.out.print("Y ");
            else
                System.out.print("N ");
        }
        System.out.println();
    }


}
