import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-27.
 */
public class Virus2 {

    static int N;
    static int map[][];
    static int s;
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int m = sc.nextInt();
        map = new int[N+1][N+1];
        for(int i=0;i<m;i++)
        {
            int r = sc.nextInt();
            int c= sc.nextInt();
            map[r][c] = 1;
            map[c][r] = 1;
        }
        s=0;
        bfs();
        System.out.println(s);
    }
    static void bfs()
    {
        boolean visit[] = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visit[1] = true;

        while (!q.isEmpty())
        {
            int t = q.poll();
            for(int i=1;i<=N;i++)
            {
                if(map[t][i] == 1 && !visit[i])
                {
                    s++;
                    visit[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
