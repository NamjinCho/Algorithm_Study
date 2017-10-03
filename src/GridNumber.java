
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-03.
 */
public class GridNumber {

    static int N=4;
    static int ans;
    static HashMap<String ,Boolean> visit;
    static int arr[][];
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++)
        {

            ans = 0;
            arr = new int[N][N];

            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                    arr[i][j] = sc.nextInt();
            }

            visit = new HashMap<>();
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                    dfs(i,j,1,""+arr[i][j]);
            }

            System.out.println("#"+tc + " " + ans);
        }
    }
    public static void dfs(int row , int col,int count,String num)
    {
        if(count == 7)
        {
            if(!visit.containsKey(num))
            {
                ans++;
                visit.put(num,true);
            }
            return;
        }
        for(int i=0;i<4;i++)
        {
            int nr = row+dir[i][0];
            int nc = col+dir[i][1];

            if(nr>=0 && nr<N && nc>=0 && nc<N)
            {
                dfs(nr,nc,count+1,num+arr[nr][nc]);
            }
        }

    }


}
