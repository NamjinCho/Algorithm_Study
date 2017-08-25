import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-20.
 */
public class TreeDiameter {

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
        nodes = new Node[N+1];
        for(int i=1;i<N+1;i++)
        {
            nodes[i] = new Node();
            nodes[i].idx = i;
            nodes[i].Connection = new ArrayList<>();
            nodes[i].waits = new ArrayList<>();
        }
        for(int i=0;i<N-1;i++)
        {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();
            nodes[s].Connection.add(nodes[e]);
            nodes[s].waits.add(w);
            nodes[e].Connection.add(nodes[s]);
            nodes[e].waits.add(w);
        }
        max = 0;
        for(int i=1;i<N+1;i++)
            bfs(i);
        System.out.println(max);
    }
    static void bfs(int idx)
    {
        boolean visit[] = new boolean[N+1];
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();
        dq.offer(0);
        q.offer(nodes[idx]);
        visit[idx]  = true;

        while(!q.isEmpty())
        {
            Node n = q.poll();
            int length = dq.poll();
            max = Math.max(max,length);
            for(int i=0;i<n.Connection.size();i++)
            {
                if(!visit[n.Connection.get(i).idx])
                {
                    visit[n.Connection.get(i).idx] = true;
                    q.offer(n.Connection.get(i));
                    dq.offer(length+n.waits.get(i));
                }
            }
        }

    }

}
