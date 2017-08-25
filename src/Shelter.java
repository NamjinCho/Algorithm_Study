import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-21.
 */

public class Shelter {
    static class Node implements Comparable<Node> {
        int idx;
        int weight;

        @Override
        public int compareTo(Node o) {
            if (this.weight > o.weight)
                return 1;
            else if (this.weight == o.weight)
                return 0;
            else
                return -1;
        }
    }

    public static int[][] arr;
    static int N;
    static int K;
    static boolean shelters[];
    static int ans =0;
    static int ans2 = 0;
    public static void main(String[] args) {
            /*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {

            // Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            N = sc.nextInt();
            int M = sc.nextInt();
            K = sc.nextInt();
            arr = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i != j)
                        arr[i][j] = Integer.MAX_VALUE;
                }
            }

            for (int i = 0; i < M; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int d = sc.nextInt();
                arr[s][e] = d;
                arr[e][s] = d;
            }

            shelters = new boolean[N + 1];
            for (int i = 0; i < K; i++) {
                int idx = sc.nextInt();
                shelters[idx] = true;
            }
            ans = 0 ;
            ans2 = 0;
            for(int i=1;i<=N;i++)
                dijkstra(i);
            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(ans);
            System.out.println(ans2);

        }
    }

    public static void dijkstra(int start) {

        if (shelters[start]) {
            ans2 += start;
            return;
        }
        PriorityQueue<Node> que = new PriorityQueue<>();
        int dist[] = new int[N + 1];
        for (int j = 1; j <= N; j++) {
            Node node = new Node();
            node.idx = j;
            node.weight = arr[start][j];
            dist[j] = arr[start][j];
            que.offer(node);
        }
        int minIdx = -1;
        int min = Integer.MAX_VALUE;
        boolean[] visit = new boolean[N + 1];
        visit[start] = true;
        while (!que.isEmpty()) {

            int tmin = Integer.MAX_VALUE;
            int tidx = -1;

            Node n = que.poll();
           // System.out.println(start + " -- " + n.idx);
            if (n.weight != Integer.MAX_VALUE && !visit[n.idx]) {
                tmin = n.weight;
                tidx = n.idx;
            } else
                continue;

            if (shelters[tidx] && tmin < min) {
                min = tmin;
                minIdx = tidx;
            }else if(shelters[tidx] && tmin == min && tidx<minIdx)
            {
                min = tmin;
                minIdx = tidx;
            }
            visit[tidx] = true;
            for (int i = 1; i <= N; i++) {
                if (arr[tidx][i] != Integer.MAX_VALUE && dist[i] > dist[tidx] + arr[tidx][i]) {
                    Node tn = new Node();
                    tn.idx = i;
                    tn.weight = dist[tidx] + arr[tidx][i];
                    que.offer(tn);
                    dist[i] = tn.weight;
                }
            }
        }
        ans = ans+min;
        ans2+=minIdx;
    }


}

