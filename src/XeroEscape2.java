import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-16.
 */
public class XeroEscape2 {

    static int N,M;
    static char[][] map;
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    static int gR,gC;
    static int ans;
    static class Data{
        int row;
        int col;
        boolean f;
    }
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        map = new char[N][M];
        int rr=0,rc=0,br=0,bc=0;
        for(int i=0;i<N;i++)
        {
            String line = sc.nextLine();
            for(int j=0;j<M;j++)
            {
                map[i][j] = line.charAt(j);
                if(map[i][j]=='O')
                {
                    gR = i;
                    gC = j;
                }else if(map[i][j]=='B')
                {
                    br =i;
                    bc = j;
                    map[i][j]='.';
                }else if(map[i][j]=='R')
                {
                    rr=i;
                    rc=j;
                    map[i][j]='.';
                }

            }
        }
        ans = Integer.MAX_VALUE;
        dfs(1,rr,rc,br,bc);
        if(ans==Integer.MAX_VALUE)
            ans =-1;
        System.out.println(ans);

    }
    static boolean getPriority(int rr,int rc,int br,int bc,int didx)
    {

        if(didx == 0)
        {
            if(rc<bc)
                return false;
            else
                return true;
        }else if(didx==1)
        {
            if(rr < br)
                return false;
            else
                return true;
        }else if(didx==2)
        {
            if(bc<rc)
                return false;
            else
                return true;
        }else
        {
            if(br<rr)
                return false;
            else
                return true;
        }
    }
    static void dfs(int count,int rr,int rc,int br,int bc)
    {
        if(count >= ans)
            return;
        if(count >10)
            return;
        //RDLU

        //Rigth

        for(int i=0;i<4;i++)
        {
            if(getPriority(rr,rc,br,bc,i))
            {
                Data tmp = new Data();
                tmp.row = -1;
                tmp.col = -1;
                Data red = move(rr,rc,i,tmp);
                Data blue = move(br,bc,i,red);
                if(blue.f)
                {
                    continue;
                }
                if(red.f)
                {
                    ans = Math.min(ans,count);
                    return;
                }
                dfs(count+1,red.row,red.col,blue.row,blue.col);
            }else
            {
                Data tmp = new Data();
                tmp.row = -1;
                tmp.col = -1;
                Data blue = move(br,bc,i,tmp);
                if(blue.f)
                    continue;
                Data red = move(rr,rc,i,blue);
                if(red.f)
                {
                    ans = Math.min(ans,count);
                    return;
                }
                dfs(count+1,red.row,red.col,blue.row,blue.col);
            }

        }

    }
    static Data move(int row,int col,int didx,Data first)
    {
        Data result = new Data();
        result.row = row;
        result.col = col;

        int nr = row ;
        int nc = col;
        while(true)
        {
            nr = nr+dir[didx][0];
            nc = nc+dir[didx][1];
            if(nr<0 || nr>=N || nc<0 || nc>=M)
                break;

            if(map[nr][nc]=='O')
            {
                result.f  =true;
                result.row = nr;
                result.col = nc;
                return result;
            }else if(map[nr][nc]!='.' || (nr==first.row && nc==first.col))
            {
                return result;
            }
            result.row = nr;
            result.col = nc;
        }
        return result;
    }
}
