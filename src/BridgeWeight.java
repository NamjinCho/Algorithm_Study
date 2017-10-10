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
    static class Element{
        Node node;
        int curWeight;

        Element(Node n, int w)
        {
            node = n;
            curWeight = w;
        }
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
        int ans = bfs(s,e);
        if(ans == Integer.MAX_VALUE)
            ans = -1;
        System.out.println(ans);
    }
    static int bfs(int start ,int end)
    {
        int visit[] = new int[N+1];
        Queue<Element> q = new LinkedList<>();
        for(int i=0;i<=N;i++)
            visit[i] =Integer.MAX_VALUE;

        q.offer(new Element(nodes[start],visit[start]));

        while (!q.isEmpty())
        {
            Element e = q.poll();
            Node n = e.node;

            int length = n.Connection.size();

            for(int i=0;i<length;i++)
            {
                int minW = Math.min(e.curWeight,n.waits.get(i));
                int idx = n.Connection.get(i).idx;
                if( visit[idx]==Integer.MAX_VALUE || visit[idx] < minW)
                {
                    q.offer(new Element(n.Connection.get(i),minW));
                    visit[idx] = minW;
                }
            }
        }
        return visit[end];
    }

}
