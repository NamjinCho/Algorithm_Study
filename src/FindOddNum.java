/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class FindOddNum {
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
        class LongObject{
            long index;
        }

        for(int test_case = 0; test_case < T; test_case++) {

            // Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////


            int N = sc.nextInt();
            long arr[] = new long[N];
            HashMap<Long,Integer> maps = new HashMap<>();

            for(int i=0;i<N;i++)
            {
                long temp = sc.nextLong();
                arr[i] = temp;
                if(maps.containsKey(temp))
                {
                    maps.put(temp,maps.get(arr[i])+1);
                }else {
                    maps.put(temp, 1);
                }
            }



            long uint = 0;
            boolean flag=false;
            for(int i=0;i<N;i++)
            {
                if(maps.containsKey(arr[i])&&maps.get(arr[i])%2==1) {
                    if (!flag) {
                        uint = arr[i];
                        flag = true;
                    } else {
                        uint = uint ^ arr[i];
                    }
                    maps.remove(arr[i]);
                }

            }
            String answer = Long.toUnsignedString(uint);
            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(answer);
        }
    }
}