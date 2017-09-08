import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-07.
 */
public class BrokenCal {
    static class Node{
        int x;
        int sx;
        int cost;
        boolean mul;
        Node(int i,int c,boolean m,int sx)
        {
            x=i;
            cost=c;
            mul = m;
            this.sx = sx;
        }
        public void print()
        {
            System.out.println(x+ " " + cost + " " + sx + " " + mul);
        }
    }
    static ArrayList<Integer> list;
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=0;tc<T;tc++)
        {

            list = new ArrayList<>();
            for(int i=0;i<10;i++)
            {
                int x= sc.nextInt();
                if(x==1)
                    list.add(i);
            }
            int X = sc.nextInt();
            int ans = bfs(X);
            System.out.println("#"+(tc+1) + " " + ans);
        }

    }
    public static int bfs(int ans)
    {
        boolean visit[] = new boolean[1000001];
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<list.size();i++)
        {
            if (list.get(i)==ans)
                return 2;

            q.offer(new Node(list.get(i),1,false,0));
            visit[list.get(i)]= true;
        }

        while(!q.isEmpty())
        {
            Node n = q.poll();

            System.out.print("Start : ");
            n.print();

            for(int i=0;i<list.size();i++)
            {
                if(n.mul)
                {
                    int ns = n.sx*10 + list.get(i);
                    if(ns*n.x>1000000)
                        continue;
                    if(visit[ns*n.x]==false)
                    {
                        Node nn =new Node(ns*n.x,n.cost+2,false,0);
                        System.out.print("propagated : ");
                        nn.print();
                        if(nn.x==ans)
                            return nn.cost;

                        q.offer(nn);

                        nn =new Node(n.x,n.cost+1,true,ns);
                        q.offer(nn);
                        System.out.print("propagated : ");
                        nn.print();
                        visit[ns*n.x] = true;
                    }
                }else
                {
                    int ns = n.x*10 + list.get(i);
                    if(ns>1000000)
                        continue;
                    if(visit[ns]==false)
                    {
                        Node nn =new Node(ns,n.cost+1,false,0);
                        if(nn.x==ans)
                            return nn.cost+1;
                        q.offer(nn);
                        visit[ns] = true;
                        System.out.print("propagated : ");
                        nn.print();
                    }
                }
            }
            if(!n.mul)
            {
                Node nn = new Node(n.x,n.cost+1,true,n.sx);
                q.offer(nn);
                //System.out.print("propagated : ");
                //nn.print();
            }
        }
        return -1;
    }
}
