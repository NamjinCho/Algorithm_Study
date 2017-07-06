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
class MirrorRoom {
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

        int T = Integer.parseInt(sc.nextLine());
        for(int test_case = 0; test_case < T; test_case++) {

             Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            int N = Integer.parseInt(sc.nextLine());
            int room[][] = new int[N][N];
            boolean visit[][] = new boolean[N][N];

            for(int y=0;y<N;y++)
            {

                String line = sc.nextLine();
                for(int x=0;x<N;x++)
                {
                    room[y][x] = Integer.parseInt(line.charAt(x)+"");
                }
            }


            int x = -1;
            int y = 0;

            int dirVector[][] = {{1,0},{0,+1},{-1,0},{0,-1}};
            int dir = 0;
            x = x+dirVector[dir][0];
            y = y+dirVector[dir][1];

            while((x>=0 && x < N) &&(y>=0&&y<N)){
                if(room[y][x] >0 ) // 거울 조우
                {
                    //1 = /
                    //2 = \

                    if(!visit[y][x])
                    {
                        visit[y][x] = true;
                        Answer++;
                    }

                    if(room[y][x] == 1)
                    {
                        if(dir==0)
                            dir=3;
                        else if(dir == 1)
                            dir = 2;
                        else if(dir == 2)
                            dir = 1;
                        else
                            dir = 0;
                    }else
                    {
                        if(dir==0)
                            dir=1;
                        else if(dir == 1)
                            dir = 0;
                        else if(dir == 2)
                            dir = 3;
                        else
                            dir = 2;

                    }

                }
                x = x+dirVector[dir][0];
                y = y+dirVector[dir][1];

            }

            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}