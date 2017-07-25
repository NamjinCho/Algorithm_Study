import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-25.
 */
public class Diamond {

    static int N;
    static int M;
    static int board[][];
    static int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                board[i][j] = sc.nextInt();
            }
        }
        int ans=1;
        for(int i=1;i<N-1;i++)
        {
            for(int j=1;j<M-1;j++)
            {
                int w=1;
                while(true)
                {
                    int result = getDiamond(i,j,w);
                    if(result==-2)
                        break;
                    ans=Math.max(result,ans);
                    w++;
                }
            }
        }
        System.out.println(ans);
    }
    public static int getDiamond(int row , int col, int w)
    {
        int size = 4*w;
        ArrayList<Integer> list = new ArrayList<>();
        int edge[][] = new int[4][2];
        //ULDR
        for(int i=0;i<4;i++)
        {
            int nr = row + (w*dir[i][0]);
            int nc = col + (w*dir[i][1]);
            if(nr<0 || nr >=N || nc < 0 || nc >=M)
                return -2;
            edge[i][0] = nr;
            edge[i][1] = nc;
            if(!list.contains(board[nr][nc]))
            {
                list.add(board[nr][nc]);
            }else
                return -1;

        }
        int idx= 4;
        int start = 0;
        //왼쪽 대각선 -1,-1
        //오른쪽 대각선 -1,1
        // 1,3
        start = 3;
        int coord[][] = new int [4][2];
        for(int i=0;i<4;i++)
        {
            if(i<2)
            {
                coord[i][1]=edge[0][1];
                coord[i][0]=edge[0][0];
            }else
            {
                coord[i][1]=edge[2][1];
                coord[i][0]=edge[2][0];
            }
        }
        int dir2[][] = {{1,-1},{1,1},{-1,-1},{-1,1}};
        while(true)
        {

            if(idx==size) {
                break;
            }
            for(int i=0;i<4;i++) {
                coord[i][0] += dir2[i][0];
                coord[i][1] += dir2[i][1];
            }
            for(int i=0;i<4;i++)
            {
                if(list.contains(board[coord[i][0]][coord[i][1]]))
                    return -1;
                list.add( board[coord[i][0]][coord[i][1]]);
                idx++;
            }

        }
        //왼쪽 위 1,-1
        //오른쪽 위 1,1

        return size;
    }
}
