/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
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

            maps  = new int[N + 1][N + 1];

            int mins[] = new int[N + 1];

            visit = new int[N+1];


            for(int i=0;i<=N;i++)
            {
                for(int j=0;j<=N;j++)
                {
                    if(i!=j)
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
            for(int i=1;i<=N;i++)
            {
                for(int j=1;j<=N;j++)
                {
                    if(i!=j && maps[i][j]==Integer.MAX_VALUE)
                        dijkstra(i,j,N);
                }
            }
            Answer = 0;

            System.out.println();
            for(int i=1;i<=N;i++) {
                System.out.print(visit[i]+" ");
                if (visit[i] < 2)
                    Answer++;
            }
            System.out.println();
                // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.print(Answer + " ");
            for (int i = 1; i <= N; i++) {
                if (visit[i]<2) {
                    if (i != N)
                        System.out.print(i + " ");
                    else
                        System.out.println(i);
                }
            }
            //System.out.println(Answer);
        }
    }

    public static void dijkstra(int start, int end, int N) {
        class Pair{
            int start;
            int end;
        }

        int count = 0;
        //초기화
        boolean check[] = new boolean[N+1];
        int dist[] = new int[N+1];

        for (int j = 1; j <= N; j++) {
            dist[j] = maps[start][j];
        }
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        check[start] = true;

        Stack<Integer> stack = new Stack<>();
        int prev = start;
        //다익스트라 알고리즘
        int[] preD = new int[N+1];
        while(true) {
            min = Integer.MAX_VALUE;
            minIndex = -1;

            //다익스트라 최소값 구하기
            for (int j = 1; j <= N; j++) {
                if (check[j] == false && dist[j] != Integer.MAX_VALUE && dist[j] < min) {
                    minIndex = j;
                    min = dist[j];
                    }
            }

            if(minIndex==end || minIndex == -1)
                break;


            //최소값 방문
            check[minIndex] = true;




            //거리 갱신
            for (int j = 1; j <= N; j++) {
                if (!check[j] && maps[minIndex][j] != Integer.MAX_VALUE && dist[j] > dist[minIndex] + maps[minIndex][j]) {
                    dist[j] = dist[minIndex] + maps[minIndex][j];
                }
            }
        }
    }
}