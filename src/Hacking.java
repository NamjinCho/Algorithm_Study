import java.util.PriorityQueue;
import java.util.Scanner;

public class Hacking {

    public static int N;
    public static int[][]adj;
    public static boolean visit[];
    public static int count[];
    public static boolean v2[];
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
        visit = new boolean[N+1];
        count=new int[N+1];
        pq = new PriorityQueue<>();
        for(int i=0;i<M;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            adj[b][a] = 1;
        }
        int max = -1;
        for(int i=1;i<=N;i++)
        {
            if(!visit[i])
            {
                visit[i]=true;
                v2= new boolean[N+1];
                max=Math.max(dfs(i),max);
            }
        }
        for(int i=1;i<=N;i++)
        {
            if(count[i]==max)
                System.out.print(i+ " ");
        }

        System.out.println();

    }
    public static int dfs(int b)
    {
        int total = 0 ;
        v2[b]=true;
        for(int i=1;i<=N;i++)
        {
            if(!visit[i] && adj[b][i]==1)
            {
                visit[i]=true;
                total+=dfs(i);
                total++;
            }
            else if(adj[b][i]==1)
            {
                if(!v2[i]){
                    total+=count[i]+1;
                    v2[i]=true;
                }
            }
        }
        count[b]=total;
        return total;
    }
}
