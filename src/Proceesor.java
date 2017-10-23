import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-21.
 */
public class Proceesor {

    static class CPU{
        int row;
        int col;
        int dir=-1;
    }
    static int arr[][];
    static int N,M;
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    static ArrayList<CPU> list;
    static int ans,alength;
    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++)
        {
            N = sc.nextInt();
            arr = new int[N][N];
            list = new ArrayList<>();
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    arr[i][j] = sc.nextInt();

                    if(arr[i][j] == 1)
                    {
                        if(i==0 || i==N-1 || j==0 || j==N-1)
                            continue;

                        CPU cpu = new CPU();
                        cpu.row = i;
                        cpu.col = j;
                        list.add(cpu);
                    }
                }
            }
            ans = 0;
            alength=Integer.MAX_VALUE;
            dfs(0,0,0);
            System.out.println("#"+tc+" "+alength);

        }
    }
    public static void dfs(int depth, int count,int length)
    {
        if(depth == list.size())
        {
            if(count > ans)
            {
                ans = count;
                alength = length;
            }else if(count==ans)
                alength = Math.min(alength,length);
        }else
        {
            for(int i=0;i<4;i++)
            {
                list.get(depth).dir = i;
                int result = running(depth);
                if(result!=-1) {
                    dfs(depth + 1,count+1,length+result);
                    rollback(list.get(depth).row,list.get(depth).col,i);
                }else
                {
                    dfs(depth+1,count,length);
                }
            }
        }
    }
    public static int running(int idx)
    {
        int result=0;
        CPU cpu = list.get(idx);
        int row = cpu.row;
        int col = cpu.col;
        int didx = cpu.dir;
        while (true)
        {
            int nr = row+dir[didx][0];
            int nc = col+dir[didx][1];
            if(arr[nr][nc]!=0)
            {
                nr = row;
                nc = col;
                while (true)
                {
                    if(nr==cpu.row && nc == cpu.col)
                      break;
                    arr[nr][nc] = 0;
                    nr = nr-dir[didx][0];
                    nc = nc-dir[didx][1];
                }
                return -1;
            }else
            {
                arr[nr][nc]=2;
                result++;
            }
            row = nr;
            col = nc;
            if(row == 0 || row == N-1 || col==0 || col==N-1)
                break;
        }
        return result;
    }
    public static void rollback(int row,int col,int didx)
    {
        while (true)
        {
            row = row+dir[didx][0];
            col = col+dir[didx][1];
            arr[row][col]=0;
            if(row==0 || row==N-1 || col==0 || col==N-1)
                break;
        }
    }
}
