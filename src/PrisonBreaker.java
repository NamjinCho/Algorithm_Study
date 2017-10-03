import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-02.
 */
public class PrisonBreaker {

    //1 상하좌우 , 2 상하 3 좌우 4 상우 5하우 6 하좌 7 상좌
    static int dir[][][] = {//RDLU
            {{0,0},{0,0},{0,0},{0,0}}, // 0 default;
            {{0,1},{1,0},{0,-1},{-1,0}}, // 1 상하좌우
            {{0,0},{1,0},{0,0},{-1,0}},// 2 상하
            {{0,1},{0,0},{0,-1},{0,0}}, //3 좌우
            {{0,1},{0,0},{0,0},{-1,0}}, //4 상우
            {{0,1},{1,0},{0,0},{0,0}} , //5 하우
            {{0,0},{1,0},{0,-1},{0,0}} , //6 하좌
            {{0,0},{0,0},{0,-1},{-1,0}} , // 상좌
    };
    static class Node{
        int row;
        int col;
        int count;
        Node(int r,int c,int c2)
        {
            row = r;
            col = c;
            count = c2;
        }
    }
    static int N,M,K;
    static int map[][];
    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);
        int T  = sc.nextInt();
        for(int tc =1;tc<=T;tc++)
        {
            N = sc.nextInt();
            M = sc.nextInt();
            int R,C;
            R = sc.nextInt();
            C = sc.nextInt();
            K = sc.nextInt();
            map = new int[N][M];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<M;j++)
                {
                    map[i][j] = sc.nextInt();
                }
            }
            int ans = bfs(R,C);

            System.out.println("#"+tc+" "+ans);
        }
    }
    public static int bfs(int row , int col)
    {
        int total = 1;
        boolean visit[][] = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(row,col,1));
        visit[row][col] = true;

        while(!q.isEmpty())
        {
            Node n = q.poll();
            if(n.count==K)
                continue;

            int shape = map[n.row][n.col];

            for(int i=0;i<4;i++)
            {
                int nr = n.row+dir[shape][i][0];
                int nc = n.col+dir[shape][i][1];

                if(nr>=0 && nr<N && nc>=0 && nc<M)
                {
                    if(map[nr][nc]==0)
                        continue;

                    if(!visit[nr][nc])
                    {
                        if(map[nr][nc]==1||canGo(map[nr][nc],i))
                        {
                            visit[nr][nc] = true;
                            q.offer(new Node(nr,nc,n.count+1));
                            total++;
                        }
                    }
                }
            }
        }
        return total;
    }
    public static boolean canGo(int w,int di)
    {
        if(w==1)
            return true;

        //
        if(di == 1)//하
        {
            if((w==2 || w==4 || w==7 ))
                return true;
        }else if(di== 2)//좌
        {
            if(w==3 || w==4 || w==5)
                return true;
        }else if(di==3)//상
        {
            if(w==2 || w== 5 ||w==6)
                return true;
        }else//우
        {
            if(w==3 || w==6 || w==7)
                return true;
        }

        return false;
    }
}
