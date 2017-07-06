/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.util.Scanner;
import java.util.ArrayList;
/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class DeleteBlock {
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
            int arr[] = new int[N];
            int total = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int left[] = new int[N];
            int right[] = new int[N];
            int count =1;
            for(int i=0;i<N;i++)
            {
                if(arr[i] >= count)
                {
                    left[i] = count;
                    count++;
                }else {
                    if(left[i-1] > left[i])
                        count = arr[i];
                    else
                        count = 1;
                    left[i]=count;
                    count++;
                }
            }
            count=1;
            for(int i=N-1;i>=0;i--)
            {
                if(arr[i]>=count)
                {
                    right[i]=count;
                    count++;
                }else
                {
                    if(right[i+1] > right[i])
                        count=arr[i];
                    else
                        count=1;
                    right[i]=count;
                    count++;
                }
            }
            int max = Integer.MIN_VALUE;
            for(int i=0;i<N;i++)
            {
                left[i] = Math.min(left[i],right[i]);
                max= Math.max(left[i],max);
            }

            Answer = max;
            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }
}