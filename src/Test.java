/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Test {
    static int Answer;
    static HashMap<Integer,Integer> memo;
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
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(list.size()-1);
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));
        memo = new HashMap<>();
        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {

            Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////

            int K = sc.nextInt();

            BigInteger max = new BigInteger("1");
            BigInteger binary = new BigInteger("2");
            for(int i=0;i<K;i++)
            {
                max = max.multiply(binary);
            }
            int i=1;

            while(true)
            {
                if(functions(i)==K)
                    break;
                i++;
            }
            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(i + " " + max.toString());
        }
    }
    public static int functions(int N)
    {
        int count =0;
        while(N !=1)
        {
            if(N%2 == 0)
                N=N/2;
            else
                N=3*N+1;
            count++;
        }
        return count;
    }
}