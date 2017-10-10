import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-06.
 */
public class SnowSister {

    static int arr[][];
    static int N;
    static int ans;
    static int dir[][] = {{0,1},{0,-1},{1,0}};
    static boolean visit[][][];
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++)
        {
            N = sc.nextInt();

            arr = new int[N][N];
            sc.nextLine();
            for(int i=0;i<N;i++)
            {
                String line =sc.nextLine();
                for(int j=0;j<N;j++)
                {
                    arr[i][j] = line.charAt(j)-'0';
                }
            }
            visit = new boolean[2][N][N];
            ans=0;
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(arr[i][j]!=1)
                    {
                        dfs(i,j,0,0);
                        dfs(i,j,1,0);
                    }
                }
            }
            System.out.println("#"+tc+" "+ans);
        }
    }
    public static boolean check(int row,int col){

        if(col <0 || col>=N)
            return false;
        else if(arr[row][col]==1)
            return false;
        return true;
    }
    public static void dfs(int row,int col,int di,int point)
    {
        if(arr[row][col]==2)
        {
            arr[row][col] = 0;
            dfs(row,col,di,point+1);
            arr[row][col] = 2;
            return;
        }
        int nr = row+1;
        int nc = col;
        if(nr!=N && arr[nr][nc]!=1)
        {
            dfs(nr,nc,di,point);
            return;
        }

        nr = row;
        nc = col+dir[di][1];
        if(!check(nr,nc))
        {
            di=di^1;
            nc = col+dir[di][1];
        }

        if(check(nr,nc)&&!visit[di][nr][nc] )
        {
            visit[di][nr][nc] = true;
            dfs(nr,nc,di,point);
            visit[di][nr][nc] = false;
        }else
        {
            ans = Math.max(point,ans);
            return;
        }






    }
}
