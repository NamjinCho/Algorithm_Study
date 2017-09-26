import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-22.
 */
public class Card {
    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=N;i++)
            q.offer(i);

        Queue<Integer> q2 = new LinkedList<>();
        while(q.size()!=1)
        {
            int del = q.poll();
            int last = q.poll();
            q.offer(last);
            q2.offer(del);
        }

        while(!q2.isEmpty())
            System.out.print(q2.poll()+" ");
        System.out.println(q.poll());

    }
}
