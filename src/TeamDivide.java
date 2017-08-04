import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-04.
 */
public class TeamDivide {
    static int N,map[][],c1,c2;
    static boolean t1[],t2[];
    public static void main(String [] args)
    {
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N+1][N+1];
        t1 = new boolean[N+1];
        t2 = new boolean[N+1];
        for(int i=1;i<=N;i++)
        {
            int k = sc.nextInt();
            for(int j=0;j<k;j++)
            {
                int hate = sc.nextInt();
                map[i][hate] = 1;
                map[hate][i] = 1;
            }
        }
        c1=0;
        c2=0;
        for(int i=1;i<=N;i++)
        {
            if(!t1[i] && !t2[i])
            {
                bfs(i);
            }
        }
        System.out.println(c1);
        for(int i=1;i<=N;i++)
            if(t1[i])
                System.out.print(i+" ");
        System.out.println("\n"+c2);
        for(int i=1;i<=N;i++)
            if(t2[i])
                System.out.print(i+ " ");
    }
    static void bfs(int start)
    {
        t1[start] = true;
        c1 ++;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Boolean> fq = new LinkedList<>();
        fq.offer(false);
        q1.offer(start);
        while (!fq.isEmpty() && !q1.isEmpty())
        {
            int ss=q1.poll();
            boolean flag = fq.poll();


            for(int i=1;i<=N;i++)
            {
                if(!t1[i] && !t2[i] && map[ss][i] == 1)
                {
                    if(flag) {
                        t1[i] = true;
                        c1++;
                    }else {
                        t2[i] = true;
                        c2++;
                    }
                    fq.offer(!flag);
                    q1.offer(i);
                }
            }
        }
    }
}
