import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-30.
 */
public class Rain {
    static int N;
    static int [][] map;
    static boolean visit[][];
    static int max;

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int hm = 0;
        N = sc.nextInt();
        map = new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                map[i][j] = sc.nextInt();
                hm=Math.max(hm,map[i][j]);
            }
        }
        max=0;
        for(int h=hm;h>0;h--)
        {
            visit=new boolean[N][N];
            int count = 0;
            for(int r=0;r<N;r++)
            {
                for(int c=0;c<N;c++)
                {

                    if(visit[r][c] || map[r][c] <h)
                        continue;
                    bfs(r,c,h);
                    count++;
                }
            }
            max=Math.max(max,count);
        }
        System.out.println(max);
    }
    public static void bfs(int r , int c,int h)
    {
        visit[r][c] = true;
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        rq.offer(r);
        cq.offer(c);
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};

        while(!rq.isEmpty())
        {
            int rr = rq.poll();
            int cc = cq.poll();
            for(int i=0;i<4;i++)
            {
                int nr = rr+dir[i][0];
                int nc = cc+dir[i][1];
                if(nr>=0 && nr<N && nc >= 0 && nc < N && !visit[nr][nc] && map[nr][nc]>=h)
                {
                    rq.offer(nr);
                    cq.offer(nc);
                    visit[nr][nc] = true;
                }
            }
        }
    }
}
