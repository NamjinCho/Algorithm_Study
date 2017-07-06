/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import org.omg.CORBA.LongLongSeqHelper;
import org.omg.CORBA.LongLongSeqHolder;

import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution2 {
    static String Answer;

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
            int K = sc.nextInt();

            int dn = 0;

            if( K >2) {
                K++;
                int start = 0;
                int end = 31;
                int mid = (start + end)/2 ;
                int weight = 0;
                // System.out.println(mid);
                for(int i=1;i<31;i++)
                {
                    if(K < Math.pow(2,(i+1))) {
                        dn = i;
                        break;
                    }
                }

                int left = K - (int)(Math.pow(2,dn));


                String leftBinary = de2bi(left,dn);
                leftBinary = leftBinary.replace("0","4");
                leftBinary = leftBinary.replace("1","7");
                Answer =leftBinary;
            }else {
                if(K==1) {
                    dn = 0;
                    Answer = "4";
                }else
                {
                    dn = 0;
                    Answer = "7";
                }
            }
            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);

        }
    }

    public static String de2bi(int num, int dn) {
        if( num < 0 )
            num = 0;
        String binaryString = Integer.toBinaryString(num);

        int length = binaryString.length();


        int tmp = dn - length;
        String tmpStr = "";
        for(int i =0;i<tmp;i++)
            tmpStr+="0";

        binaryString = tmpStr+binaryString;
        return binaryString;
    }
}