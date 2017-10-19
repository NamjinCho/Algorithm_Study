import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-17.
 */
public class RobotCleaner2 {

    public static void main(String []args)
    {

        Scanner sc= new Scanner(System.in);
        //북동남서 , URDL

        int N = sc.nextInt();
        int M = sc.nextInt();
        int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};

        int row = sc.nextInt();
        int col = sc.nextInt();
        int didx = sc.nextInt();

        int arr[][] = new int[N][M];

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        while (true)
        {
            if(arr[row][col]==0)
            {
                ans++;
                arr[row][col]=2;
            }
            int ndidx = didx;

            int nr=row;
            int nc = col;
            for(int i=0;i<4;i++)
            {
                ndidx--;
                if(ndidx<0)
                {
                    ndidx = 3;
                }
                nr = row+dir[ndidx][0];
                nc = col+dir[ndidx][1];
                if(nr>=0 && nr<N && nc>=0 && nc<M)
                {
                    if(arr[nr][nc]==0)
                    {
                        break;
                    }
                }
            }
            if(ndidx==didx)
            {
                if(arr[nr][nc]==0)
                {
                    row = nr;
                    col = nc;
                }else {
                    nr = row - dir[didx][0];
                    nc = col - dir[didx][1];
                    if (arr[nr][nc] == 1)
                        break;
                    else
                    {
                        row = nr;
                        col = nc;
                    }
                }
            }else
            {
                row = row+dir[ndidx][0];
                col = col+dir[ndidx][1];
            }
            didx = ndidx;
        }
        System.out.println(ans);

    }
}
