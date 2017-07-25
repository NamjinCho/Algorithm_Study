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
class Hanoi {
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
            int N = sc.nextInt();


            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            hanoi(N,1,2,3);
            //System.out.println(Answer);
        }
    }
    static void move(int from, int to){
        System.out.println(from + " -> " + to);
    }

    static void hanoi(int n, int from, int by, int to){
        if (n == 1)
            move(from, to);
        else{
            hanoi(n - 1, from, to, by);
            move(from, to);
            hanoi(n - 1, by, from, to);
        }
    }
}