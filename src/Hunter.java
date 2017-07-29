import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by NamjinCho on 2017-07-28.
 */
public class Hunter {

    static class Point implements Comparable<Point>{

        int x;
        int y;
        boolean desc;
        Point (int x,int y,boolean f)
        {
            this.x=x;
            this.y=y;
            this.desc = f;
        }
        @Override
        public int compareTo(Point o) {
            if(!desc) {
                if (this.x > o.x)
                    return 1;
                else
                    return -1;
            }else
            {
                if (this.x < o.x)
                    return 1;
                else
                    return -1;
            }
        }
    }
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=0;tc<T;tc++)
        {
            PriorityQueue<Point> pq = new PriorityQueue<>();

            int N = sc.nextInt();
            for(int i=0;i<N;i++)
            {
                Point p = new Point(sc.nextInt(),sc.nextInt(),false);
                pq.offer(p);
            }
            Point start = pq.poll();
            double dist ;
            BigDecimal total = new BigDecimal(0);
            Stack<Point> stack = new Stack<>();
            stack.push(start);
            while(!pq.isEmpty())
            {
                Point next = pq.poll();
                if(start.y <= next.y || pq.isEmpty()) {
                    double t1 = (double) (start.x - next.x);
                    double t2 = (double) (start.y - next.y);
                    t1 *= t1;
                    t2 *= t2;
                    dist = Math.sqrt(t1 + t2);
                    total = total.add(new BigDecimal(dist));
                    start=next;
                }else
                {
                    stack.push(next);
                }
            }
            if(stack.size()==1)
                total = total.multiply(new BigDecimal(2+""));
            else {
                while (!stack.isEmpty()) {
                    Point next = stack.pop();
                    double t1 = (double) (start.x - next.x);
                    double t2 = (double) (start.y - next.y);
                    t1 *= t1;
                    t2 *= t2;
                    dist = Math.sqrt(t1 + t2);
                    total = total.add(new BigDecimal(dist));
                    start = next;
                }

            }
            String r = total.toString();
            System.out.println(total.toString());

        }
    }
}
