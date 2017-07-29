import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by NamjinCho on 2017-07-20.
 */

public class SnakeGame {

    static int N;
    static int K;
    static int [][] apples;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        apples = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            apples[row][col] = -1;
        }
        int moveSize = sc.nextInt();

        int mt [] = new int[moveSize];
        char md[] = new char[moveSize];

        sc.nextLine();

        for(int i=0;i<moveSize;i++)
        {
            String line = sc.nextLine();
            mt[i] = Integer.parseInt(line.split(" ")[0]);
            md[i] = line.split(" ")[1].toUpperCase().charAt(0);
        }

        int row = 1;
        int col = 1;

        apples[row][col]=1;
        int time =1;
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};//RDLU
        int idx = 0;
        int midx= 0;

        LinkedList<Integer> rb = new LinkedList<>();
        LinkedList<Integer> cb = new LinkedList<>();
        rb.addFirst(row);
        cb.addFirst(col);
        while (true)
        {
            int nr = row+dir[idx][0];
            int nc = col+dir[idx][1];
            if(nr <1 || nr >N || nc<1 || nc > N || apples[nr][nc]==1)
            {
                break;
            }
            if(apples[nr][nc]==0)
            {
                int tr = rb.removeLast();
                int tc = cb.removeLast();
                apples[tr][tc] = 0;
            }
            apples[nr][nc] = 1;
            rb.addFirst(nr);
            cb.addFirst(nc);
            row = nr;
            col = nc;
            if(midx <moveSize)
            {
                if(time==mt[midx])
                {
                    if(md[midx]=='L')
                    {
                        idx--;
                    }else
                    {
                        idx++;
                    }
                    if(idx==-1)
                        idx=3;
                    if(idx==4)
                        idx=0;
                    midx++;
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
