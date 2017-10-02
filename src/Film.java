import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-02.
 */
public class Film {

    static int D,W,K;
    static int film[][];
    static int ans;
    static int backs[][];
    public static void main(String [] args ){
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++)
        {
            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();
            ans = Integer.MAX_VALUE;
            film = new int[D][W];
            backs = new int[D][W];

            for(int r = 0 ; r<D;r++)
            {
                for(int c= 0 ;c<W;c++)
                {
                    film[r][c] = sc.nextInt();
                }
            }
            dfs(0,0);
            if(ans==Integer.MAX_VALUE)
                ans = -1;
            System.out.println("#"+tc+" " + ans);
        }
    }
    public static void change(int row,int w)
    {
        for(int i=0;i<W;i++)
        {
            backs[row][i] = film[row][i];
            film[row][i] = w;
        }
    }
    public static void back(int row)
    {
        for(int i=0;i<W;i++)
        {
            film[row][i] = backs[row][i];
        }
    }
    public static void dfs(int count , int location)
    {

        if(location >=D)
        {
            if(check())
            {
                ans = Math.min(ans,count);
            }
            return;
        }
        if(check())
        {
            ans = Math.min(ans,count);
            return;
        }
        //A로 바꾸는것
        change(location,0);
        dfs(count+1,location+1);
        back(location);
        //B로바꾸는것
        change(location,1);
        dfs(count+1,location+1);
        back(location);
        //넘어가는것
        dfs(count,location+1);

    }
    public static boolean check()
    {
        for(int i=0;i<W;i++)
            if(colCheck(i)==false)
                return false;

        return true;
    }
    public static boolean colCheck(int col)
    {
        int c= 1;
        for(int i=0;i<D-1;i++)
        {
            if(film[i][col] == film[i+1][col])
            {
                c++;
                if(c==K)
                    return true;
            }else
            {
                c=1;
            }
        }
        return false;
    }
}
