import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-08.
 */
public class StairUp {

    static int dp[];
    static int N;
    static int ans = 0;
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

         dp= new int[N];


        dp[0] = sc.nextInt();
        for(int i=1;i<N;i++)
        {
            dp[i] = sc.nextInt();
        }
        ans = 0;
        bfs();
        System.out.println(ans);
    }
    public static void bfs()
    {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> iq = new LinkedList<>();
        Queue<Integer> tq = new LinkedList<>();
        int [][]count= new int[N][3];
        q.offer(0);
        tq.offer(dp[0]);
        iq.offer(2);
        while (!q.isEmpty())
        {
            int total = tq.poll();
            int inc = iq.poll();
            int idx = q.poll();
            if(idx==N-1)
            {
                ans = Math.max(ans,total);
                continue;
            }
            if(inc==1)
            {
                int nidx = idx+2;
                if(nidx < N)
                {
                    if(count[nidx][inc] ==0 || count[nidx][inc] < total + dp[nidx] ) {
                        tq.offer(total + dp[nidx]);
                        count[nidx][inc] = total + dp[nidx];
                        q.offer(nidx);
                        iq.offer(2);

                    }
                }
            }else
            {
                for(int i=1;i<=2;i++)
                {
                    int nidx = idx+i;
                    if(nidx < N && (count[nidx][i] ==0 || count[nidx][i] < total + dp[nidx]) ) {
                        tq.offer(total + dp[nidx]);
                        count[nidx][i] = total + dp[nidx];
                        q.offer(nidx);
                        iq.offer(i);
                    }
                }
            }

        }
    }
}
