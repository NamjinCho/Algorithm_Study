/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.util.Arrays;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Lumbering {
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
            // 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.

            int n = sc.nextInt();

            int[] trees = new int[n];
            int[] lasers = new int[n];

            int[] cumulSum = new int[n];

            for(int i=0;i<n;i++){
                trees[i]=sc.nextInt();
            }

            int min= 200000;
            for( int i = 0 ;i<n;i++) {
                lasers[i] = sc.nextInt();
                if (min > lasers[i] - i) min = lasers[i]-i;

            }
            long ans = 0;
            for(int i=0;i<n;i++){
                if(trees[i] - min > 0) {
                    ans = ans + (trees[i] - min);
                }
            }

            // 이 부분에서 정답을 출력하십시오.
            System.out.println("Case #" + (test_case+1));
            System.out.println(ans);
            //1 3 5
            // 5 5 5
            //  3, 5, 6 -> 3 , 5, 5 -> 4, 6 , 6 -> 4 , 5 ,5
            // 0 , 1 , 1 = > 2
            //5 4 3
            //5 6 3
            // 5 5 5 , 0 0

            // 3 5 7 //
            // Print the answer to standard output(screen).

        }
    }
}