import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-08.
 */
public class SameParents {

    static class Node{
        int idx;
        Node parent;
        Node lc;
        Node rc;
    }
    static Node[] nodes;
    static int N,E,v1,v2;
    static boolean[] visit;
    public static void main(String []args)
    {
        Scanner sc=  new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++)
        {
            N = sc.nextInt();
            E = sc.nextInt();
            v1 = sc.nextInt();
            v2 = sc.nextInt();
            nodes = new Node[N+1];
            for(int i=1;i<=N;i++)
            {
                nodes[i] = new Node();
                nodes[i].idx = i;
            }
            for(int i=0;i<E;i++)
            {
                int p = sc.nextInt();
                int e = sc.nextInt();
                insertion(p,e);
            }
            visit = new boolean[N+1];
            int ans = 0;
            int cp = getCommonParent(v1,v2);
            ans = countingNode(cp);
            System.out.println("#"+tc+" "+cp+" "+ans);
        }
    }
    public static int countingNode(int idx)
    {
        int lc =0;
        int rc =0;

        if(nodes[idx].lc!=null)
            lc=countingNode(nodes[idx].lc.idx);
        if(nodes[idx].rc!=null)
        {
            rc = countingNode(nodes[idx].rc.idx);
        }
        return lc+rc + 1;
    }
    public static void insertion(int p,int c)
    {
        if(nodes[p].lc==null)
        {
            nodes[p].lc = nodes[c];
        }else{
            nodes[p].rc = nodes[c];
        }
        nodes[c].parent = nodes[p];
    }
    public static int getCommonParent(int a, int b)
    {


        if(a==b)
        {
            return a;
        }else
        {

            int na = a;
            int nb= b;

            if(nodes[a].parent!=null )
            {
                na = nodes[a].parent.idx;
            }
            if(nodes[b].parent!=null)
            {
                nb = nodes[b].parent.idx;
            }
            if(visit[na] && na!=a)
                return na;
            else if(visit[nb] && nb!=b)
                return nb;
            visit[na] = true;
            visit[nb] = true;
            return getCommonParent(na,nb);
        }
    }

}
