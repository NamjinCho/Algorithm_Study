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
    static int ans = Integer.MAX_VALUE;
    static class Pair{
        int row;
        int col;
        boolean isFire;
        Pair(int r,int c,boolean f)
        {
            row = r;
            col = c;
            isFire = f;
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
            ans=Integer.MAX_VALUE;
            Pair h  = new Pair(-1,-1,false);
            for(int r=0;r<N;r++)
            {
                line = sc.nextLine();
                for(int c=0;c<M;c++)
                {
                    board[r][c]=line.charAt(c);
                    if(board[r][c]=='*')
                    {
                        Pair f = new Pair(r,c,true);
                        fq.offer(f);
                    }else if(board[r][c]=='@')
                    {
                        row = r;
                        col = c;
                        h=new Pair(r,c,false);
                    }
                }
            }
            if(h.row == -1 && h.col==-1)
            {
                System.out.println("IMPOSSIBLE");
                return;
            }

            fq.offer(h);
            ans = bfs(fq);
            if(row == 0 || row == N-1 || col==0 || col==M-1)
                System.out.println("1");
            else if(ans==-1)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(ans+1);
        }
    }
    public static int bfs(Queue<Pair> q)
    {

        cost = new int[N][M];

        while(!q.isEmpty())
        {
            Pair f = q.poll();
             for(int i=0;i<4;i++)
            {
                int nr = f.row+dir[i][0];
                int nc = f.col+dir[i][1];
                 if(nr>=0 && nr < N &&nc>=0 && nc<M) {

                    if (f.isFire) {
                        if(board[nr][nc]=='#' || board[nr][nc]=='*')
                            continue;
                        Pair np = new Pair(nr,nc,true);
                        q.offer(np);
                        board[nr][nc]='*';
                    } else {
                        if(board[nr][nc]=='@' || board[nr][nc]=='#' || board[nr][nc]=='*') {
                            continue;
                        }
                        else {
                            Pair np = new Pair(nr, nc, false);
                            q.offer(np);
                            cost[nr][nc] = cost[f.row][f.col] + 1;
                            board[nr][nc]='@';
                            if (nr == 0 || nr == N - 1 || nc == 0 || nc == M - 1) {
                                return cost[nr][nc];
                            }
                        }
                    }
                }

            }
        }
        return -1;
    }
}
