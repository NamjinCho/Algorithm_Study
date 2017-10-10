import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-07.
 */
public class FarmProb
{

    static int N;
    static int goCount;
    static int arr[][];
    static int [][]dir={{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();

        for(int tc=1;tc<=T;tc++)
        {
            N = sc.nextInt();
            goCount = N/2 +1;

            arr = new int[N][N];
            sc.nextLine();
            for(int i=0;i<N;i++)
            {
                String line = sc.nextLine();
                for(int j=0;j<N;j++)
                    arr[i][j] = line.charAt(j)-'0';
            }
            int row = N/2;
            int col = N/2;
            int ans=bfs(row,col);

            System.out.println("#"+tc+" " + ans);
        }
    }
    public static int bfs(int row,int col)
    {
        int total =arr[row][col];

        boolean visit[][] = new boolean[N][N];
        visit[row][col] = true;

        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        Queue<Integer> count = new LinkedList<>();

        rq.offer(row);
        cq.offer(col);
        count.offer(1);

        while (!rq.isEmpty())
        {
            int rr = rq.poll();
            int cc= cq.poll();
            int co = count.poll();
            if(co==goCount)
                continue;

            for(int i=0;i<4;i++)
            {
                int nr =rr+dir[i][0];
                int nc =cc+dir[i][1];

                if(!visit[nr][nc])
                {
                    visit[nr][nc] = true;
                    rq.offer(nr);
                    cq.offer(nc);
                    count.offer(co+1);
                    total += arr[nr][nc];
                }

            }
        }
        return total;
    }
}
