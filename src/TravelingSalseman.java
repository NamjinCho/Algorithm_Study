import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-10.
 */
public class TravelingSalseman {

    static int N;
    static int W[][];
    static int dp[][];
    static int start;
    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);

        N = sc.nextInt();
        W = new int[N+1][N+1];

        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=N;j++)
            {
                W[i][j] = sc.nextInt();
            }
        }
        dp = new int[N+1][1<<N];
        for(int i=1;i<=N;i++)
            Arrays.fill(dp[i],-1);
        start = 1;
        int ans = getShortest(start,1<<(start-1));
        System.out.println(ans);
    }
    //이건 완전탐색
    public static int getShortest(int current, int visited)
    {

        int result  = 100000000;

        if(visited == (1<<N)-1) return W[current][start];
        if(dp[current][visited] >= 0)
        {
            return dp[current][visited];
        }
        //System.out.println(current);
        for(int i=1;i<=N;i++)
        {
            int next = i;
            if ((visited & (1 << (next - 1))) !=0 ) // 1 << next-1 = 선택한 위치만 1, 그리고 , &연산하면 그위치 값이 1이 나오면 이전 방문 정보에 방문 기록있다는것
            {
                continue;
            }
            if(W[current][next]==0) // 연결안되어있음
                continue;

            result = Math.min(result,W[current][next] + getShortest(next,visited + (1<<next-1))); // 방문한 값 업데이트
        }
        dp[current][visited] = result;
        return result;
    }
}
