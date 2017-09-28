import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-27.
 */
public class Olimpik {

    static class Node implements Comparable<Node>{
        int idx;
        int arr[] = new int[3];

        Node (int id,int ar[])
        {
            idx = id;
            for(int i=0;i<3;i++)
                arr[i] = ar[i];
        }
        @Override
        public int compareTo(Node o) {

            for(int i=0;i<3;i++)
            {
                if(arr[i] < o.arr[i])
                    return -1;
                else if(arr[i] > o.arr[i])
                    return 1;
            }
            return 0;
        }
    }
    public static void main(String [] args)
    {
        Scanner sc= new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        Node nodes[] = new Node[N+1];
        for(int i=1;i<=N;i++)
        {
            int id = sc.nextInt();
            int ar[] = new int[3];
            ar[0] = sc.nextInt();
            ar[1] = sc.nextInt();
            ar[2] = sc.nextInt();
            Node n = new Node(id,ar);
           nodes[id] = n;
        }
        Node prv = null;

        int rank = 1;


        for(int i=1;i<=N;i++)
        {
            if(i==K)
                continue;
            if(nodes[i]==null)
                continue;
            if(nodes[K].compareTo(nodes[i])==-1)
                rank++;
        }

        System.out.println(rank);

    }
}
