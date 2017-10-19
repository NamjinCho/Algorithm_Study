import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static javafx.scene.input.KeyCode.O;

/**
 * Created by NamjinCho on 2017-07-20.
 */

public class RobotCleaner {

    static int N;
    static int M;
    static int board[][];
    static int Ans;
    static int dirs[][] =  {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                Integer.bitCount(1));
        System.out.println(
                Integer.bitCount(2));
        System.out.println(
                Integer.bitCount(3));
        System.out.println(
                Integer.bitCount(4));
        N = sc.nextInt();
        M = sc.nextInt();

        board = new int[N][M];
        int cr = sc.nextInt();
        int cc = sc.nextInt();
        int cd = sc.nextInt();
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                board[i][j] = sc.nextInt();
            }
        }
        Ans = 0;
        dfs(cr,cc,0,cd);
        System.out.println(Ans);
    }
    public static void dfs(int row,int col,int cC,int dir)
    {
        if(board[row][col]==0) {
            board[row][col]=2;
            Ans++;
        }
        if(cC==4)
        {
            int nRow = row-dirs[dir][0];
            int nCol = col-dirs[dir][1];
            if(board[nRow][nCol]!=1)
                dfs(nRow,nCol,0,dir);
            return;

        }
        dir--;
        if(dir==-1)
            dir = 3;

        int nRow = row+dirs[dir][0];
        int nCol = col+dirs[dir][1];
        if(board[nRow][nCol]==0)
        {
            dfs(nRow,nCol,0,dir);
        }else
        {
            dfs(row,col,cC+1,dir);
        }

    }
}
