import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-03.
 */
public class Startlink {

    static int F,S,G,U,D;
    static int count[];

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        count = new int[F+1+U];
        //s to g
        int ans = bfs(S);
        if(ans == -1 )
            System.out.println("use the stairs");
        else
            System.out.println(ans);
    }
    public static int bfs(int start)
    {
        if(start == G )
            return 0;
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        while (!que.isEmpty())
        {
            int ss = que.poll();
            int [] arr = new int[2];

            arr [0] = ss + U;
            arr [1] = ss - D;
            for(int i=0;i<2;i++)
            {
                if(arr[i]>=1 && arr[i] < (F+1+U))
                {

                    if(count[arr[i]] == 0 && arr[i] != S)
                    {
                        if ( arr[i] == G)
                            return count[ss] + 1;
                        count[arr[i]] = count [ss] +1;
                        que.offer(arr[i]);
                    }
                }
            }

        }
        return -1;
    }


}
