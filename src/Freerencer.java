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
 */class Freerencer {
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

            // Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            int W = sc.nextInt();

            int arr[][] = new int[W][2];

            int pay [] = new int[W];

            for(int j=0;j<2;j++) {
                for (int i = 0; i < W; i++) {
                    arr[i][j] = sc.nextInt();
                }
            }


            pay[0] = Math.max(arr[0][0],arr[0][1]);
            pay[1] = Math.max(pay[0]+arr[1][0],arr[1][1]);

            for(int i=2;i<W;i++)
            {
                pay[i] = Math.max(pay[i-1]+arr[i][0],pay[i-2]+arr[i][1]);
            }

            //Answer = max;
            Answer = pay[W-1];
            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}