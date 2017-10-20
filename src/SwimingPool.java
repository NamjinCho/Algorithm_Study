import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-25.
 */
public class SwimingPool {

    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String sub[] = line.split(" ");
        int N = Integer.parseInt(sub[0]);
        int M = Integer.parseInt(sub[1]);
        int map1[][] = new int[N][M];
        int map2[][] = new int[N][M];
        int tmp=0;
        for(int i=0;i<N;i++)
        {
            line = sc.nextLine();
            for(int j=0;j<M;j++)
            {
                map1[i][j] = line.charAt(j) - '0';
                tmp = Math.max(tmp,map1[i][j]);
            }
        }
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                map2[i][j] = tmp;
            }
        }
        boolean f= true;
        while (f)
        {
            f=false;
            for(int r=0;r<N;r++)
            {
                for(int c = 0;c<M;c++)
                {
                    if(map2[r][c]==0)
                        continue;
                    if(map1[r][c]==0)
                    {
                        map2[r][c]--;
                        f= true;
                        continue;
                    }
                    for(int i=0;i<4;i++)
                    {
                        int nr = r+dir[i][0];
                        int nc = c+dir[i][1];
                        if(nr<0 || nr >=N || nc<0|| nc>=M)
                        {
                            map2[r][c]--;
                            f=true;
                            break;
                        }else
                        {
                            if(map2[r][c]+map1[r][c] > map1[nr][nc]+map2[nr][nc])
                            {
                                map2[r][c]--;
                                f=true;
                                break;
                            }
                        }
                    }
                }
            }

        }
        int ans = 0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++) {
                ans += map2[i][j];
             }
        }
        System.out.println(ans);
    }
}
