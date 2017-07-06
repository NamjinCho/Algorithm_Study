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
class MazeRoom {
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

        int T = Integer.parseInt(sc.nextLine());
        System.out.println("");
        int arr[]=new int[7];
        for (int test_case = 0; test_case < T; test_case++) {

            // Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
           // String s = sc.nextLine();
            //int N = Integer.parseInt(s.split(" ")[0]);
            //int K = Integer.parseInt(s.split(" ")[1]);
            //String move = sc.nextLine();
            int N = test_case + 2;
            int board[] = new int[N - 1];
            int count = 4;

            if (N == 2)
                count = 3;

            for (int i = 0; i * 2 < N; i++) {
                if (i == 0)
                    board[i] = count;
                else
                    board[i] = board[i - 1] + count;
                // N 이 짝수
                System.out.println(count);
                if (N % 2 == 0) {

                    if (i + 1 == N / 2) {
                        count += 3;
                    } else
                        count += 4;

                    board[i] = count;
                    board[N-2-i] = count;


                } else {
                    count += 4;
                    board[i] = count;
                    board[N - i - 2] = count;

                }

            }

            for (int i = 0; i < N-1; i++)
                System.out.print(board[i] + " ");
            System.out.print("\n");


            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }
}