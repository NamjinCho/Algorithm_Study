import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-16.
 */
public class FindPath {

    static int N,fStart;
    static int map[][];
    static boolean visit[];
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visit = new boolean[N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                map[i][j] = sc.nextInt();
            }
        }
        for(int k=0;k<N;k++)
        {
            fStart = k;
            visit = new boolean[N];
            dfs(k);
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void dfs(int start)
    {
        for(int i=0;i<N;i++)
        {
            if(i==start)
                continue;
            if(!visit[i] && map[start][i]==1)
            {
                map[fStart][i] = 1;
                visit[i]=true;
                dfs(i);
            }
        }
    }
}
