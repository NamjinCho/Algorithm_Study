import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-06-29.
 */
public class maxHello {
    public static int Answer = 0;
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
        String tmp = sc.nextLine();
        for(int test_case = 0; test_case < T; test_case++) {

            // Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            String str = sc.nextLine().trim();
            //hello
            int [] arr = new int [4];
            for(int i=0;i<str.length();i++)
            {
                if(str.charAt(i)=='h')
                {
                    arr[0]++;
                }else if(str.charAt(i)=='e')
                {
                    arr[1]++;
                }else if(str.charAt(i)=='l')
                {
                    arr[2]++;
                }else if(str.charAt(i)=='o')
                {
                    arr[3]++;
                }
            }
            int numOfL = arr[2]/2;
            for(int i=0;i<4;i++) {
                if(i==2)
                    continue;
                if (arr[i] < numOfL)
                {
                    numOfL = arr[i];
                }
            }
            Answer = numOfL;
            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
