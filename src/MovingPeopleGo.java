import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-08.
 */
public class MovingPeopleGo {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[][] = new int[N][M];
        int dir[][] = {{-1,0},{0,-1},{-1,-1}};
        for(int r=0;r<N;r++)
        {
            for(int c = 0; c<M;c++)
            {
                int tmp = sc.nextInt();
                int max = 0;
                for(int i=0;i<3;i++)
                {
                    int nr = r+dir[i][0];
                    int nc = c+dir[i][1];
                    if(nr >=0 && nc>=0)
                    {
                        max = Math.max(max,arr[nr][nc]);
                    }
                }
                arr[r][c]=max+tmp;
            }
        }
        System.out.println(arr[N-1][M-1]);

    }
}
