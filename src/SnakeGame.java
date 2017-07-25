import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by NamjinCho on 2017-07-20.
 */

public class SnakeGame {

    static int N;
    static int K;
    static int M;
    static int [][] board;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        board = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            board[row][col] = -1;
        }
        M = sc.nextInt();
        sc.nextLine();
        String moves[][] = new String[M][2];

        for(int i=0;i<M;i++)
        {
            String line = sc.nextLine();
            moves[i]=line.split(" ");
        }
        boolean stop = true;
        int time=1;
        int cRow = 1;
        int cCol = 1;
        int tRow = 1;
        int tCol = 1;
        int idx=0,moveIdx=0;
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};//RDLU
        board[cRow][cCol] = 1;
        while(stop){
            int nRow = cRow+dir[idx][0];
            int nCol = cCol+dir[idx][1];
            //System.out.println(nRow+"/"+nCol +" / " +idx);
            /*
            for(int i=1;i<=N;i++) {
                for (int j = 1; j <= N; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }*/
            if(nRow<1 || nRow > N || nCol <1 || nCol > N)
            {
                break;
            }
            if( (board[nRow][nCol]!=-1 && board[nRow][nCol]!=0))
                break;

            if(board[nRow][nCol]!=-1)
            {
                board[nRow][nCol] = time+1;
                int num = board[tRow][tCol];
                board[tRow][tCol] = 0;
                for(int i=0;i<3;i++)
                {
                    if(tRow+dir[i][0] < 1 || tRow+dir[i][0] >N || tCol+dir[i][1] < 1 || tCol+dir[i][1] >N)
                        continue;
                    if(board[tRow+dir[i][0]][tCol+dir[i][1]]==num+1)
                    {
                        tRow=dir[i][0]+tRow;
                        tCol = dir[i][1]+tCol;
                        break;
                    }
                }
            }else
                board[nRow][nCol] = time+1;
            cRow = nRow;
            cCol = nCol;
            if(moveIdx<M)
            {

               // System.out.println(time+"초 디버깅"+moveIdx +" / " + moves[moveIdx][0]);
                if( time==Integer.parseInt(moves[moveIdx][0])) {
                    if (moves[moveIdx][1].charAt(0) == 'D') {
                        idx++;
                    } else {
                        idx--;
                    }
                    if (idx == -1)
                        idx = 3;
                    idx = idx % 4;
                 //   System.out.println(time + "초 방향 전환" + idx + " / " + M + " " + moveIdx);
                    moveIdx++;
                }
            }
            time++;
        }


        System.out.println(time);
    }
}
