import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-17.
 */
public class Snake2 {
    static class Element{
        int row;
        int col;
        Element (int r, int c)
        {
            row = r;
            col = c;
        }
    }
    static class Move{
        int time;
        char dir;
    }
    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        int arr[][] = new int[N+1][N+1];
        for(int i=0;i<A;i++)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            arr[r][c] = 2;
        }
        int L = sc.nextInt();

        sc.nextLine();
        Queue<Move> mq = new LinkedList<>();
        for(int i=0;i<L;i++)
        {
            String line = sc.nextLine();
            String [] sub = line.split(" ");
            Move m = new Move();
            m.dir = sub[1].charAt(0);
            m.time = Integer.parseInt(sub[0]);
            mq.offer(m);
        }
        int row = 1;
        int col = 1;
        arr[row][col] = 1;
        ArrayList<Element> body = new ArrayList<>();
        body.add(new Element(row,col));
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int didx = 0;
        int time = 1;
        while (true)
        {
            int nr = row +dir[didx][0];
            int nc = col + dir[didx][1];
            if(nr<1 || nr > N || nc<1 || nc>N)
                break;

            if(arr[nr][nc]==1)
                break;
            if(arr[nr][nc]!=2)
            {
                Element e = body.get(0);
                arr[e.row][e.col] = 0;
                body.remove(0);
            }
            arr[nr][nc] = 1;
            body.add(new Element(nr,nc));
            row = nr;
            col = nc;
            if(!mq.isEmpty() && time == mq.peek().time)
            {
                Move m = mq.poll();
                if(m.dir=='D') {
                    didx++;
                    if(didx==4)
                        didx=0;
                }
                else
                {
                    didx--;
                    if(didx==-1)
                        didx = 3;
                }
            }
            time++;
        }
        System.out.println(time);

    }
}
