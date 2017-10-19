
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-13.
 */
public class SaftySalseman {
    static int V, S, E, N;

    static class Node {
        int idx;
        boolean danger;
        int count = 0;
        int[] con;
    }
    static class Data{
        int idx;
        Data next;

    }
    static class Que{
        Data head;
        Data last;
        int size = 0;

        public void add(int i)
        {
            Data d = new Data();
            d.idx = i;
            System.out.println(i + " " + head);

            if(head==null)
            {
                head = d;
                last = head;
                System.out.println( head  + " " + last);
            }else
            {
                last.next = d;
                last = last.next;
            }

            size++;
        }
        public int get()
        {
            int result = last.idx;
            size--;
            last = last.next;
            return result;
        }
    }


    static Node[] nodes;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            V = sc.nextInt();
            int NE = sc.nextInt();
            S = sc.nextInt();
            E = sc.nextInt();


            N = sc.nextInt();
            nodes = new Node[V + 1];
            for (int i = 1; i <= V; i++) {
                nodes[i] = new Node();
                nodes[i].idx = i;
                nodes[i].con=new int[V+1];
            }
            for (int i = 0; i < N; i++) {
                int did = sc.nextInt();

                nodes[did].danger = true;
            }
            for (int i = 0; i < NE; i++) {

                int s = sc.nextInt();
                int e = sc.nextInt();
                nodes[s].con[nodes[s].count++] = e;
                nodes[e].con[nodes[e].count++] = s;
            }
            int ans = bfs();
            System.out.println("#"+tc);
            System.out.println(ans);
        }

    }

    public static int bfs() {
        boolean visit[][] = new boolean[N + 1][V + 1];

        visit[0][S] = true;
        Que q = new Que();
        q.add(S);
        Que count = new Que();
        count.add(0);
        int min = N;
        while (q.size!=0) {
            int co = count.get();
            int idx = q.get();

            int size = nodes[idx].count;

            for (int i = 0; i < size; i++) {
                int next = nodes[idx].con[i];
                if (next == E) {
                    min = Math.min(co, min);
                    break;
                }
                if (nodes[next].danger && co < min) {
                    visit[co + 1][next] = true;
                    q.add(next);
                    count.add(co + 1);
                } else {
                    if (!visit[co][next]) {
                        visit[co][next] = true;
                        q.add(next);
                        count.add(co);
                    }
                }

            }

        }

        return min;

    }

}
