import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-31.
 */
public class Knight {
    static int N;

    static int dir[][] = {{-1,-2},{-2,-1},{-1,2},{-2,1},{1,2},{2,1},{2,-1},{1,-2}};
    public static void main(String [] args)
    {
        Scanner sc =new Scanner(System.in);
        int T = sc.nextInt();
        int row,col,dsr,dsc;
        for(int tc=0;tc<T;tc++) {
            N = sc.nextInt();
            row = sc.nextInt();
            col = sc.nextInt();
            dsr = sc.nextInt();
            dsc = sc.nextInt();
            System.out.println(bfs(row,col,dsr,dsc));
        }
    }
    public static int bfs(int row,int col,int dr,int dc)
    {
        boolean visit[][] = new boolean[N][N];
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        Queue<Integer> cost = new LinkedList<>();

        if(row==dr && col == dc)
            return 0;
        visit[row][col] = true;
        rq.offer(row);
        cq.offer(col);
        cost.offer(0);
        while(!rq.isEmpty())
        {
            int rr = rq.poll();
            int cc = cq.poll();
            int costs = cost.poll();
            for(int i=0;i<8;i++)
            {
                int nr = dir[i][0]+rr;
                int nc = dir[i][1]+cc;

                if(nr>=0 && nr < N && nc >=0 && nc<N)
                {
                    if(!visit[nr][nc])
                    {
                        if(nr==dr && nc == dc)
                            return costs+1;
                        visit[nr][nc]=true;
                        rq.offer(nr);
                        cq.offer(nc);
                        cost.offer(costs+1);
                    }
                }

            }
        }
        return 0;
    }
}
