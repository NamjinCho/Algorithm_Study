import javax.lang.model.util.Elements;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-01.
 */
class Tree {
    int rows[];
    int cols[];
    int state;
    int cost;
    Tree(int r[], int c[],int cost) {
        rows = new int[3];
        cols = new int[3];
        this.cost=cost;
        for(int i=0;i<3;i++)
        {
            rows[i]=r[i];
            cols[i]=c[i];
        }
        if(rows[0] == rows[1])
            state = 0;
        else
            state =1;
    }
    public boolean equals(Tree e)
    {

        if(state != e.state )
            return false;

        if(rows[1]!=e.rows[1] || e.cols[1] != cols[1])
            return false;

        return true;
    }
}

public class TreeMove {
    static int N;
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        map = new char[N][N];
        int src[][] = new int[3][2];
        int erc[][] = new int[3][2];
        int sidx = 0, eidx = 0;
        for (int r = 0; r < N; r++) {
            String line = sc.nextLine();
            for (int c = 0; c < N; c++) {
                map[r][c] = line.charAt(c);
                if (map[r][c] == 'B') {
                    src[sidx][0] = r;
                    src[sidx][1] = c;
                    sidx++;
                } else if (map[r][c] == 'E') {
                    erc[eidx][0] = r;
                    erc[eidx][1] = c;
                    eidx++;
                }
            }
        }
        Tree start, end;
        int rows[][] = new int[2][3];
        int cols[][] = new int[2][3];
        for (int i = 0; i < 3; i++) {
            rows[0][i] = src[i][0];
            cols[0][i] = src[i][1];
        }
        for (int i = 0; i < 3; i++) {
            rows[1][i] = erc[i][0];
            cols[1][i] = erc[i][1];
        }
        start = new Tree(rows[0],cols[0],0);
        end  = new Tree(rows[1],cols[1],0);
        int ans = bfs(start,end);
        System.out.println(ans);
    }
    public static int bfs(Tree start,Tree end)
    {
        boolean visit[][][] = new boolean[2][N][N];
        visit[start.state][start.rows[1]][start.cols[1]]=true;
        Queue<Tree> que = new LinkedList<>();
        que.offer(start);
        //
        while(!que.isEmpty())
        {
            Tree node = que.poll();
            Tree [] changes = new Tree[5];
            changes[0]=Up(node);
            changes[1]=Down(node);
            changes[2]=Left(node);
            changes[3]=Right(node);
            changes[4]=Rotation(node);
            for(int i=0;i<5;i++)
            {
                if(changes[i]!= null && !visit[changes[i].state][changes[i].rows[1]][changes[i].cols[1]])
                {
                    if(end.equals(changes[i])) {

                        return changes[i].cost;
                    }
                    visit[changes[i].state][changes[i].rows[1]][changes[i].cols[1]] = true;
                    que.offer(changes[i]);
                }
            }
        }
        return 0;
    }
    public static Tree Up(Tree t)
    {
        int rows[]=new int[3];
        for(int i=0;i<3;i++)
        {
            if(t.rows[i]-1 < 0 || map[t.rows[i]-1][t.cols[i]]=='1')
                return null;
            rows[i]=t.rows[i]-1;
        }
        return new Tree(rows,t.cols,t.cost+1);
    }
    public static Tree Down(Tree t)
    {
        int rows[]=new int[3];
        for(int i=0;i<3;i++)
        {
            if(t.rows[i]+1 >= N || map[t.rows[i]+1][t.cols[i]]=='1')
                return null;
            rows[i]=t.rows[i]+1;
        }
        return new Tree(rows,t.cols,t.cost+1);
    }
    public static Tree Left(Tree t)
    {
        int cols[]=new int[3];
        for(int i=0;i<3;i++)
        {
            if(t.cols[i]-1 < 0 || map[t.rows[i]][t.cols[i]-1]=='1')
                return null;
            cols[i]=t.cols[i]-1;
        }
        return new Tree(t.rows,cols,t.cost+1);
    }
    public static Tree Right(Tree t)
    {
        int cols[]=new int[3];
        for(int i=0;i<3;i++)
        {
            if(t.cols[i]+1 >=N || map[t.rows[i]][t.cols[i]+1]=='1')
                return null;
            cols[i]=t.cols[i]+1;
        }
        return new Tree(t.rows,cols,t.cost+1);
    }
    public static Tree Rotation(Tree t)
    {
        int state = t.state;
        if(state==1)
        {
            int cols[] = new int[3];
            int rows[] = new int[3];
            int dir[] = {-1,0,1};
            for(int i=0;i<3;i++)
            {
                if(t.cols[i]-1 < 0 || t.cols[i]+1 >=N || map[t.rows[i]][t.cols[i]-1] == '1' || map[t.rows[i]][t.cols[i]+1]=='1')
                    return null;
                rows[i]=t.rows[1];
                cols[i]=t.cols[i]+dir[i];
            }
            return new Tree(rows,cols,t.cost+1);
        }else
        {
            int cols[] = new int[3];
            int rows[] = new int[3];
            int dir[] = {-1,0,1};

            for(int i=0;i<3;i++)
            {
                if(t.rows[i]-1 < 0 || t.rows[i]+1 >=N || map[t.rows[i]-1][t.cols[i]] == '1' || map[t.rows[i]+1][t.cols[i]]=='1')
                    return null;
                cols[i]=t.cols[1];
                rows[i]=t.rows[i]+dir[i];
            }
            return new Tree(rows,cols,t.cost+1);
        }
    }
}
