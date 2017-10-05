import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-03.
 */
public class FindPath2 {
    static ArrayList<Integer>[] edge;
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt())
        {
            int T = sc.nextInt();
            int M = sc.nextInt();
            edge = new ArrayList[100];
            for(int i=0;i<100;i++)
                edge[i] = new ArrayList<>();
            for(int i=0;i<M;i++)
            {
                int s = sc.nextInt();
                int e = sc.nextInt();

                edge[s].add(e);
            }
            System.out.println("#"+T+" " + bfs());

        }

    }
    public static int bfs()
    {
        boolean visit[] = new boolean[100];
        visit[0] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while (!q.isEmpty())
        {
            int t = q.poll();

            for(int i=0;i<edge[t].size();i++)
            {
                if(!visit[edge[t].get(i)])
                {
                    if(edge[t].get(i)==99)
                        return 1;

                    visit[edge[t].get(i)] = true;
                    q.offer(edge[t].get(i));
                }
            }
        }


        return 0;
    }



}
