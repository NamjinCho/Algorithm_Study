/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class GoodNumber {
    static int Answer;
    static int[] arr;
    static boolean maps[];
    static int N;

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
        //maps = new boolean[];
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
            arr = new int[N];
            int max = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
                max = Math.max(arr[i],max);
            }
            boolean check [][] = new boolean[max+1][3];

            Answer = 0;

            for(int i=0;i<N;i++)
            {
                if(check[arr[i]][2]) {
                    Answer++;
                }
                check[arr[i]][0] = true;
                for(int j=arr[i]+1;j<=max;j++)
                {
                    check[j][1] = check[j-arr[i]][0] || check[j][1];
                    check[j][2] = check[j-arr[i]][1] || check[j][2];
                }
            }

            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }

    }

}