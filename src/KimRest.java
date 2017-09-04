import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-04.
 */
public class KimRest {
    static class Order implements Comparable<Order>{
        int table;
        int time;

        @Override
        public int compareTo(Order o) {

            if(this.time < o.time)
                return -1;
            else if(this.time == o.time)
            {
                if(this.table<o.table)
                    return -1;
                else
                    return 1;
            }else
                return 1;
        }
    }
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String sub[] = line.split(" ");
        int N = Integer.parseInt(sub[0]);
        int M = Integer.parseInt(sub[1]);

        Order orders[] = new Order[M+1];
        ArrayList<Order> list = new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            line = sc.nextLine();
            if(line.startsWith("order"))
            {
                sub=line.split(" ");
                int table = Integer.parseInt(sub[1]);
                int time = Integer.parseInt(sub[2]);
                orders[table] = new Order();
                orders[table].table = table;
                orders[table].time = time;
                list.add(orders[table]);

            }else if(line.startsWith("sort"))
            {
                list.sort(null);
            }
            else
            {
                sub=line.split(" ");
                int table = Integer.parseInt(sub[1]);
                list.remove(orders[table]);
            }
            if(list.size()==0)
                System.out.println("sleep");
            else {
                for (int j = 0; j < list.size(); j++)
                    System.out.print(list.get(j).table + " ");
                System.out.println();
            }
        }

    }



}
