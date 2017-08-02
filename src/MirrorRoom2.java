
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-01.
 */
public class MirrorRoom2 {
    static int N;
    static char[][] map;
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map=new char[N][N];
        int r[]=new int[2];
        int c[]=new int[2];
        int idx=0;
        for(int i=0;i<N;i++)
        {
            String line = sc.nextLine();
            for(int j=0;j<N;j++)
            {
                map[i][j]=line.charAt(j);
                if(map[i][j]=='#')
                {
                  r[idx]=i;
                  c[idx]=j;
                  idx++;
                }
            }
        }
        int ans = bfs(r[0],c[0],r[1],c[1]);
        System.out.println(ans);

    }
    public static int bfs(int row,int col,int er,int ec)
    {
        boolean visit[][][] = new boolean[4][N][N];
        Queue<Light> q  =new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<4;i++)
        {
            q.offer(new Light(row,col,i,0));
            visit[i][row][col]=true;
        }
        while(!q.isEmpty())
        {
            Light l = q.poll();
            int nr = l.row;
            int nc = l.col;
            while(true)
            {
                nr+=dir[l.dir][0];
                nc+=dir[l.dir][1];
                //TODO : 거울 양방향으로 두개 큐 넣는식으로 수정 ㄱㄱ
                if(nr>=0 && nr <N && nc>=0 && nc<N)
                {
                    if(!visit[l.dir][nr][nc])
                    {
                        if(map[nr][nc]=='*')
                            break;
                        else if(map[nr][nc]=='.')
                        {
                            visit[l.dir][nr][nc]=true;
                            continue;
                        }else if(map[nr][nc]=='!')
                        {
                            visit[l.dir][nr][nc]=true;
                            int ndir[]=getDir(l.dir);


                            q.offer(new Light(nr,nc,ndir[0],l.cost+1));
                            q.offer(new Light(nr,nc,ndir[1],l.cost+1));
                            break;
                        }else if(map[nr][nc]=='#' && nr!=row && nc!=col)
                        {
                            min = Math.min(min,l.cost);
                            break;
                        }else
                            break;
                    }
                }else
                    break;
            }
        }
        return min;
    }
    public static int[] getDir(int dir)
    {
        int ndir[] = new int [2];
        //2 ->3 , 0 -> 1 , 1 -> 0 , 3->2
        if(dir==0) {
            ndir[0] = 3;
            ndir[1] = 1;
        }
        else if(dir==1) {
            ndir[0] = 2;
            ndir[1] = 0;
        }
        else if(dir==2) {
            ndir[0] = 1;
            ndir[1] = 3;
        }
        else {
            ndir[0] = 0;
            ndir[1] = 2;
        }
        return ndir;
    }
    public static class Light{
        int row;
        int col;
        int dir;
        int cost;
        Light(int r,int c,int d,int co)
        {
            row = r;
            col = c;
            dir = d;
            cost = co;
        }
    }
}
