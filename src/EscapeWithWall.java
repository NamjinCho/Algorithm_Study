import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-16.
 */
public class EscapeWithWall {
    static class Ele{
        int row;
        int col;
        int cost;
        int bw;

        Ele(int r , int c, int co , int bw)
        {
            row = r;
            col =c;
            cost =co;
            this.bw = bw;
        }
    }
    public static int N,M;
    public static int [][] map;
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String [] args)
    {
        Scanner sc =new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        sc.nextLine();
        char zero = '0';
        for(int i=0;i<N;i++)
        {
            String line =sc.nextLine();
            for(int j=0;j<M;j++)
            {
                map[i][j] = line.charAt(j)-zero;
            }
        }
        int ans = bfs();
        System.out.println(ans);
    }
    public static int bfs()
    {
        Queue<Ele> q = new LinkedList<>();
        boolean visit [][][] =new boolean[2][N][M];
        visit[0][0][0] = true;
        q.offer(new Ele(0,0,1,0));
        while(!q.isEmpty())
        {
            Ele e = q.poll();

            for(int i=0;i<4;i++)
            {
                int nr = e.row+dir[i][0];
                int nc = e.col+dir[i][1];

                if(nr>=0&&nr<N && nc>=0 && nc<M)
                {
                    if(nr == N-1 && nc == M-1)
                        return e.cost+1;

                    if(map[nr][nc]==0)
                    {
                        if(!visit[e.bw][nr][nc])
                        {
                            visit[e.bw][nr][nc]=true;
                            q.offer(new Ele(nr,nc,e.cost+1,e.bw));
                        }

                    }else
                    {
                        if(!visit[e.bw][nr][nc] && e.bw==0)
                        {
                            visit[e.bw][nr][nc]=true;
                            q.offer(new Ele(nr,nc,e.cost+1,e.bw+1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
