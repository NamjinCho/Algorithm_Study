import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-23.
 */
public class Game2048 {


    public static int N;
    public static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};//RDLU
    public static int ans = 0;
    public static class data {
        int board[][];
        boolean plus[][];
    }
    public static void main(String [] args)
    {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int board [][] = new int [N][N];

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                board[i][j] = sc.nextInt();
            }
        }
        ans = 0;
        dfs(0,board);
        System.out.println(ans);
    }
    public static int findMax(int board[][])
    {
        int max = 0;

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
               // System.out.print(board[i][j]+" ");
                max = Math.max(board[i][j],max);
            }
            //System.out.println(" "+ i);
        }
        return max;
    }
    //left 면 왼쪽부터 rigth 면 오른쪽부터
    //up 위에부터 down 아래부터 움직
    public static void dfs(int count,int board[][])
    {
        if(count==5) {
            int m = findMax(board);
            ans=Math.max(ans,m);
            return;
        }
        for(int i=0;i<4;i++)
        {
            boolean [][] plus = new boolean[N][N];
            int[][] nBoard = copy(board);
            data d = new data();
            d.board = nBoard;
            d.plus = plus;
            if(i==0)//RDLU
            {
                for(int row = 0 ; row <N;row++)
                {
                    for(int col=N-1;col>=0;col--)
                    {
                        d = push(row,col,d,i);
                    }
                }
            }else if(i==1){
                for(int col=0;col<N;col++)
                {
                    for(int row = N-1;row>=0;row--)
                    {
                        d = push(row,col,d,i);
                    }
                }
            }
            else if(i==2)//RDLU
            {
                for(int row = 0 ; row <N;row++)
                {
                    for(int col=0;col<N;col++)
                    {
                        d = push(row,col,d,i);
                    }
                }
            }else
            {
                for(int col=0;col<N;col++)
                {
                    for(int row = 0;row<N;row++)
                    {
                        d = push(row,col,d,i);
                    }
                }
            }

            nBoard = copy(d.board);

            dfs(count+1,nBoard);
        }
    }
    public static int[][] copy(int [][]arr)
    {
        int nB [][] = new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
                nB[i][j] = arr[i][j];
        }
        return nB;
    }
    public static boolean[][] copy(boolean [][]arr)
    {
        boolean nB [][] = new boolean[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
                nB[i][j] = arr[i][j];
        }
        return nB;
    }
    public static data push(int row , int col , data d,int i)
    {

        int nRow = row;
        int nCol = col;
        boolean stop = true;
        int nBoard[][] = copy(d.board);
        boolean plus[][] = copy(d.plus);
        while (stop) {
            stop = false;
            nRow += dir[i][0];
            nCol += dir[i][1];
            if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < N) {
                // 0 일때 밀기
                if(nBoard[nRow][nCol]==0)
                {
                    nBoard[nRow][nCol] = nBoard[nRow-dir[i][0]][nCol-dir[i][1]];
                    nBoard[nRow-dir[i][0]][nCol-dir[i][1]] = 0;
                    stop = true;
                    continue;
                }
                //같으면 합치기
                if (!plus[nRow][nCol] && nBoard[nRow][nCol] == nBoard[nRow-dir[i][0]][nCol-dir[i][1]]) {
                    nBoard[nRow][nCol] *= 2;
                    nBoard[nRow-dir[i][0]][nCol-dir[i][1]] = 0;
                    plus[nRow][nCol] = true;
                    break;
                }
            }
        }
        data dd = new data();
        dd.board=nBoard;
        dd.plus =plus;
        return dd;
    }
}
