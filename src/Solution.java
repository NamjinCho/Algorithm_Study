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
class Solution {
    static int Answer;
    static int N;
    static int arr[];
    static int maxPoint;
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
            N = sc.nextInt();
            int S = sc.nextInt();
            arr = new int[N+1];
            Answer = Integer.MIN_VALUE;
            int total = 0;
            for(int i=1;i<=N;i++)
            {
                arr[i]=sc.nextInt();
                total+=arr[i];
            }

           // System.out.println(total);
            int [] table =new int[total+1];
            for(int i=1;i<=N;i++)
            {
                table[arr[i]] = 1;
            }

            int min=Integer.MAX_VALUE;

            for(int i=1;i<=total;i++)
            {
                boolean tmp[] = new boolean[table.length];
                for(int j=1;j<=total;j++)
                {

                    if(table[j]>0 && tmp[j]==false)
                    {
                        if( i==1 && j==5)
                            if(i==j && table[i] == 1)
                                continue;

                            if(j+i <= total){

                                int t1 = table[i+j];
                                int t2 = table[i]+table[j];
                                if(t1 == 0)
                                {
                                    table[i+j] = t2;
                                    tmp[i+j] = true;
                                    if(i+j>=S)
                                        min= Math.min(t2,min);
                                }
                                else if(t1 > t2)
                                {
                                    table[i+j] = t2;
                                    tmp[i+j] = true;
                                    if(i+j>=S)
                                        min = Math.min(t2,min);
                                }
                            }

                    }
                }
            }

            Answer = min;
            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }


}