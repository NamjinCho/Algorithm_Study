import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-29.
 */
public class Find {

    static int N;
    static int M;
    static char board[][];
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board =new char [N][M];
        sc.nextLine();
        for(int i=0;i<N;i++)
        {
            String line = sc.nextLine();
            for(int j=0;j<M;j++)
            {
                board[i][j] = line.charAt(j);
            }
        }
        int ans = 0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(board[i][j]=='L')
                {
                    ans=Math.max(bfs(i,j),ans);
                }
            }
        }
        System.out.println(ans);
    }
    public static int bfs(int row , int col)
    {
        boolean visit[][] = new boolean[N][M];
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        rq.offer(row);
        cq.offer(col);
        visit[row][col] = true;
        int cost[][] = new int [N][M];
        int dir[][] ={{0,1},{1,0},{0,-1},{-1,0}};
        int max  = 0;
        while(!rq.isEmpty())
        {
            int rr = rq.poll();
            int cc = cq.poll();
            for(int i=0;i<4;i++)
            {
                int nr = rr+dir[i][0];
                int nc = cc+dir[i][1];
                if(nr>=0 && nr < N && nc >=0 && nc<M &&board[nr][nc]=='L'&& !visit[nr][nc])
                {
                    visit[nr][nc] = true;
                    rq.offer(nr);
                    cq.offer(nc);
                    cost[nr][nc] = cost[rr][cc]+1;
                    max = Math.max(cost[nr][nc],max);
                }
            }
        }
        return max;

    }

}
