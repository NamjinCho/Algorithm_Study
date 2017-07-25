/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class GoodNumber {
    static int Answer;
    static int [] arr;
    static boolean maps[];
    static int N;
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
        //maps = new boolean[];
        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {

            // Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////

            N = sc.nextInt();
            arr=new int[N];
            int Max = -1;
            for(int i=0;i<N;i++)
            {
                arr[i]=sc.nextInt();
                Max = Math.max(arr[i],Max);
            }
            Answer=0;
            maps=new boolean[Max+1];
            for(int i=1;i<N;i++)
            {
                if(maps[arr[i]]) {
                    Answer++;
                    continue;
                }
                if(algorithm(0,0,0,i))
                {
                    Answer++;
                    maps[i] = true;
                }
            }
            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
    public static boolean algorithm(int index,int count,int sum,int target)
    {

        if(index==target)
            return false;

        if(count==3)
        {
            if (arr[target]==sum)
                 return true;
            else {
                if(sum<=N)
                maps[sum] = true;
                return false;
            }
        }else
        {
            if((algorithm(index,count+1,sum+arr[index],target)))
                return true;
            else {
                return (algorithm(index + 1, count, sum, target));
            }
        }
    }
}