import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-05.
 */
public class OrmakNarimak {
    static int N;
    static int arr[][];
    static int ans;
    static int dir[][] ={{0,1},{1,0},{0,-1},{-1,0}};
    static boolean visit[][];
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1;tc<=T;tc++)
        {
            ans = 0;
            sc.nextInt();
            N = 5;
            arr = new int[N][N];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                    arr[i][j] = sc.nextInt();
            }
            visit = new boolean[N][N];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    visit[i][j] = true;
                    dfs(i,j,1,0);
                    visit[i][j] = false;
                }
            }
            System.out.println("#"+tc+" " +ans);
        }

    }
    public static int comp(int a, int b)
    {
        if(a == b)
            return 0;
        else if( a > b)
            return -1;
        else
            return 1;
    }
    public static void dfs(int row , int col , int count , int state)
    {
        for(int i=0;i<4;i++)
        {
            int nr = row+dir[i][0];
            int nc =col+dir[i][1];
            if(nr>=0 && nr<N && nc>=0&&nc<N)
            {
                if(!visit[nr][nc])
                {
                    int r = comp(arr[row][col],arr[nr][nc]);
                    if(r!=0 && r!=state)
                    {
                        visit[nr][nc] = true;
                        dfs(nr,nc,count+1,r);
                        visit[nr][nc] = false;
                    }
                }
            }
        }

        ans = Math.max(count,ans);
    }
}
