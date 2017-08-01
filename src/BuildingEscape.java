import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-30.
 */
public class BuildingEscape {

    static int R,C,H;
    static char[][][] map;

    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);

        String line = sc.nextLine();

        while(!line.contains("0 0 0"))
        {
            String [] sub = line.split(" ");
            H = Integer.parseInt(sub[0]);
            R = Integer.parseInt(sub[1]);
            C = Integer.parseInt(sub[2]);
            map = new char[H][R][C];
            int sRow=-1 ,sCol=-1,sH=-1;
            for(int l = 0 ; l<H;l++)
            {
                for(int r=0;r<R;r++)
                {   String ml = sc.nextLine();
                    for(int c=0;c<C;c++)
                    {
                        map[l][r][c] = ml.charAt(c);
                        if(map[l][r][c]=='S')
                        {
                            sRow = r;
                            sCol =c;
                            sH = l;
                        }
                    }
                }
                sc.nextLine();
            }
            int result = bfs(sRow,sCol,sH);
            if(result!=-1)
            {
                System.out.println("Escaped in "+result+ " minute(s).");
            }else
            {
                System.out.println("Trapped!");
            }
            line = sc.nextLine();
        }
    }
    public static int bfs(int row,int col,int h)
    {
        boolean visit[][][] = new boolean[H][R][C];
        visit[h][row][col]=true;
        Queue<Integer> rq,cq,hq,cost;
        rq = new LinkedList<>();
        cq = new LinkedList<>();
        hq = new LinkedList<>();
        cost = new LinkedList<>();
        rq.offer(row);
        cq.offer(col);
        hq.offer(h);
        cost.offer(0);
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!rq.isEmpty())
        {
            int rr=  rq.poll();
            int cc= cq.poll();
            int hh = hq.poll();
            int co = cost.poll();
            for(int i=0;i<6;i++)
            {
                int nh =hh;
                int nr= rr;
                int nc = cc;
                if(i<4)
                {
                    nr = nr+dir[i][0];
                    nc = nc+dir[i][1];

                }else
                {

                    if(i==4)
                        nh = nh-1;
                    else
                        nh = nh+1;

                }

                if(nh>=0 && nh<H &&nr >=0 &&nr<R &&nc>=0 &&nc<C && !visit[nh][nr][nc])
                {
                    if(map[nh][nr][nc] =='.')
                    {
                        rq.offer(nr);
                        cq.offer(nc);
                        hq.offer(nh);
                        cost.offer(co+1);
                        visit[nh][nr][nc] = true;
                    }else if(map[nh][nr][nc]=='E')
                    {
                        return co+1;
                    }
                }
            }

        }

        return -1;
    }
}
