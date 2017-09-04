import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-04.
 */
public class Dijkstra2 {
    //TODO: 최소스패닝 트리로 다시풀어보기
    static class Node implements Comparable<Node>
    {
        int idx;
        int dist;
        Node(int id,int di)
        {
            idx= id;
            dist =di;
        }
        @Override
        public int compareTo(Node o) {
            if(this.dist<o.dist)
                return -1;
            else if(this.dist==o.dist)
                return 0;
            else
                return 1;
        }
    }
    static int N,M;
    static int adj[][];
    static boolean mf[];
    public static void main(String [] args)
    {
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        String []sub = line.split(" ");
        adj = new int[N+1][N+1];
        mf = new boolean[N+1];
        for(int i=1;i<=N;i++)
        {
            if(sub[i-1].equals("M"))
                mf[i] = true;
            else
                mf[i] = false;
            for(int j=1;j<=N;j++)
                adj[i][j]=Integer.MAX_VALUE;
            adj[i][i] = 0;
        }

        for(int i=0;i<M;i++)
        {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int d = sc.nextInt();
            if((adj[s][e]!=Integer.MAX_VALUE && adj[s][e] > d )|| (adj[s][e]==Integer.MAX_VALUE))
            {
                adj[s][e] = d;
                adj[e][s] = d;
            }
        }
        System.out.println(dijkstra());
    }
    public static int dijkstra()
    {
         //페이즈가 초기화 , <가장 짧 가져오기 프큐> , 천개 다보면서 업데이트 해서 넣기 , 비짓 해서 안된얘 있으면 리턴 마1 된애 있으면리턴 총합
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean visit [] = new boolean[N+1];
        int [] dist = new int [N+1];
        int backtraking [] = new int[N+1];
        for(int i=1;i<=N;i++)
        {
            pq.offer(new Node(i,adj[1][i]));
            dist[i] = adj[1][i];
            backtraking[i] = 1;
        }
        visit[1]=true;
        while(!pq.isEmpty())
        {
            Node t = pq.poll();
            if(t.dist==Integer.MAX_VALUE || visit[t.idx])
                continue;
            visit[t.idx] = true;
            for(int i=1;i<=N;i++)
            {
                if(t.idx==i)
                    continue;
                if(mf[t.idx]!=mf[i]&&adj[t.idx][i]!=Integer.MAX_VALUE&&dist[i]> t.dist + adj[t.idx][i] )
                {
                    dist[i] = t.dist + adj[t.idx][i];
                    pq.offer(new Node(i,dist[i]));
                    backtraking[i]=t.idx;
                }
            }
        }
        int total = 0;
        for(int i=1;i<=N;i++)
        {
            if(!visit[i])
                return -1;
            else
            {
                total+=adj[backtraking[i]][i];
            }
        }
        return total;
    }

}
