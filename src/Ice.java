import java.util.*;

/**
 * Created by NamjinCho on 2017-07-28.
 */
public class Ice {

    static class Pair{
        int row;
        int col;
        Pair(int r,int c)
        {
            row=r;
            col=c;
        }
    }
    static int N;
    static int M;
    static int board[][];
    static ArrayList<Pair> iceList;
    static int total;
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        iceList = new ArrayList<>();

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                board[i][j] = sc.nextInt();
                if(board[i][j]>0)
                {
                    Pair p = new Pair(i,j);
                    iceList.add(p);
                }
            }
        }
        int ans=0;
        while(true)
        {
            if(iceList.size()==0) {
                ans = 0;
                break;
            }
            total = iceList.size();

            bfs();
            if(total!=0)
            {
                break;
            }
            ans++;
            deletion();
        }
        System.out.println(ans);
    }
    public static void deletion()
    {
        int i=0;
        while(i<iceList.size())
        {
            Pair p = iceList.get(i);
            if(board[p.row][p.col]==0)
            {
                iceList.remove(i);
                continue;
            }
            i++;
        }
    }
    public static void bfs()
    {
        int row = iceList.get(0).row;
        int col = iceList.get(0).col;
        Queue <Integer> rq = new LinkedList<>();
        Queue <Integer> cq = new LinkedList<>();
        boolean visit[][] = new boolean[N][M];
        rq.offer(row);
        cq.offer(col);
        visit[row][col]=true;
        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!rq.isEmpty())
        {
            total--;
            int r = rq.poll();
            int c = cq.poll();

            for(int i=0;i<4;i++)
            {
                int nr = r+dir[i][0];
                int nc = c+dir[i][1];

                if(nr>=0 && nr < N && nc >=0 && nc <M)
                {
                    if(board[nr][nc] == 0 && board[r][c]>0 && !visit[nr][nc])
                    {
                        board[r][c]--;
                    }else if(!visit[nr][nc] && board[nr][nc]>0)
                    {
                        visit[nr][nc] = true;
                        rq.offer(nr);
                        cq.offer(nc);
                    }
                }
            }
        }
    }
}
