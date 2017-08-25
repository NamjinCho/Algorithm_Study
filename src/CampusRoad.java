/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.util.*;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Node implements Comparable<Node> {
    int index;
    int dist;

    public int compareTo(Node p) {
        if (this.dist < p.dist)
            return 1;
        else if (this.dist > p.dist)
            return -1;
        else
            return 0;
    }
}

class CampusRoad {
    static int Answer;
    static int maps[][];
    static int visit[];

    public static void main(String args[]) throws Exception {
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
            int N = sc.nextInt();
            int M = sc.nextInt();

            maps = new int[N + 1][N + 1];

            int mins[] = new int[N + 1];

            visit = new int[N + 1];


            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= N; j++) {
                    if (i != j)
                        maps[i][j] = Integer.MAX_VALUE;
                }
            }

            for (int i = 0; i < M; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int d = sc.nextInt();
                maps[s][e] = d;
                maps[e][s] = d;

                mins[s] = Integer.min(d, mins[s]);
                mins[e] = Integer.min(d, mins[e]);

            }
            for (int i = 1; i <= N; i++) {
                dijkstra(i, N);
            }
            Answer = 0;
            for (int i = 1; i <= N; i++) {
                if (visit[i] < 1)
                    Answer++;
            }
            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.print(Answer + " ");
            for (int i = 1; i <= N; i++) {
                if (visit[i] < 1) {
                    if (i != N)
                        System.out.print(i + " ");
                    else
                        System.out.print(i);
                }
            }
            System.out.println();
            //System.out.println(Answer);
        }
    }

    public static void dijkstra(int start, int N) {

        int count = 0;
        //초기화
        boolean check[] = new boolean[N + 1];
        int dist[] = new int[N + 1];
        PriorityQueue<Node> que = new PriorityQueue<>();

        for (int j = 1; j <= N; j++) {
            Node node = new Node();
            node.index = j;
            node.dist = maps[start][j];
            dist[j] = maps[start][j];
            que.add(node);
        }
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        check[start] = true;

        int prev = start;
        //다익스트라 알고리즘
        int[] preD = new int[N + 1];
        for(int i = 1; i<=N;i++){
            min = Integer.MAX_VALUE;
            minIndex = -1;

            //다익스트라 최소값 구하기
            while(!que.isEmpty()) {
                Node node = que.poll();
                //System.out.print(node.index+" ");
                if (check[node.index] == false && node.dist != Integer.MAX_VALUE && node.dist < min) {
                    minIndex = node.index;
                    min = node.dist;
                    break;
                }
            }
            //System.out.print(minIndex+" " );
            //최소값 방문
            if (minIndex==-1)
                continue;
            check[minIndex] = true;


            //거리 갱신
            for (int j = 1; j <= N; j++) {
                if (!check[j] && maps[minIndex][j] != Integer.MAX_VALUE && dist[j] > dist[minIndex] + maps[minIndex][j]) {
                    dist[j] = dist[minIndex] + maps[minIndex][j];
                    preD[j] = minIndex;
                    Node node = new Node();
                    node.index = j;
                    node.dist = dist[j];
                    que.add(node);
                }
            }
        }
        for (int i = 1; i < N; i++) {
            int idx = i;
            System.out.print("\nStart : "+start + " / Dest : "+ i + " ");
             while(idx!=0) {
                 System.out.print(idx + " ");
                if (preD[idx]!=0)
                     visit[preD[idx]]++;
                 idx = preD[idx];
             }

        }
    }
}