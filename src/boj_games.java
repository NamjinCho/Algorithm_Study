import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-19.
 */
public class boj_games {
    static int K;
    static int min = Integer.MAX_VALUE;
    static boolean[] visit;
    static int[] mins;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cur = sc.nextInt();
        K = sc.nextInt();
        mins = new int[2*K];

        mins[cur] = 0;
        bfs(cur);
        System.out.println(mins[K]);
    }

    public static void bfs(int start )
    {
        Queue<Integer> que = new LinkedList<>();

        que.offer(start);
        visit = new boolean[K*2];
        visit[start] = true;
        while (!que.isEmpty())
        {

            int cur = que.poll();
            for(int i=0;i<3;i++)
            {
                int idx = 0;
                if(i==0)
                    idx=cur-1;
                else if(i==1)
                    idx=cur+1;
                else
                    idx=cur*2;

                if(idx<2*K && idx>0)
                {
                    if(!visit[idx])
                    {
                        mins[idx]=mins[cur]+1;
                        que.offer(idx);
                        visit[idx]=true;
                        if(idx==K)
                            break;
                    }
                }
            }
        }
    }
}