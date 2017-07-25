/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution3 {
    static int Answer;

    public static void main(String args[]) throws Exception	{
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
        for(int test_case = 0; test_case < T; test_case++) {


            int N = sc.nextInt();

            int ls = 0;
            int r = sc.nextInt();
            int le = sc.nextInt();

            int arr[] = new int[N];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
                min = Math.min(min, arr[i]);
                max = Math.max(arr[i], max);
            }
            Answer = 0;
            if ((le) % (2*r) != 0) {
                if ((le/ r/2) + 1 > N)
                    Answer = -1;
            } else
            {
                if ((le/r/2)  > N)
                    Answer = -1;
            }
            if(Answer!=-1)
            {
                int left = 0;
                int right = 0;



            }
            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}