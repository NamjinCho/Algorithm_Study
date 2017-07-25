import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-23.
 */
class pair{
    int row;
    int col;
}
public class Virus {

    public static int board[][];
    public static int N;
    public static int M;
    public static ArrayList<pair> virus;
    public static int Count = 0;
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        virus = new ArrayList<>();
        Count = 0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                board[i][j]=sc.nextInt();
                if(board[i][j]==2)
                {
                    pair p = new pair();
                    p.row = i;
                    p.col = j;
                    virus.add(p);
                }
            }
        }
        insert(0,0,0);
        System.out.println(Count);
    }
    public static void insert(int count,int row,int col)
    {
        if(count == 3)
        {
            bfs();
            return;
        }

        if(board[row][col]==1 || board[row][col]==2)
        {
            col++;
            if(col==M)
            {
                col=0;
                row++;
            }
            if(row==N)
                return;
            insert(count,row,col);
        }else{
            board[row][col]=1;
            insert(count+1,row,col);
            board[row][col]=0;
            col++;
            if(col==M)
            {
                col=0;
                row++;
            }
            if(row==N)
                return;
            insert(count,row,col);
        }
    }
    public static void bfs()
    {
        boolean visit[][] = new boolean[N][M];
        int c= N*M;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(board[i][j]==1 || board[i][j]==2 ){
                    visit[i][j]=true;
                    c--;
                }
            }
        }
        int size = virus.size();
        for(int i=0;i<size;i++)
        {
            Queue<pair> que = new LinkedList<>();
            pair p = virus.get(i);
            que.offer(p);
            int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};//RDLU
            while(!que.isEmpty())
            {
                pair t = que.poll();

                for(int j=0;j<4;j++)
                {
                    int row = t.row+dir[j][0];
                    int col = t.col+dir[j][1];
                    if(row>=0 && row < N && col>=0 && col<M)
                    {
                        if(!visit[row][col])
                        {
                            visit[row][col]=true;
                            pair tt = new pair();
                            tt.row = row;
                            tt.col = col;
                            que.offer(tt);
                            c--;
                        }
                    }
                }
            }
        }
        Count = Math.max(c,Count);

    }

}
