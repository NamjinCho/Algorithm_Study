import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-02.
 */
public class Cave {
    static class Node{
        int idx;
        int benefit;
        ArrayList<Node> next;
        ArrayList<Integer>cost;
    }
    static int N;
    static Node [] nodes;
    static boolean visit[];
    static int Max;
    static LinkedList<Node> list,ans;
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc= 0;tc<T;tc++) {
            N = sc.nextInt();
            int E = sc.nextInt();
            nodes = new Node[N + 1];
            visit = new boolean[N + 1];
            Max = 0;
            list = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                nodes[i] = new Node();
                nodes[i].benefit = sc.nextInt();
                nodes[i].next=new ArrayList<>();
                nodes[i].cost = new ArrayList<>();
                nodes[i].idx = i;
            }

            for (int i = 0; i < E; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                nodes[a].cost.add(c);
                nodes[a].next.add(nodes[b]);
            }
            list.add(nodes[1]);
            dfs(nodes[1],nodes[1].benefit);
            System.out.println(Max + " " + ans.size());
            while (!ans.isEmpty())
            {
                System.out.print(ans.removeFirst().idx+" ");
            }
            System.out.println();
        }
    }
    public static void dfs(Node start,int sum)
    {
        int length = start.next.size();

        for(int i=0;i<length;i++)
        {
            Node ne = start.next.get(i);

            if(!visit[ne.idx])
            {
                visit[ne.idx]=true;
                list.add(ne);
                dfs(ne,sum+(ne.benefit-start.cost.get(i)));
                visit[ne.idx]=false;
                list.removeLast();
            }
        }
        if(sum > Max)
        {
            ans = (LinkedList<Node>) list.clone();
            Max = sum;
        }

    }

}
