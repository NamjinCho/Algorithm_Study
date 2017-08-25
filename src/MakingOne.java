import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-25.
 */
public class MakingOne {

    static int min;
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        min = Integer.MAX_VALUE;
        bfs(N);
        System.out.println(min);
    }
    public static void bfs(int N)
    {
        int visit[] = new int [N+1];

        Queue<Integer> nq = new LinkedList<>();
        visit[N]= 0;
        nq.offer(N);
        while(!nq.isEmpty())
        {
            int cur = nq.poll();
            if(cur==1)
            {
                min = visit[cur] ;
                return;
            }
            if(cur%3==0)
            {
                int t = cur/3;
                if(visit[t]==0 ||visit[t] > visit[cur]+1 )
                {
                    visit[t] = visit[cur]+1;
                    nq.offer(t);
                }
            }
            if(cur%2==0)
            {

                int t = cur/2;
                if(visit[t]==0 ||visit[t] > visit[cur]+1 )
                {
                    visit[t] = visit[cur]+1;
                    nq.offer(t);
                }
            }
            if(cur-1 > 0)
            {

                int t = cur-1;
                if(visit[t]==0 ||visit[t] > visit[cur]+1 )
                {
                    visit[t] = visit[cur]+1;
                    nq.offer(t);
                }
            }
        }
    }
}
