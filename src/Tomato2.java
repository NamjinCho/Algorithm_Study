import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-31.
 */
public class Tomato2 {

    static int N,M,H,Min,map[][][];
    static int dir[][] ={{0,1},{1,0},{0,-1},{-1,0},{1,0},{-1,0}};
    static int count;
    static Queue<Node> startQ;
    static boolean visit[][][];
    public static void main(String [] args)
    {

        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        map= new int[H][N][M];
        visit=new boolean[H][N][M];
        startQ = new LinkedList<>();
        count = 0;
        for(int h=0;h<H;h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[h][i][j] = sc.nextInt();
                    if (map[h][i][j] == 1) {
                        startQ.offer(new Node(i, j, h,0));
                        visit[h][i][j] = true;
                    }
                    if (map[h][i][j] == 0)
                        count++;
                }
            }
        }
        for(int h=0;h<H;h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(map[h][i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        Min = bfs();

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
                int nr = no.row;
                int nc = no.col;
                int nh = no.hei;
                int co = no.cost+1;
                if(i<4)
                {
                    nr=nr+dir[i][0];
                    nc=nc+dir[i][1];
                }else
                {
                    nh=nh+dir[i][0];
                }
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&nh>=0 && nh<H) {

                    if(!visit[nh][nr][nc] && map[nh][nr][nc]==0)
                    {
                        count--;
                        visit[nh][nr][nc]=true;
                        startQ.offer(new Node(nr,nc,nh,co));
                    }

                    if (count == 0)
                        return co;
                }
            }
        }
        return -1;
    }
    static class Node{
        int row;
        int col;
        int hei;
        int cost;
        Node(int r,int c,int h,int c2)
        {
            row=r;
            col=c;
            cost=c2;
            hei=h;
        }
    }

}
