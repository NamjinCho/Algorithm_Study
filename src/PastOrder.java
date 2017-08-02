import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-02.
 */
public class PastOrder {

    static int N;
    static Node[] arr;
    static class Node{
        int idx;
        ArrayList<Node> next = new ArrayList<>();
    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int K = sc.nextInt();
        //arr= new int[N+1][N+1];
        arr=new Node[N+1];
        for(int i=1;i<=N;i++)
        {
            arr[i]=new Node();
            arr[i].idx=i;

        }
        for(int i=0;i<K;i++)
        {
           int s = sc.nextInt();
           int e = sc.nextInt();
           arr[s].next.add((arr[e]));
        }
        int T = sc.nextInt();
        for(int i=0;i<T;i++)
        {
            int s= sc.nextInt();
            int e = sc.nextInt();
            int [] r = new int[2];
            r[0] = bfs(s,e);
            if(r[0]==0)
            {
                r[1]=bfs(e,s);
                if(r[1]==0)
                    System.out.println(0);
                else
                    System.out.println(1);
            }else
            {
                System.out.println(-1);
            }
        }
    }
    public static int bfs(int s, int e)
    {
        boolean visit[] = new boolean[N+1];
        visit[s]=true;
        Queue<Node> q = new LinkedList<>();
        q.offer(arr[s]);
        while(!q.isEmpty())
        {
            Node ss= q.poll();
            int length = ss.next.size();
            for(int i=0;i<length;i++)
            {
                Node n = ss.next.get(i);
                if(!visit[n.idx])
                {
                    if(n.idx ==  e)
                        return 1;

                    visit[n.idx]=true;
                    q.offer(n);
                }
            }
        }
        return 0;
    }
}
