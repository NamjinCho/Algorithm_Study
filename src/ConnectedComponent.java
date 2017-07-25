import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-19.
 */
public class ConnectedComponent {

    static int [][]adj;
    static int N;
    static boolean visit[];
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int V = sc.nextInt();

        adj = new int[N+1][N+1];
        for(int i=0;i<V;i++)
        {
            int s = sc.nextInt();
            int e = sc.nextInt();
            adj[s][e] = 1;
            adj[e][s] = 1;
        }
        visit = new boolean[N+1];
        int ans = 0;
        for(int i=1;i<=N;i++)
        {
            if(dfs(i))
                ans++;
        }
        System.out.println(ans);
    }
    public static boolean dfs(int start)
    {
        if(visit[start])
            return false;
        visit[start]=true;
        for(int i=1;i<=N;i++)
        {
            if(!visit[i]&&adj[start][i]==1)
            {
                dfs(i);
            }
        }
        return true;
    }
    public static boolean bfs(int start)
    {
        if(visit[start])
            return false;

        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visit[start] = true;

        while (!que.isEmpty())
        {
            int idx= que.poll();
            for(int i=1;i<=N;i++)
            {
                if(!visit[i] && adj[idx][i]==1)
                {
                    que.add(i);
                    visit[i]=true;
                }
            }
        }
        return true;
    }
}
