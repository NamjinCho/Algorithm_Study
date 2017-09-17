import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-29.
 */
public class Jump {

    static int N;
    static int map[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        long ans[][] = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        ans [0][0] = 1;
        int dir[][] = {{0,1},{1,0}};
        for(int i=0;i<N;i++)
        {
            for (int j=0;j<N;j++)
            {
                if(ans[i][j]<1 || map[i][j]==0)
                    continue;

                for(int k=0;k<2;k++)
                {
                    int nr = i+ (map[i][j]*dir[k][0]);
                    int nc = j+ (map[i][j]*dir[k][1]);
                    if(nr<N && nc < N)
                    {
                        ans[nr][nc] += ans[i][j];
                    }
                }
            }
        }

        System.out.println(ans[N-1][N-1]);
    }

}
