import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-03.
 */
public class Maze
{
    static int N,M,map[][];
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String sub[] = line.split(" ");
        N=Integer.parseInt(sub[0]);
        M=Integer.parseInt(sub[1]);

        map=new int[N][M];
        for(int i=0;i<N;i++)
        {
            line = sc.nextLine();
            for(int j=0;j<M;j++)
            {
                map[i][j]=line.charAt(j)-'0';
            }
        }
        int ans = bfs(0,0);
        System.out.println(ans);

    }
    public static int bfs(int row,int col)
    {

        if(row==N-1 && col == M-1)
            return 0;

        Queue<Integer>rq = new LinkedList<>();
        Queue<Integer>cq = new LinkedList<>();
        Queue<Integer>co = new LinkedList<>();
        boolean [][] visit = new boolean[N][M];
        visit[row][col] = true;
        rq.offer(row);
        cq.offer(col);
        co.offer(1);
        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        while (!rq.isEmpty())
        {
            int rr,cc,oo;
            rr = rq.poll();
            cc=cq.poll();
            oo=co.poll();
            for(int i=0;i<4;i++)
            {
                int nr = rr + dir[i][0];
                int nc = cc + dir[i][1];
                int no= oo+1;
                if(nr>=0 && nr<N && nc >=0 && nc <M)
                {
                    if(!visit[nr][nc] && map[nr][nc]==1)
                    {
                        if(nr == N-1 && nc == M-1)
                            return no;

                        visit[nr][nc]=true;
                        rq.offer(nr);
                        cq.offer(nc);
                        co.offer(no);
                    }
                }
            }
        }
        return 0;
    }
}
