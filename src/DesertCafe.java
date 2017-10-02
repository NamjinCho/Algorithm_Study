import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-29.
 */
public class DesertCafe {
    static int N;
    static int arr[][];
    static int ans;
    static boolean [] list;
    static int sR,sC;
    static int dir[][] ={{1,1},{1,-1},{-1,1},{-1,-1}};
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1;tc<=T;tc++)
        {
            ans = -1;

            N = sc.nextInt();
            arr = new int[N][N];

            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                    arr[i][j] = sc.nextInt();
            }
            list = new boolean[101];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if((i==0 && j==0) || (i==0 && j==N-1) || (j==0 && i == N-1) ||(i==N-1 && j==N-1) )
                    {
                        continue;
                    }
                    sR = i;
                    sC = j;
                    dfs(i,j,0,0,-1);
                }
            }
            System.out.println("#"+tc+" "+ans);
        }
    }
    public static void dfs(int row, int col, int count,int lc,int pDir)
    {
        if(lc > 4)
            return;

        if(sR==row && sC == col)
        {
            if(lc==4)
                ans = Math.max(ans,count);
            if(pDir!=-1)
                return;
        }
        for(int i=0;i<4;i++)
        {

            int nr = row+dir[i][0];
            int nc = col + dir[i][1];

            if(nr <0 || nr >=N || nc<0 || nc>=N)
                continue;

            if(!list[arr[nr][nc]]) {
                list[arr[nr][nc]] = true;
                int nlc = lc;
                if (i != pDir)
                    nlc++;
                dfs(nr, nc, count + 1, nlc, i);
                list[arr[nr][nc]] = false;
            }
        }

    }




}
