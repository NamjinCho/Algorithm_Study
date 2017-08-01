import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-31.
 */
public class Tomato1 {

    static int N,M,Min,map[][];
    static int dir[][] ={{0,1},{1,0},{0,-1},{-1,0}};
    static int count;
    static Queue<Node> startQ;
    static boolean visit[][];
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map= new int[N][M];
        visit=new boolean[N][M];
        startQ = new LinkedList<>();
        count = 0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                map[i][j]=sc.nextInt();
                if(map[i][j]==1) {
                    startQ.offer(new Node(i, j, 0));
                    visit[i][j]=true;
                }
                if(map[i][j]==0)
                    count++;
            }
        }
        Min = Integer.MAX_VALUE;
        Min = bfs();
        if(Min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(Min);

    }
    public static int bfs()
    {
        if(count==0)
            return 0;

        while (!startQ.isEmpty())
        {
            Node no = startQ.poll();
            for(int i=0;i<4;i++) {
                int nr = no.row+dir[i][0];
                int nc = no.col+dir[i][1];
                int co = no.cost+1;
                if(nr>=0&&nr<N&&nc>=0&&nc<M) {

                    if(!visit[nr][nc] && map[nr][nc]==0)
                    {
                        count--;
                        visit[nr][nc]=true;
                        startQ.offer(new Node(nr,nc,co));
                    }

                    if (count == 0)
                        return co;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    static class Node{
        int row;
        int col;
        int cost;
        Node(int r,int c,int c2)
        {
            row=r;
            col=c;
            cost=c2;
        }
    }

}
