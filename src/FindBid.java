import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-09.
 */
public class FindBid {

    static class Node{
        int idx;
        ArrayList<Node> con = new ArrayList<>();
    }
    static Node []ups,downs;
    static int N;

    public static void main(String [] args)
    {
        Scanner sc=  new Scanner(System.in);

        int ans = 0;

        N = sc.nextInt();
        int M = sc.nextInt();


        ups = new Node[N+1];
        downs = new Node[N+1];
        for(int i=1;i<=N;i++)
        {
            ups[i] = new Node();
            ups[i].idx = i;
            downs[i] = new Node();
            downs[i].idx = i;
        }
        for(int i=0;i<M;i++)
        {
            int s = sc.nextInt();
            int e= sc.nextInt();

            ups[s].con.add(ups[e]);
            downs[e].con.add(downs[s]);
        }

        for(int i=1;i<=N;i++)
        {
            if(bfs(ups[i]) || bfs(downs[i]))
                ans++;
        }
        System.out.println(ans);
    }
    public static boolean bfs(Node n)
    {
        boolean visit[] = new boolean[N+1];
        visit[n.idx] = true;

        Queue<Node> q = new LinkedList<>();
        q.offer(n);
        int count=0;
        while (!q.isEmpty())
        {
            Node nn = q.poll();

            int leng = nn.con.size();
            ArrayList<Node> con = nn.con;
            for(int i=0;i<leng;i++)
            {
                if(!visit[con.get(i).idx])
                {
                    count++;
                    if(count >= N/2)
                        return true;

                    visit[con.get(i).idx] = true;
                    q.offer(con.get(i));
                }
            }

        }


        return false;
    }

}
