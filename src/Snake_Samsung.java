import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-23.
 */
class Move{
    int time;
    char dir;
}
public class Snake_Samsung {

    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int L = Integer.parseInt(sc.nextLine());
        int M = Integer.parseInt(sc.nextLine());
        int row = 0;
        int col = 0;
        HashMap<String,Boolean> body = new HashMap<>();
        Queue<Move> que = new LinkedList<>();
        for(int i=0;i<M;i++)
        {
            String l = sc.nextLine();
            Move m = new Move();
            m.time = Integer.parseInt(l.split(" ")[0]);
            m.dir =  l.split(" ")[1].charAt(0);
            que.offer(m);
        }
        body.put(row+"/"+col,true);
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};//RDLU
        int i = 0;
        Move m = que.poll();
        int time = 1;
        int ans = 1;
        while(true)
        {
            if(m.time==time-1)
            {
                if(m.dir=='R')
                {
                    i++;
                }else
                    i--;
                if(i==-1)
                    i=3;
                else
                    i=i%4;
                if(!que.isEmpty())
                {
                    m = que.poll();
                    time = 1;
                }
            }

            row +=dir[i][0];
            col +=dir[i][1];

            if(row>=-L && row <=L && col >= -L && col <= L)
            {
                if(body.containsKey(row+"/"+col))
                    break;
                else
                    body.put(row+"/"+col,true);
            }else
            {
                break;
            }

            time++;
            ans++;

        }
        System.out.println(ans);

    }



}
