import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-17.
 */
public class Stick {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int total = 64;
        int ans=0;
        //int min = 64;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(total);
        while (N!=total)
        {
          int min = pq.poll();
          int half = min/2;
          if(total - half >= N)
          {
              pq.offer(half);
              total = total-half;
          }else
          {
              pq.offer(half);
              pq.offer(half);
          }

        }
        System.out.println(pq.size());
    }
}
