import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-29.
 */
public class Virus3 {
    static int N,M;
    static int arr[][];
    static int count = 0;
    static ArrayList<Integer> rq;
    static ArrayList<Integer> cq;
    static int ans;
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        rq = new ArrayList<>();
        cq = new ArrayList<>();

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                arr[i][j] = sc.nextInt();

                if(arr[i][j] == 0)
                    count++;
                else if(arr[i][j]==2)
                {
                    rq.add(i);
                    cq.add(j);
                }
            }
        }
        ans = 0;
        count=count-3;
        if(arr[0][0] == 0)
        {
            arr[0][0] = 1;
            dfs(0,0,1);
            arr[0][0] = 0;
        }
        dfs(0,0,0);
        System.out.println(ans);
    }
    public static void bfs()
    {
        int total = count;
        Queue<Integer> rrq = new LinkedList<>();
        Queue<Integer> ccq = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        for(int i=0;i<rq.size();i++)
        {
            int r = rq.get(i);
            int c = cq.get(i);

            visit[r][c]=true;
            rrq.offer(r);
            ccq.offer(c);
        }
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        while (!rrq.isEmpty())
        {
            int r = rrq.poll();
            int c = ccq.poll();
            for(int i=0;i<4;i++)
            {
                int nr = r+dir[i][0];
                int nc = c+dir[i][1];
                if(nr>=0 && nr<N && nc>=0 && nc<M)
                {
                    if(!visit[nr][nc] && arr[nr][nc]==0)
                    {
                        total--;
                        rrq.offer(nr);
                        ccq.offer(nc);
                        visit[nr][nc] = true;
                    }
                }
            }
        }
        ans = Math.max(ans,total);

    }
    public static void dfs(int row,int col,int cnt)
    {
        if(cnt==3) {
            bfs();
            return;
        }
       // System.out.println(row + " / " + col + " / " + count);
        int nr = row;
        int nc = col+1;

        if(nc==M)
        {
            nc=0;
            nr++;
        }


        if(nr<N)
        {
            if(arr[nr][nc]==0)
            {
                arr[nr][nc] = 1;
                dfs(nr,nc,cnt+1);
                arr[nr][nc] = 0;
            }
            dfs(nr,nc,cnt);
        }
    }
}
