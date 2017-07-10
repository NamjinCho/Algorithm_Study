/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import javafx.util.Pair;

import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class SimilarNumber {
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

            int min = Integer.MAX_VALUE;
            for(int i=N-1;i>=1;i--)
            {
                if(isSNum(N,i)) {
                    min = i;
                    i=i/2;
                    i++;
                    //break;
                }
            }
            Answer = min;
            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
    public static boolean isSNum(int num , int N)
    {
        int tmp = 0;
        int start = num%N;
        num = num/N;
        while(num!=0)
        {
            tmp = (num%N);
            if (tmp!=start)
                return false;
            num = num/N;
        }
        return true;
    }
    public static boolean isSimilarNum(String nums)
    {
        if(nums.contains(","))
        {
            nums=nums.trim();
            String sub[] = nums.split(",");

            int start = Integer.parseInt(sub[0]);

            //System.out.println(start);
            for(int i=1;i<sub.length;i++)
            {
                int tmp = Integer.parseInt(sub[i]);
                if(tmp!=start)
                {
                    // System.out.println(start + " / " +tmp);
                    return false;
                }
            }

            return true;
        }else
        {
            int start = Integer.parseInt(nums.charAt(0)+"");
            for(int i=1;i<nums.length();i++)
            {
                int tmp = Integer.parseInt(nums.charAt(i)+"");
                if(tmp!=start)
                    return false;
            }
            return true;
        }
    }
}