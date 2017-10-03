import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-03.
 */
public class HomeSecurity {

    static int N,M;
    static int arr[][];
    static int ans;
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    static int areaPay[];
    static class Node{
        int row;
        int col;
        int k;
        Node(int r,int c,int k)
        {
            row = r;
            col = c;
            this.k = k;
        }
    }
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        areaPay = new int [101];

        for(int i=1;i<=100;i++)
            areaPay[i] = i * i + (i - 1) * (i - 1);

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                        bfs(i,j);
                }
            }
            System.out.println("#"+tc+" " + ans);
        }
    }

    public static void bfs(int row,int col)
    {
        boolean [][] visit = new boolean[N][N];
        visit[row][col] = true;

        int K = 1;
        int count = 0;
        if(arr[row][col] == 1)
            count=1;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(row,col,K));
        if((M * count) - areaPay[K] >= 0)
            ans = Math.max(ans,count);

        while (!q.isEmpty())
        {
            Node n = q.poll();
            if(n.k !=K) {
                K = n.k;
                if((M * count) - areaPay[K] >= 0)
                ans = Math.max(ans,count);
            }
            for(int i=0;i<4;i++)
            {
                int nr = n.row + dir[i][0];
                int nc = n.col + dir[i][1];

                if(nr>=0 && nr <N && nc>=0 && nc<N)
                {
                    if(!visit[nr][nc])
                    {
                        visit[nr][nc] = true;
                        q.offer(new Node(nr,nc,n.k+1));
                        if(arr[nr][nc]==1)
                            count++;
                    }
                }
            }
        }
    }
}
