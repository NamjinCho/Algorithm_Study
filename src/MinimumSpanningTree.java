import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-03.
 */
public class MinimumSpanningTree {

    /*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/


    static int Answer;

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


            int graph[][] = new int[N+1][N+1];

            ArrayList<Integer> mst = new ArrayList<>();
            ArrayList<Integer> costs = new ArrayList<>();
            for ( int i=0;i<M;i++)
            {
                int start = sc.nextInt();
                int end = sc.nextInt();
                int cost = sc.nextInt();
                graph[start][end] =  cost;
                graph[end][start] =  cost;
            }
            int start = 1;
            mst.add(start);
            while(mst.size()!=N)
            {
                int min = Integer.MAX_VALUE;
                int index = -1;
                int startIndex = -1;
                for(int j=0;j<mst.size();j++) {

                    for (int i = 1; i <= N; i++) {
                        if (!mst.contains(i) &&graph[mst.get(j)][i]!=0 &&graph[mst.get(j)][i] < min )
                        {
                            min = graph[mst.get(j)][i];
                            index = i;
                            startIndex = mst.get(j);
                        }
                    }
                }
                if(index!=-1)
                {
                    mst.add(index);
                    costs.add(graph[startIndex][index]);
                }
            }
            Answer = 0;
            for(Integer item : costs)
                Answer+=item;

            Answer /= costs.size();


            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }
}

