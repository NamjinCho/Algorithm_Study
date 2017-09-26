import java.util.*;

/**
 * Created by NamjinCho on 2017-09-22.
 */
public class PrinterQueue {

    static class Node implements Comparable<Node>{
        int idx;
        int cost;
        Node(int id,int co)
        {
            idx = id;
            cost = co;
        }
        @Override
        public int compareTo(Node o) {
            if(cost > o.cost)
                return -1;
            else if(cost<o.cost)
                return 1;
            return 0;
        }
    }
    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);
        int T =sc.nextInt();
        ArrayList<Node> list = new ArrayList<>();
        for(int tc=0;tc<T;tc++)
        {
            list = new ArrayList<>();
            int N = sc.nextInt();
            int W = sc.nextInt();
            for(int i=0;i<N;i++) {
                int co = sc.nextInt();
                list.add(new Node(i,co));
            }
            int ans =1;
            while(true)
            {
                Node t = list.get(0);
                boolean f = true;
                for(int i=1;i<list.size();i++)
                {
                    if(list.get(i).cost > t.cost) {
                        f = false;
                        break;
                    }
                }
                if(f)
                {
                    if(W==t.idx)
                        break;
                    list.remove(0);
                    ans++;
                }else
                {
                    list.remove(0);
                    list.add(t);
                }
            }
            System.out.println(ans);

        }



    }
}
