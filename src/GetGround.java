import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-04.
 */
public class GetGround {
    static int R,C,K;
    static int[][] arr;
    static boolean visit[][];
    static ArrayList<Integer> ans;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        arr=new int[R][C];
        K = sc.nextInt();
        for(int i=0;i<K;i++)
        {
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();

            for(int r = sy;r < ey;r++)
            {
                for(int c = sx; c<ex;c++)
                {
                    arr[R-r-1][c] = 1;
                }
            }
        }
        ans = new ArrayList<>();
        visit = new boolean[R][C];
        for(int r = 0;r<R;r++)
        {
            for(int c = 0;c<C;c++) {
                if(!visit[r][c] && arr[r][c]==0)
                {
                    ans.add(bfs(r,c));
                }
            }
        }
        ans.sort(null);
        System.out.println(ans.size());
        for(int i=0;i<ans.size();i++)
        {
            System.out.print(ans.get(i) + " ");
        }
    }
    public static int bfs(int row,int col)
    {
        int size = 1;

        visit[row][col]=true;
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        rq.offer(row);
        cq.offer(col);
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        while (!rq.isEmpty())
        {
            int rr = rq.poll();
            int cc= cq.poll();
            for(int i=0;i<4;i++)
            {
                int nr = rr+dir[i][0];
                int nc = cc+dir[i][1];
                if(nr>=0 && nr<R && nc>=0&& nc<C && !visit[nr][nc]&&arr[nr][nc]==0)
                {
                    visit[nr][nc]=true;
                    size++;
                    rq.offer(nr);
                    cq.offer(nc);
                }
            }
        }

        return size;
    }
}
