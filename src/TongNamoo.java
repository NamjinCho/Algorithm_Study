import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-22.
 */
public class TongNamoo {

    static class Tree{
        int row;
        int col;
        int state;
        int mCount;
        Tree(int r, int c , int b,int mo)
        {
            row = r;
            col = c;
            state = b;
            mCount = mo;
        }
    }
    static char map[][];
    static int N;
    static Tree start,end;
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map= new char[N][N];
        sc.nextLine();
        int [][]row = new int[2][3];
        int [][]col = new int[2][3];
        int tid=0,eid=0;

        for(int i=0;i<N;i++)
        {
            String line = sc.nextLine();
            for(int j=0;j<N;j++)
            {
                char item = line.charAt(j);
                if(item=='B')
                {
                    row[0][tid] = i;
                    col[0][tid++]=j;
                    map[i][j]='0';
                }else if(item=='E')
                {
                    row[1][eid] = i;
                    col[1][eid++]=j;
                    map[i][j]='0';
                }else
                {
                    map[i][j] = item;
                }
            }
        }
        if(row[0][0]==row[0][1]) // row == row 는 누워있음 즉 b = 1
        {
            start = new Tree(row[0][1],col[0][1],1,0);
        }else // 다르면 서있음 b 1 = 0;
        {
            start = new Tree(row[0][1],col[0][1],0,0);
        }

        if(row[1][0]==row[1][1])
        {
            end = new Tree(row[1][1],col[1][1],1,0);
        }else
        {
            end = new Tree(row[1][1],col[1][1],0,0);
        }
        System.out.println(bfs());

    }
    public static boolean rotation(Tree g)
    {
        int row = g.row;
        int col = g.col;
        if(g.state==1)
        {
            int dir[][] ={{-1,-1},{-1,0},{-1,1},{1,1},{1,0},{1,-1}};
            for(int i=0;i<6;i++)
            {
                int nr = row + dir[i][0];
                int nc = col+dir[i][1];
                if(nr<0 || nr >=N || nc<0||nc>=N)
                    return false;
                else if(map[nr][nc]=='1')
                    return false;
            }
        }else
        {
            int dir[][] ={{-1,-1},{0,-1},{1,-1},{1,1},{0,1},{-1,1}};
            for(int i=0;i<6;i++)
            {
                int nr = row + dir[i][0];
                int nc = col+dir[i][1];
                if(nr<0 || nr >=N || nc<0 || nc>=N)
                    return false;
                else if(map[nr][nc]=='1')
                    return false;
            }
        }
        return true;
    }
    public static int bfs()
    {

        int result = 0;
        Queue<Tree> q = new LinkedList<>();
        boolean visit[][][] =new boolean[2][N][N];
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        visit[start.state][start.row][start.col] = true;
        q.offer(start);

        while (!q.isEmpty())
        {
            Tree t = q.poll();
           if(t.row==end.row && t.col == end.col && t.state==end.state)
                return t.mCount;
            for(int i=0;i<4;i++)
            {
                int nr = t.row+dir[i][0];
                int nc = t.col+dir[i][1];
                if(nr<0 || nr>=N || nc<0 || nc>=N)
                    continue;
                boolean canMove = true;
                if(t.state==1)
                {

                    for(int j=nc-1;j<=nc+1;j=j+1)
                    {
                        if(j<0 || j >=N)
                        {
                            canMove = false;
                            break;
                        }else if(map[nr][j]=='1')
                        {
                            canMove=false;
                            break;
                        }
                    }
                }else
                {
                    for(int j=nr-1;j<=nr+1;j=j+1)
                    {
                        if(j<0 || j >=N)
                        {
                            canMove = false;
                            break;
                        }else if(map[j][nc]=='1')
                        {
                            canMove=false;
                            break;
                        }
                    }
                }
                if(canMove)
                {

                    if(!visit[t.state][nr][nc])
                    {
                        visit[t.state][nr][nc]=true;
                        q.offer(new Tree(nr,nc,t.state,t.mCount+1));
                        }
                }
            }
            if(rotation(t))
            {
                int s = 0;
                if(t.state==0)
                    s=1;
                if(!visit[s][t.row][t.col])
                {
                    visit[s][t.row][t.col]=true;
                    q.offer(new Tree(t.row,t.col,s,t.mCount+1));
                }
            }

        }

        return 0;

    }
}
