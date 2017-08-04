import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-04.
 */
public class FamilyNo {
    static class Node{
        int idx;
        int cost;
        ArrayList<Node> connected;
    }
    static int N;
    static Node arr[];
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new Node[N+1];
        int s,e;
        s = sc.nextInt();
        e = sc.nextInt();
        int m = sc.nextInt();
        for(int i=1;i<=N;i++)
        {
            arr[i] = new Node();
            arr[i].idx = i;
            arr[i].connected = new ArrayList<>();
        }
        for(int i=0;i<m;i++)
        {
            int a,b;
            a = sc.nextInt();
            b = sc.nextInt();
            arr[a].connected.add(arr[b]);
            arr[b].connected.add(arr[a]);
        }
        int ans = bfs(s,e);
        System.out.println(ans);

    }
    public static int bfs(int s, int e)
    {
        boolean visit[] = new boolean[N+1];
        Queue<Node> q = new LinkedList<>();
        q.offer(arr[s]);
        visit[s] = true;
        while (!q.isEmpty())
        {
            Node n = q.poll();
            int length = n.connected.size();
            for(int i=0;i<length;i++)
            {
                if(!visit[n.connected.get(i).idx])
                {
                    if(n.connected.get(i).idx ==e)
                        return n.cost+1;

                    visit[n.connected.get(i).idx] =true;
                    n.connected.get(i).cost = n.cost+1;
                    q.offer(n.connected.get(i));
                }
            }
        }
        return -1;
    }
}
