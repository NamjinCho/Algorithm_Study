
import java.util.ArrayList;
import java.util.LinkedList;
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
        ArrayList<Integer> con;
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
                nodes[i].con = new ArrayList<>();
            }
            for (int i = 0; i < N; i++) {
                int did = sc.nextInt();

                nodes[did].danger = true;
            }
            for (int i = 0; i < NE; i++) {

                int s = sc.nextInt();
                int e = sc.nextInt();

                nodes[s].con.add(e);
                nodes[e].con.add(s);
            }
            int ans = bfs();
            System.out.println("#"+tc);
            System.out.println(ans);
        }

    }

    public static int bfs() {
        boolean visit[][] = new boolean[N + 1][V + 1];

        visit[0][S] = true;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> count = new LinkedList<>();
        count.offer(0);
        q.offer(S);
        int min = N;
        while (!q.isEmpty()) {
            int co = count.poll();
            int idx = q.poll();

            int size = nodes[idx].con.size();

            for (int i = 0; i < size; i++) {
                int next = nodes[idx].con.get(i);
                if (next == E) {
                    min = Math.min(co, min);
                    break;
                }
                if (nodes[next].danger && co < min) {
                    visit[co + 1][next] = true;
                    q.offer(next);
                    count.offer(co + 1);
                } else {
                    if (!visit[co][next]) {
                        visit[co][next] = true;
                        q.offer(next);
                        count.offer(co);
                    }
                }

            }

        }

        return min;

    }

}
