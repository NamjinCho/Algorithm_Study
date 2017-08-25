import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-20.
 */
public class BridgeWeight {

    static class Node{
        int idx;
        ArrayList<Node> Connection;
        ArrayList<Integer> waits;
    }
    static int N;
    static Node [] nodes;
    static int max;
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        nodes = new Node[N+1];
        for(int i=1;i<N+1;i++)
        {
            nodes[i] = new Node();
            nodes[i].idx = i;
            nodes[i].Connection = new ArrayList<>();
            nodes[i].waits = new ArrayList<>();
        }
        for(int i=0;i<M;i++)
        {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();
            nodes[s].Connection.add(nodes[e]);
            nodes[s].waits.add(w);
            nodes[e].Connection.add(nodes[s]);
            nodes[e].waits.add(w);
        }
        max=0;
        int s = sc.nextInt();
        int e = sc.nextInt();
        int di = -1;
        bfs(s,e);
        System.out.println(max);
    }
    static void bfs(int start ,int end)
    {
        boolean visit[] = new boolean[N+1];
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> wei = new LinkedList<>();
        wei.offer(Integer.MAX_VALUE);
        q.offer(nodes[start]);
        visit[end]  = true;

        while(!q.isEmpty())
        {
            Node n = q.poll();
            int weight = wei.poll();
            for(int i=0;i<n.Connection.size();i++)
            {
                if(!visit[n.Connection.get(i).idx] ||n.Connection.get(i).idx == end)
                {
                    int minw = Math.min(weight,n.waits.get(i));
                    if(n.Connection.get(i).idx == end)
                    {
                        max = Math.max(max,minw);
                        continue;
                    }
                    visit[n.Connection.get(i).idx] = true;
                    q.offer(n.Connection.get(i));
                    wei.offer(Math.min(weight,minw));
                }
            }
        }

    }

}
