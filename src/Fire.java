import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-25.
 */
public class Fire {

    static int N,M;
    static char board[][];
    static int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
    static int cost[][];
    static boolean visit[][];
    static boolean hvisit[][];
    static int ans = Integer.MAX_VALUE;
    static class Pair{
        int row;
        int col;
        Pair(int r,int c)
        {
            row = r;
            col = c;
        }
    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        //sc.nextLine();
        for(int tc = 0; tc < T;tc++ )
        {
            String line = sc.nextLine();
            M = Integer.parseInt(line.split(" ")[0]);
            N = Integer.parseInt(line.split(" ")[1]);
            board = new char[N][M];
            int row = 0;
            int col = 0;
            Queue<Pair> fq = new LinkedList<>();
            visit=new boolean[N][M];
            hvisit = new boolean[N][M];
            ans=Integer.MAX_VALUE;
            for(int r=0;r<N;r++)
            {
                line = sc.nextLine();
                for(int c=0;c<M;c++)
                {
                    board[r][c]=line.charAt(c);
                    if(board[r][c]=='*')
                    {
                        Pair f = new Pair(r,c);
                        fq.offer(f);
                        visit[r][c] = true;
                    }else if(board[r][c]=='@')
                    {
                        row = r;
                        col = c;
                    }
                }
            }
            bfs(fq);
            hvisit[row][col]=true;
            dfs(row,col,1);
            if(ans==Integer.MAX_VALUE)
                System.out.println("IMPASSIBLE");
            else
                System.out.println(ans);
        }
    }
    public static void bfs(Queue<Pair> q)
    {

        cost = new int[N][M];
        //visit = new boolean[N][M];

        while(!q.isEmpty())
        {
            Pair f = q.poll();
             for(int i=0;i<4;i++)
            {
                int nr = f.row+dir[i][0];
                int nc = f.col+dir[i][1];
                if(nr>=0 && nr <N && nc >=0 && nc<M)
                {
                    if(!visit[nr][nc]&&board[nr][nc]!='#' )
                    {
                        cost[nr][nc] = cost[f.row][f.col]+1;
                        visit[f.row][f.col] = true;
                        Pair p = new Pair(nr,nc);
                        q.offer(p);
                    }
                }
            }
        }
    }
    public static void dfs(int row,int col, int count)
    {
        if(row==0 || col == 0 || row==N-1 || col==M-1) {
            ans = Math.min(ans,count);
            return;
        }
        for(int i=0;i<4;i++)
        {
            int nr = row+dir[i][0];
            int nc= col+dir[i][1];
            if(nr>=0 && nr <N && nc >=0 && nc<M)
            {
                if(!hvisit[nr][nc] && board[nr][nc]=='.')
                {
                    if(cost[nr][nc]!=0 && cost[nr][nc]<=count)
                        continue;
                    hvisit[nr][nc] = true;
                    dfs(nr,nc,count+1);
                    hvisit[nr][nc] = false;
                }
            }
        }
    }
}
