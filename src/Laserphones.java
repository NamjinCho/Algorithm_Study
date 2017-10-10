import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-07.
 */
public class Laserphones {
    static char[][] arr;
    static int eRow,eCol;
    static int R,C;
    static class Element{
        int row;
        int col;
        int lc;
        int dir;

        Element(int r, int c,int l,int d)
        {
            row = r;
            col = c;
            lc = l;
            dir= d;
        }
    }
    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);

        C = sc.nextInt();
        R = sc.nextInt();
        sc.nextLine();
        arr = new char[R][C];
        int r=-1,c=-1;
        for(int i=0;i<R;i++)
        {
            String line = sc.nextLine();
            for(int j=0;j<C;j++)
            {
                arr[i][j] = line.charAt(j);
                if(r==-1 && arr[i][j]=='C')
                {
                    r = i;
                    c = j;
                }else if(r!=-1 && arr[i][j]=='C')
                {
                    eRow = i;
                    eCol = j;
                }
            }
        }
        if(eRow!=r || eCol!=c) {
            int ans = bfs(r, c);
            if (ans == Integer.MAX_VALUE)
                ans = -1;
            else
                ans = ans - 1;

            System.out.println(ans);
        }else
        {
            System.out.println(0);
        }
    }
    public static int bfs(int sr,int sc)
    {
        Queue<Element> q = new LinkedList<>();
        int visit[][] = new int[R][C];
        q.offer(new Element(sr,sc,0,-1));
        int dir[][] ={{0,1},{1,0},{0,-1},{-1,0}};
        visit[sr][sc]=1;
        visit[eRow][eCol] = Integer.MAX_VALUE;
        while (!q.isEmpty())
        {
            Element e = q.poll();
            for(int i=0;i<4;i++)
            {
                int nr = e.row+dir[i][0];
                int nc = e.col+dir[i][1];

                if(nr>=0 && nc>=0 && nr<R && nc<C)
                {
                    if(arr[nr][nc]!='*')
                    {
                        int nlc = e.lc;
                        if(i!=e.dir)
                            nlc++;
                        if(visit[nr][nc]==0 || visit[nr][nc]>=nlc)
                        {
                            visit[nr][nc]= nlc;

                            if(nr==eRow && nc==eCol)
                            {
                                continue;
                            }
                            q.offer(new Element(nr,nc,nlc,i));
                        }
                    }

                }

            }
        }
        return visit[eRow][eCol];
    }

}
