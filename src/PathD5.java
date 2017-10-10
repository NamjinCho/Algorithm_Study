import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-08.
 */
public class PathD5 {

    static class Node{
        int x;
        int y;
        Node(int c,int r)
        {
            x= c;
            y=r;
        }
    }
    static boolean visit[];
    static Node [] nodes;
    static int ans = 0;
    static int N;
    public static void main(String []args)
    {
        Scanner sc =  new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc= 1;tc<=T;tc++)
        {
            N = sc.nextInt();
            nodes = new Node[N+2];

            int x= sc.nextInt();
            int y= sc.nextInt();
            nodes[0] = new Node(x,y);

            x = sc.nextInt();
            y = sc.nextInt();
            nodes[1] = new Node(x,y);
            for(int i=2;i<N+2;i++)
            {
                nodes[i] = new Node(sc.nextInt(),sc.nextInt());
            }
            visit = new boolean[N+2];
            visit[0] = true;
            visit[1] = true;
            ans = Integer.MAX_VALUE;
            dfs(0,0,0);
            System.out.println("#"+tc+" " + ans);
        }
    }
    public static int getDist(int idx1,int idx2)
    {
        int difX = nodes[idx1].x - nodes[idx2].x;
        int difY = nodes[idx1].y - nodes[idx2].y;
        difX = Math.abs(difX);
        difY = Math.abs(difY);
        return difX + difY;
    }
    public static void dfs(int idx, int sum,int count)
    {
        if(count == N)
        {
            ans = Math.min(sum+getDist(1,idx),ans);
        }
        if(sum >=ans)
            return;
        for(int i=2;i<N+2;i++)
        {
            if(!visit[i])
            {
                visit[i] = true;

                dfs(i,getDist(idx,i)+sum,count+1);
                visit[i] = false;
            }
        }
    }
}
