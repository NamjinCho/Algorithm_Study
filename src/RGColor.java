import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-04.
 */
public class RGColor {
    static int N;
    static int c1,c2;
    static char[][] map;
    static boolean visit[][];
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new char[N][N];
        for(int i=0;i<N;i++)
        {
            String line = sc.nextLine();
            for(int j=0;j<N;j++)
            {
                map[i][j]=line.charAt(j);
            }
        }
        visit = new boolean[N][N];
        c1=0;
        c2=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(!visit[i][j])
                {
                    c1+=bfs(i,j,false);
                }
            }
        }
        visit = new boolean[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(!visit[i][j])
                {
                    c2+=bfs(i,j,true);
                }
            }
        }
        System.out.println(c1 + " " + c2);
    }
    public static int bfs(int row,int col , boolean f)
    {
        class Node{
            int row,col;
            Node(int r,int c){
                row=r;
                col=c;
            }
        }
        Queue<Node> q=new LinkedList<>();
        visit[row][col] = true;
        q.offer(new Node(row,col));
        while(!q.isEmpty())
        {
            Node n = q.poll();
            char c = map[n.row][n.col];
            if(f &&c=='G')
            {
                c='R';
            }
            for(int i=0;i<4;i++)
            {
                int nr = n.row+dir[i][0];
                int nc = n.col+dir[i][1];

                if(nr>=0 && nr<N && nc>=0 && nc<N)
                {
                    char cc = map[nr][nc];
                    if(f && cc=='G')
                    {
                        cc='R';
                    }
                    if(!visit[nr][nc] && cc==c)
                    {
                        visit[nr][nc] = true;
                        q.offer(new Node(nr,nc));
                    }
                }
            }
        }

        return 1;
    }
}
