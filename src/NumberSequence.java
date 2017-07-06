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
class NumberSequence {
    static long Answer;

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

        long T = sc.nextInt();
        for(long test_case = 0; test_case < T; test_case++) {

            // Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            int N = sc.nextInt();
            long [] arr=  new long[N];

            boolean checker = false;
            Answer = 0;
            long max = Integer.MIN_VALUE;
            long min = Integer.MAX_VALUE;
            long diff[] = new long[N];
            for(int i=0;i<N;i++)
            {
                arr[i] = sc.nextLong();
                if(i!=0)
                {
                    max = Math.max((arr[i]-arr[i-1]),max);
                    min = Math.min((arr[i] - arr[i-1]),min);
                    if(checker)
                    {
                        if(max != 0)
                        {
                            Answer = -1;
                        }
                    }
                    if(arr[i] - arr[i-1]== 0)
                    {
                        checker = true;
                    }
                }
            }

            if(Answer==-1 && checker)
            {
                Answer++;
            }else
            {
                if(min==max)
                {
                    if(min==0)
                        Answer++;

                    while(min!=0 )
                    {
                        Answer++;
                        min=min/2;
                        if(min%2 == 1)
                            break;
                    }

                    if(min!=0)
                        Answer++;
                }else
                {
                    if(gcd(min,max)==1)
                        Answer=1;
                    else {
                        min = gcd(min, max);
                        if(min==0)
                            Answer++;

                        while(min!=0 )
                        {
                            Answer++;
                            min=min/2;
                            if(min%2 == 1)
                                break;
                        }

                        if(min!=0)
                            Answer++;
                    }
                }
            }
            // Prlong the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }

    }


    public static long gcd(long n1, long n2)
    {
        long temp;
        if (n1 < n2) {
            temp = n1;
            n1 = n2;
            n2 = temp;
        }
        while (n2 != 0) {
            temp = n1%n2;
            n1 = n2;
            n2 = temp;
        }
        return n1;
    }



}