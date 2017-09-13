import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-12.
 */
public class BojBinaryGraph {
    static class Node{
        int idx;
        int color;
        ArrayList<Node> con;
    }
    static int N;
    static Node [] nodes;
    static boolean visit[];
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 0 ; tc<T;tc++)
        {
            N = sc.nextInt();
            int V= sc.nextInt();
            nodes = new Node[N+1];
            for(int i=1;i<=N;i++)
            {
                nodes[i] = new Node();
                nodes[i].idx = i;
                nodes[i].con = new ArrayList<>();
                nodes[i].color = 0;
            }
            for (int i=0;i<V;i++)
            {
                int s = sc.nextInt();
                int e = sc.nextInt();
                nodes[s].con.add(nodes[e]);
                nodes[e].con.add(nodes[s]);
            }
            visit = new boolean[N+1];
            boolean result = true;
            for(int i=1;i<=N;i++)
            {
                if(visit[i]==false)
                {
                    visit[i] = true;
                    result = bfs(i);
                    if(result == false)
                        break;
                }
            }
            if(result)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    public static boolean bfs(int start)
    {
        Queue<Node> q = new LinkedList<>();
        nodes[start].color = 1;
        q.offer(nodes[start]);
        while(!q.isEmpty())
        {
            Node s = q.poll();
            int length = s.con.size();
            for(int i=0;i<length;i++)
            {
                Node get = s.con.get(i);
                int idx=  get.idx;

                if(visit[idx]==false)
                {
                    int color = s.color;

                    if(color==1)
                        color = 2;
                    else if(color == 2)
                        color = 1;
                    visit[idx] = true;
                    nodes[idx].color = color;
                    q.offer(nodes[idx]);
                }else
                {
                    if(s.color==nodes[idx].color)
                        return false;
                }
            }
        }

        return true;
    }
}
