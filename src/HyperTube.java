import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-01.
 */
public class HyperTube {

    static class Node {
        int idx;
        ArrayList<Node> conn;
    }

    static int N;
    static Node[] nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M, K;
        N = sc.nextInt();
        K = sc.nextInt();
        M = sc.nextInt();
        nodes = new Node[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node();
            nodes[i].idx = i;
            nodes[i].conn = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int arr[] = new int[K];
            for (int j = 0; j < K; j++) {
                arr[j] = sc.nextInt();
            }
            for (int j = 0; j < K; j++) {
                Node start = nodes[arr[j]];
                for (int h = 0; h < K; h++) {
                    if (j != h) {
                        Node ele = nodes[arr[h]];
                        start.conn.add(ele);
                    }
                }
            }
        }
        int ans = bfs();
        System.out.println(ans);
    }

    static int bfs() {
        int visit[] = new int[N + 1];
        visit[1] = 1;

        Queue<Node> q = new LinkedList<>();
        q.offer(nodes[1]);

        while (!q.isEmpty()) {
            Node n = q.poll();
            for (int i = 0; i < n.conn.size(); i++) {
                Node con = n.conn.get(i);
                if (con.idx == N) {
                    return visit[n.idx] + 1;
                }
                if (visit[con.idx] == 0) {
                    visit[con.idx] = visit[n.idx] + 1;
                    q.offer(con);
                }

            }
        }
        return -1;
    }


}
