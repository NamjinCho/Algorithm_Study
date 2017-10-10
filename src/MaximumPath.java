import com.sun.javafx.geom.Edge;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-06.
 */
public class MaximumPath {

    static ArrayList<Integer> edge[];
    static boolean visit[];
    static int N;
    static int ans;
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1;tc<=T;tc++)
        {
            N  = sc.nextInt();
            edge = new ArrayList[N+1];
            visit = new boolean[N+1];
            for(int i=0;i<=N;i++)
                edge[i] = new ArrayList();

            int M = sc.nextInt();
            for(int i=0;i<M;i++)
            {
                int s = sc.nextInt();
                int e = sc.nextInt();
                edge[s].add(e);
                edge[e].add(s);
            }

            ans = 0;
            for(int i=1;i<=N;i++)
            {
                visit[i] = true;
                dfs(i,1);
                visit[i] = false;
            }
            System.out.println("#"+tc+" "+ans);
        }
    }
    public static void dfs(int s,int count)
    {
        for(int i=0;i<edge[s].size();i++)
        {
            int t = edge[s].get(i);
            if(!visit[t])
            {
                visit[t] = true;
                dfs(t,count+1);
                visit[t] = false;
            }
        }
        ans = Math.max(ans,count);

    }
}
