import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-01.
 */
public class KebinsLaw {
    static int N;
    static int map[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        map = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
            map[b][a] = 1;
        }
        int min,midx=0;
        min = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++)
        {
            int r = bfs(i);
            if(r<min)
            {
                min = r;
                midx= i;
            }
        }
        System.out.println(midx);
    }

    public static int bfs(int start) {
        int total = 0;
        boolean visit[] =new boolean[N+1];

        Queue<Integer> que= new LinkedList<>();
        Queue<Integer> cost = new LinkedList<>();
        cost.offer(0);
        que.offer(start);
        visit[start] = true;
        while(!que.isEmpty())
        {
            int s= que.poll();
            int c= cost.poll();
            for(int i=1;i<=N;i++)
            {
                if(!visit[i] && map[s][i] == 1)
                {
                    visit[i]=true;
                    que.offer(i);
                    cost.offer(c+1);
                    total = total + (c+1);
                }
            }
        }


        return total;
    }

}
