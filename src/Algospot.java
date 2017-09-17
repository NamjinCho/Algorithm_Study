import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-15.
 */
public class Algospot {
    static int N,M;
    static int[][]board;

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        int zero = '0';
        board = new int[N][M];
        sc.nextLine();

        for(int i=0;i<N;i++)
        {
            String line = sc.nextLine();
            for(int j=0;j<M;j++)
            {
                board[i][j] = line.charAt(j)-zero;
            }
        }
        int ans = bfs();
        System.out.println(ans);
    }
    public static int bfs()
    {
        Queue<Integer> rq=new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        rq.offer(0);
        cq.offer(0);
        int visit[][] = new int[N][M];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
        visit[0][0] = 0;
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        while (!rq.isEmpty())
        {
            int r = rq.poll();
            int c = cq.poll();

            for(int i=0;i<4;i++)
            {
                int nr = r+dir[i][0];
                int nc = c+dir[i][1];
                if(nr>=0 && nr<N && nc>=0 && nc<M)
                {
                    int cost = visit[r][c];
                    if(board[nr][nc]==1)
                        cost++;


                    if(nr==N-1 && nc==M-1)
                    {
                        if(visit[nr][nc] > cost)
                            visit[nr][nc] = cost;
                    }else
                    {
                        if(visit[nr][nc] > cost)
                        {
                            rq.offer(nr);
                            cq.offer(nc);
                            visit[nr][nc] = cost;
                        }
                    }
                }
            }
        }
        return visit[N-1][M-1];
    }
}
