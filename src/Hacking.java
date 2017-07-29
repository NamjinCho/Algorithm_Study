import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-28.
 */
public class Hacking {

    public static int N;
    public static int[][]adj;
    public static boolean visit[];
    public static int count[];
    static PriorityQueue<Point> pq;
    static class Point implements Comparable<Point>{

        int idx;
        int count;
        Point (int x,int y)
        {
            this.idx=x;
            this.count=y;
        }
        @Override
        public int compareTo(Point o) {

                if (this.count > o.count)
                    return 1;
                else return 1;
        }
    }
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        adj = new int[N+1][N+1];
        int M = sc.nextInt();
        count=new int[N+1];
        for(int i=0;i<M;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            adj[b][a] = 1;
        }
        int max = -1;
        for(int i=1;i<=N;i++)
        {
                count[i] =bfs(i);
                max=Math.max(count[i],max);
        }
        for(int i=1;i<=N;i++)
        {
            if(count[i]==max)
                System.out.print(i+ " ");
        }
    }
    public static int bfs(int b)
    {
        Queue<Integer> q = new LinkedList<>();
        q.offer(b);
        visit = new boolean[N+1];
        visit[b] = true;
        int result = 0;

        while(!q.isEmpty())
        {
            int s = q.poll();
            for(int i=1;i<N+1;i++)
            {
                if(adj[s][i]==1 && !visit[i])
                {
                    result++;
                    q.offer(i);
                    visit[i]=true;
                }
            }
        }
        return result;
    }

}
