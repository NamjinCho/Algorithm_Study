import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-19.
 */
public class boj_coin {
    static int K;
    static int min = Integer.MAX_VALUE;
    static boolean[] visit;
    static int[] mins;
    static int[] coins;
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        K = sc.nextInt();
        mins = new int[30000];
        visit = new boolean[30000];
        coins = new int[n];
        for(int i=0;i<n;i++)
        {
            coins[i]=sc.nextInt();
        }
        mins[K]=-1;
        //mins[n] = 0;
        bfs(0);
        System.out.println(mins[K]);
    }

    public static void bfs(int start )
    {
        Queue<Integer> que = new LinkedList<>();

        que.offer(start);
        visit[start] = true;
        while (!que.isEmpty())
        {

            int cur = que.poll();
            for(int i=0;i<n;i++)
            {
                int idx = cur+coins[i];
                //cur += coins[i];

                if(idx<30000 && idx>0)
                {
                    if(!visit[idx])
                    {
                        mins[idx]=mins[cur]+1;
                        que.offer(idx);
                        visit[idx]=true;
                        if(idx==K)
                            break;
                    }
                }
            }
        }
    }
}