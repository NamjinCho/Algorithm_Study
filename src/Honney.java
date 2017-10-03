import java.util.*;
import java.lang.*;
/**
 * Created by NamjinCho on 2017-10-03.
 */
public class Honney {
    static int arr[][];
    static int N,M,C;

    static class Data{
        int sum;
        int []list = new int[M];
        int row[];
        int col[];
        int fRow;
        int fCol;
        Data()
        {
            row = new int[M];
            col = new int[M];
            for(int i=0;i<M;i++)
            {
                row[i] = -1;
                col[i] = -1;
            }
        }
    }
    static int sel,selsq,ans;
    static int fRow,fCol,tRow,tCol;
    static boolean f;
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=  1;tc<=T;tc++)
        {

            N  =sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();
            arr = new int[N][N];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            ans = 0;
            dfs(0,0);
            int total = ans;
            ans = 0;
            fRow = tRow;
            fCol = tCol;
            dfs(0,0);
            total +=ans;

            System.out.println("#"+tc+" "+total);

        }
    }
    public static void dfs(int row,int col)
    {

        if(col + M -1 >= N)
        {
            col=0;
            row++;
        }
        if(row<N)
        {
            if(fRow!=-1)
            {

                if(fRow !=row || (fCol+M < col || col+M < fCol))
                {
                    //TODO:
                    selsq = 0;
                    select(row,col,0,0,0);
                    if(selsq>ans)
                    {
                        ans = selsq;
                        tRow = row;
                        tCol = col;
                    }

                }

            }else
            {
                //TODO:
                selsq = 0;
                select(row,col,0,0,0);
                if(selsq>ans)
                {
                    ans = selsq;
                    tRow = row;
                    tCol = col;
                }
            }
            dfs(row,col+1);
        }
    }
    public static void select(int row , int col , int w, int sum, int sq)
    {
        if(w<M)
        {
            int t = arr[row][col+w];

            select(row,col,w+1,sum+t,sq +(t*t));
            select(row,col,w+1,sum,sq);
        }

        if(sum <=C)
        {
            if(selsq<sq)
            {
                selsq = sq;
            }
        }



    }
}
