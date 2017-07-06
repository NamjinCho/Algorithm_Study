import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-03.
 */
public class ChessRoad {

    static long Answer;
    static long facts[];
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
            int N = sc.nextInt();
            int M = sc.nextInt();
            int B = sc.nextInt();

            facts = new long[N+M +1];
            System.out.println("g");
            long a = fact((N+M));
            System.out.println("a = " +  a);
            long b = fact(N);
            System.out.println("b = " +  b);
            long c= fact(M);
            System.out.println("c = " +  c);
            Answer = a/(b*c);
            for(int i=0;i<B;i++)
            {
                int row = sc.nextInt();
                int col = sc.nextInt();

                if(row >0 && row <= N && col >0 && col <N)
                {
                    long tempA = fact(row +col);

                    long tempB = fact(row);
                    long tempC = fact(col);
                    long temp = tempA/tempB*tempC;
                    System.out.println(temp);
                    row = N-row;
                    col = M-col;

                    long tempA2 = fact(row +col);

                    long tempB2 = fact(row);
                    long tempC2 = fact(col);
                    long temp2= tempA/tempB*tempC;
                    System.out.println(temp2);
                    temp = temp*temp2;

                    Answer-=temp;
                }
            }


            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }

    }

    public static long fact(int n)
    {
        if(facts[n] >0 )
            return facts[n];

        if(n == 1)
            return 1;

        long num = (fact(n-1)*n)%1000000007;

        facts[n]=num;
        return num;
    }

}
