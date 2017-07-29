import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-27.
 */
public class Bridge {
    static int N;
    static int map[][];
    static boolean visit[][],visit2[][];
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    static int gidx;
    static int ans,srow,scol;
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int [N][N];
         visit = new boolean[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                map[i][j] = sc.nextInt();
                if(map[i][j]==0)
                    visit[i][j]=true;
            }
        }
        gidx=1;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(map[i][j]==1)
                {
                    gidx+=mapDivide(i,j);
                }
            }
        }

        ans=Integer.MAX_VALUE;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++) {
                if (map[i][j] != 0) {
                    srow=i;
                    scol=j;
                    ans=Math.min(bfs(i,j),ans);
                }
            }
        }
        System.out.println(ans);
    }
    public static int bfs(int row,int col)
    {
        int cost[][] = new int[N][N];
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        int s = map[row][col];

        rq.offer(row);
        cq.offer(col);
        visit = new boolean[N][N];
        visit[row][col] = true;
        while(!rq.isEmpty())
        {
            int rr = rq.poll();
            int cc= cq.poll();
            for(int i=0;i<4;i++)
            {
                int nr=rr+dir[i][0];
                int nc=cc+dir[i][1];

                if(nr >=0 && nr < N &&  nc >=0 && nc<N)
                {
                    if(map[row][col]!=map[nr][nc] && !visit[nr][nc])
                    {
                        visit[nr][nc] = true;
                        cost[nr][nc] = cost[rr][cc]+1;
                        if(map[nr][nc]!= 0 && map[nr][nc]!=s)
                            return cost[rr][cc];
                        rq.offer(nr);
                        cq.offer(nc);
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    public static int mapDivide(int row,int col)
    {
        if(visit[row][col])
            return 0;


        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        map[row][col] = gidx;
        rq.offer(row);
        cq.offer(col);
        visit[row][col] = true;
        while (!rq.isEmpty())
        {
            int nr = rq.poll();
            int nc = cq.poll();
            for(int i=0;i<4;i++)
            {
                int rr = nr+dir[i][0];
                int cc = nc+dir[i][1];
                if(rr>=0&&rr<N &&cc>=0&&cc<N && !visit[rr][cc])
                {
                    map[rr][cc] = gidx;
                    visit[rr][cc]=true;
                    rq.offer(rr);
                    cq.offer(cc);
                }
            }
        }
        return 1;
    }

}
