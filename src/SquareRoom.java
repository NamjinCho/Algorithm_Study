import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-03.
 */
public class SquareRoom {

    static int N;
    static int rNo,max,sR;
    static int arr[][];
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++)
        {
            N = sc.nextInt();
            rNo = 1;
            max = 1;
            arr = new int[N][N];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    sR = arr[i][j];
                    dfs(i,j,1);
                }
            }
            System.out.println("#"+tc + " " +rNo + " " +max);
        }
    }
    public static void dfs(int row,int col,int count)
    {
        for(int i=0;i<4;i++)
        {
            int nr = row +dir[i][0];
            int nc = col+dir[i][1];

            if(nr >=0 &&nr <N && nc>=0 && nc<N )
            {
                if(arr[nr][nc]==arr[row][col]+1)
                {
                    dfs(nr,nc,count+1);
                }
            }
        }

        if(count > max)
        {
            max = count;
            rNo = sR;
        }else if(count == max)
        {
            rNo = Math.min(sR,rNo);
        }
    }
}
